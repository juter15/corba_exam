package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.enMsgType;
import KTCosNMS.xAGWPackage.stKtAgwAlarmExtEvent;
import KTCosNMS.xAGWPackage.stKtAgwAlarmExtEventHelper;
import com.lbsation.auto_open.configuartion.RedisConfiguration;
import com.lbsation.auto_open.enums.AgwTypeCode;
import com.lbsation.auto_open.enums.AlarmData;
import com.lbsation.auto_open.enums.OnOff;
import com.lbsation.auto_open.model.AlarmModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Any;
import org.omg.CORBA_2_3.ORB;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Service
public class NotiThread implements Runnable {

    private final AtomicBoolean running = new AtomicBoolean(false);
    private static final ORB orb = CorbaDemoApplication.getORB();

    String clientIOR = null;
    private Thread worker;
    private StatusThread st = new StatusThread();

//    public ReadThread(xKTSIOImpl xKTSIOImpl) {
////        this.xKTSIOImpl = xKTSIOImpl;
//        System.out.println("@@@ ReadThread @@@");
//    }

    public void setIOR(String ior) {
        clientIOR = ior;

    }


    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
        System.out.println("### STOP ###");
    }

    public AtomicBoolean getRunStatus() {
        return running;
    }


    public void run() {
        running.set(true);
        xKTSIO xKTSIOClient = null;
        String ior = clientIOR;

        System.out.println("### START ### : NOTI : " + xKTSIOClient + "clientIOR: {}" + clientIOR);
        ObjectMapper mapper = new ObjectMapper();

        try (JedisCluster clusterPool = RedisConfiguration.jedisCluster()) {
//        try (Jedis jedis = RedisConfiguration.JedisConnect()) {
            try {
//                org.jacorb.orb.ORB orb = new org.jacorb.orb.ORB();
                System.out.println("### IOR ### " + clientIOR);
                while (running.get()) {

                    if (!ior.equals(clientIOR)) {
                        break;
                    }
                    if (xKTSIOClient == null) {
                        if (clientIOR == null) {
                            System.out.println("### IOR NULL ### ");

                        }
                        xKTSIOClient = xKTSIOHelper.narrow(orb.string_to_object(clientIOR));
                        System.out.println("### SET xKTSIOClient ### ");
                        st.setxKTSIO(xKTSIOClient);
                        if (st.getRunStatus().get()) {
                            st.stop();
                            Thread.sleep(1000);
                            st.start();
                        } else {
                            st.start();
                        }
                    }

//                    }
//                    Thread.sleep(1000);
//                    clusterPool.rpush("NMS_ALARM_INFO", "{\"ONOFF\":\"ON\",\"TYPE\":\"ONE\",\"ALARM\":[{\"ALARM_KEY\":\"7159490584401412116\",\"TID\":\"GBGMS4764\",\"MASTER_TID\":\" \",\"AGW_NAME\":\"4???_1_MGID1838_192.168.0.103\",\"AGW_TYPE\":\"4\",\"MIH_IP\":\"192.168.0.103\",\"AGW_ID\":\"8c3f9000f46d4c2f9c11c0d546bbe4dd\",\"GROUP_ID_1\":\"0f685b98926949108f0be865b58f60f6\",\"GROUP_ID_2\":\"0438290e9edb47b2a2277f8c531c3449\",\"GROUP_ID_3\":\"196bf3e42d6e46ca855611ccb9e6569e\",\"GROUP_ID_4\":\"15fa070e32544f6b90605d226bdb3cbf\",\"GROUP_NAME_1\":\"????????????\",\"GROUP_NAME_2\":\"??????????????????\",\"GROUP_NAME_3\":\"??????\",\"GROUP_NAME_4\":\"4??????BBS\",\"ALARM_CODE\":\"CONN\",\"ALARM_GRADE\":\"DIS\",\"CREATE_TIME\":\"2022-10-28 18:20:01\",\"INFORMATION\":\"TDXAGW DISCONNECTED\"}]}\n");
//                    log.info("clusterPool: {}", clusterPool.getClusterNodes());

//                    String alarmStr = Objects.requireNonNull(clusterPool).blpop(60 * 60 * 24 * 30, "NMS_ALARM_INFO").get(1);
                    String alarmStr = Objects.requireNonNull(clusterPool).lpop("NMS_ALARM_INFO");
//                    log.info("@@@ alarmList: {}", alarmList);
                    if (!StringUtils.isEmpty(alarmStr)) {
                        log.info("alarmStr: {}", alarmStr);
                        // redis Data
                        AlarmModel alarmModel = mapper.readValue(alarmStr, AlarmModel.class);

                        Any[] anyArray = new Any[1];
                        anyArray[0] = orb.create_any();
                        stKtAgwAlarmExtEventHelper.insert(anyArray[0], setStKtAgwAlarmExtEvent(alarmModel));


                        KTSIOMsg ktsioMsg = setKTKtsioMsg(anyArray, alarmModel);
                        log.info("{}", ktsioMsg);
//                        Thread.sleep(1000);
                        try {
                            xKTSIOClient.recvAsyncIt(ktsioMsg, xKTSIOClient);
                            System.out.println("### NOTI RecvAsyncIt CALLED ### ");
                            if (alarmModel.getOnoff().equals(OnOff.ON)) {
                                saveNotiHistory(clusterPool, alarmModel, alarmStr);
                            } else {
                                delNotiHistory(clusterPool, alarmModel);
                            }

                        } catch (Exception e) {
                            System.out.println("### NOTI RecvAsyncIt ERROR ### " + e.getMessage());
//                            clusterPool.rpush("NMS_ALARM_INFO", alarmStr);
//                            running.set(false);
                        }

//                        if (xKTSIOImpl.xKTSIOs != null) {
//                            xKTSIOImpl.xKTSIOs.recvAsyncIt(ktsioMsg, xKTSIOImpl.xKTSIOs);
//                            log.info("### Server RecvAsyncIt CALL ### : {}", ktsioMsg);
//                        } else {

//                            System.out.println("### xKTSIOs NULL ### : ");
//                        }
                        //                    xKTSIOImpl.echoString("###CALL");

                    }
                }
                System.out.println("### Thead EXIT ###");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public stKtAgwAlarmExtEvent setStKtAgwAlarmExtEvent(AlarmModel alarmModel) {
        stKtAgwAlarmExtEvent stKtAgwAlarmExtEvent = new stKtAgwAlarmExtEvent();
        stKtAgwAlarmExtEvent = new stKtAgwAlarmExtEvent(AgwTypeCode.MERCURY_AGW.getAgwTypeCode(),
                alarmModel.getTid(), alarmModel.getAlarmCode(), setNativeDeviceName(alarmModel), 0xffffffff
                , alarmModel.getAlarmData().getServerity()
                , (short) 0, "", (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0
                , alarmModel.getCreateTime(), alarmModel.getInformation(), "", "");
        if (alarmModel.getOnoff().equals(OnOff.OFF)) {
            stKtAgwAlarmExtEvent = new stKtAgwAlarmExtEvent(AgwTypeCode.MERCURY_AGW.getAgwTypeCode(),
                    alarmModel.getTid(), alarmModel.getAlarmCode(), setNativeDeviceName(alarmModel), 0xffffffff
                    , AlarmData.CLEAR.getServerity()
                    , (short) 0, "", (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0
                    , alarmModel.getCreateTime(), alarmModel.getInformation(), "", "");
        }
        log.info("{}", stKtAgwAlarmExtEvent);
        return stKtAgwAlarmExtEvent;
    }

    /*
     * neType: ???
     * */
    public KTSIOMsg setKTKtsioMsg(Any[] anyArray, AlarmModel alarmModel) {
        KTSIOMsg ktsioMsg = new KTSIOMsg(alarmModel.getTid(), (short) 6, (short) enVendorCode._VENDOR_Mercury,
                (short) enMsgType.MSGTYPE_Alarm.value(), xAGW.OPCODE_ALARM_EVENT
                , 0, (short) 0, (short) 0, (short) 0, (short) 0
                , (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, anyArray);

        return ktsioMsg;
    }

    //?????? ????????? Location ??????( '/'??? // ???????????? ?????? )
    public String setNativeDeviceName(AlarmModel alarmModel) {
        return alarmModel.getGroupName1() + "/" + alarmModel.getGroupName2() + "/" + alarmModel.getGroupName3() + "/" + alarmModel.getGroupName4();
    }

    public void saveNotiHistory(JedisCluster clusterPool, AlarmModel alarmModel, String alarmStr) {
        Map<String, String> tidAndCode = new HashMap<>();
        // ?????? OFF??? ??????
        String[] alaramArray = alarmStr.split("OFF");
        log.info("alaramArray: {}", alaramArray);
        String alarmCommand = alaramArray[0] + "OFF" + alaramArray[1].replaceFirst("ON", "OFF");
        clusterPool.hset("NMS_ALARM", alarmModel.getTid() + "_" + alarmModel.getAlarmCode(), alarmCommand);
        log.info("### NOTI HISTORY SAVE: {}", clusterPool.hget("NMS_ALARM", alarmModel.getTid() + "_" + alarmModel.getAlarmCode()));
    }

    public void delNotiHistory(JedisCluster clusterPool, AlarmModel alarmModel) {
        log.info("### NOTI HISTORY DEL: {}", clusterPool.hget("NMS_ALARM", alarmModel.getTid() + "_" + alarmModel.getAlarmCode()));
        clusterPool.hdel("NMS_ALARM", alarmModel.getTid() + "_" + alarmModel.getAlarmCode());
    }

}
