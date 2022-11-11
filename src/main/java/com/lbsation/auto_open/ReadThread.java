package com.lbsation.auto_open;

import KTCosNMS.KTSIOMsg;
import KTCosNMS.xAGWPackage.stKtAgwAlarmExtEvent;
import KTCosNMS.xAGWPackage.stKtAgwAlarmExtEventHelper;
import com.lbsation.auto_open.configuartion.RedisConfiguration;
import com.lbsation.auto_open.enums.AgwTypeCode;
import com.lbsation.auto_open.enums.MsgType;
import com.lbsation.auto_open.model.AlarmModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Any;
import redis.clients.jedis.*;

import java.util.Objects;

@Slf4j
public class ReadThread extends Thread {


    xKTSIOImpl xKTSIOImpl = null;

    public ReadThread(xKTSIOImpl xKTSIOImpl) {
        this.xKTSIOImpl = xKTSIOImpl;
    }


    public void run() {
        ObjectMapper mapper = new ObjectMapper();

        try (JedisCluster clusterPool = RedisConfiguration.jedisCluster()) {
//        try (Jedis jedis = RedisConfiguration.JedisConnect()) {
            try {

                for (; ; ) {
                    System.out.println("### <START> ###");

//                    clusterPool.rpush("NMS_ALARM_INFO", "{\"ONOFF\":\"ON\",\"TYPE\":\"ONE\",\"ALARM\":[{\"ALARM_KEY\":\"7159490584401412116\",\"TID\":\"GBGMS4764\",\"MASTER_TID\":\" \",\"AGW_NAME\":\"4형_1_MGID1838_192.168.0.103\",\"AGW_TYPE\":\"4\",\"MIH_IP\":\"192.168.0.103\",\"AGW_ID\":\"8c3f9000f46d4c2f9c11c0d546bbe4dd\",\"GROUP_ID_1\":\"0f685b98926949108f0be865b58f60f6\",\"GROUP_ID_2\":\"0438290e9edb47b2a2277f8c531c3449\",\"GROUP_ID_3\":\"196bf3e42d6e46ca855611ccb9e6569e\",\"GROUP_ID_4\":\"15fa070e32544f6b90605d226bdb3cbf\",\"GROUP_NAME_1\":\"대구본부\",\"GROUP_NAME_2\":\"경북유선센터\",\"GROUP_NAME_3\":\"구미\",\"GROUP_NAME_4\":\"4공단BBS\",\"ALARM_CODE\":\"CONN\",\"ALARM_GRADE\":\"DIS\",\"CREATE_TIME\":\"2022-10-28 18:20:01\",\"INFORMATION\":\"TDXAGW DISCONNECTED\"}]}\n");
//                log.info("clusterPool: {}", clusterPool.getClusterNodes());
                    String alarmStr = Objects.requireNonNull(clusterPool).blpop(60*60*24*30, "NMS_ALARM_INFO").get(1);
                    if (!StringUtils.isEmpty(alarmStr)) {
                        log.info("alarmStr: {}", alarmStr);
                        // redis Data
                        AlarmModel alarmModel = mapper.readValue(alarmStr, AlarmModel.class);
                        log.info("alarmModel: {}", alarmModel);
                        //
                        Any[] anyArray = new Any[1];
                        anyArray[0] = xKTSIOImpl._orb().create_any();
                        stKtAgwAlarmExtEventHelper.insert(anyArray[0], setStKtAgwAlarmExtEvent(alarmModel));


                        //                    in_KtSioMsg.msgBody = AnyUtils.getRecvAsyncItAny(xKTSIOImpl._orb());
                        // set Data AND return client
                        KTSIOMsg ktsioMsg = setKTKtsioMsg(anyArray);
                        if(xKTSIOImpl.xKTSIOs != null){
                            xKTSIOImpl.xKTSIOs.recvAsyncIt(ktsioMsg, xKTSIOImpl.xKTSIOs);
                            System.out.println("### Server RecvAsyncIt CALL ### : "+ ktsioMsg);
                        }
                        else{

                            System.out.println("### xKTSIOs NULL ### : ");
                        }
                        //                    xKTSIOImpl.echoString("###CALL");

                    }
                }

            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }
    public stKtAgwAlarmExtEvent setStKtAgwAlarmExtEvent(AlarmModel alarmModel){

        return new stKtAgwAlarmExtEvent(AgwTypeCode.MERCURY_AGW.getAgwTypeCode(),
                alarmModel.getTid(), alarmModel.getAlarmCode(), setNativeDeviceName(alarmModel), 0xffffffff
                , alarmModel.getAlarmData().getServerity()
                ,  (short)0, "0",  (short)0,  (short)0,  (short)0,  (short)0,  (short)0,  (short)27,  (short)0
                , alarmModel.getCreateTime(), alarmModel.getInformation(), "()", "");
    }
    public  KTSIOMsg setKTKtsioMsg(Any[] anyArray){
          return new KTSIOMsg("SLGA12132", (short) 6, (short) 3,
                  MsgType.MSGTYPE_Alarm.getMsgType(), 0x7A000000
                  , 0, (short) 0, (short) 0, (short) 0, (short) 0
                  , (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, anyArray);

    }
    //각사 고유의 Location 정보( '/'를 // 구분자로 한다 )
    public String setNativeDeviceName(AlarmModel alarmModel){
        return alarmModel.getGroupName1() + "/" + alarmModel.getGroupName2() + "/" + alarmModel.getGroupName3() + "/" + alarmModel.getGroupName4();
    }
}
