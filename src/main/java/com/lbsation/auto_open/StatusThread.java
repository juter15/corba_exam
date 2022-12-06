package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbsation.auto_open.configuartion.RedisConfiguration;
import com.lbsation.auto_open.enums.AgwTypeCode;
import com.lbsation.auto_open.enums.AlarmData;
import com.lbsation.auto_open.enums.OnOff;
import com.lbsation.auto_open.model.AlarmModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Any;
import org.omg.CORBA_2_3.ORB;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Service
public class StatusThread implements Runnable {

    private final AtomicBoolean running = new AtomicBoolean(false);
    private static final ORB orb = CorbaDemoApplication.getORB();
    //    xKTSIOImpl xKTSIOImpl = null;
    String clientIOR = null;
    private Thread worker;

    public void stop() {
        running.set(false);
        System.out.println("### STOP ###");
    }


    public void setIOR(String ior) {
        clientIOR = ior;

    }


    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public AtomicBoolean getRunStatus() {
        return running;
    }


    public void run() {
        running.set(true);
        xKTSIO xKTSIOClient = null;

        System.out.println("### START ### : xKTSIOClient : " + xKTSIOClient + "clientIOR: {}" + clientIOR);
        ObjectMapper mapper = new ObjectMapper();

//        try (Jedis jedis = RedisConfiguration.JedisConnect()) {
        try {
//                org.jacorb.orb.ORB orb = new org.jacorb.orb.ORB();
            System.out.println("### IOR ### " + clientIOR);
            while (running.get()) {
                Thread.sleep(1000 * 60 * 5);
                if (xKTSIOClient == null) {
                    if (clientIOR == null) {
                        System.out.println("### IOR NULL ### ");

                    }
                    xKTSIOClient = xKTSIOHelper.narrow(orb.string_to_object(clientIOR));
                    System.out.println("### SET xKTSIOClient ### ");
                }

                Any[] anyArray = new Any[1];
                anyArray[0] = orb.create_any();

                StateChangeEventStHelper.insert(anyArray[0], setStateChangeEventSt());

                KTSIOMsg ktsioMsg = setKTKtsioMsg(anyArray);
                log.info("{}", ktsioMsg);
//                        Thread.sleep(1000);
                try{
                    xKTSIOClient.recvAsyncIt(ktsioMsg, xKTSIOClient);
                    System.out.println("### State RecvAsyncIt CALLED ### ");
                }
                catch (Exception e){
                    System.out.println("### State RecvAsyncIt ERROR ### " + e.getMessage());
//                            clusterPool.rpush("NMS_ALARM_INFO", alarmStr);
//                            running.set(false);
                }
            }

            System.out.println("### Thead EXIT ###");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StateChangeEventSt setStateChangeEventSt(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return new StateChangeEventSt("EMS", "EMS", "NMS0000", "", "S", "", dateFormat.format(new Date()));
    }

    public KTSIOMsg setKTKtsioMsg(Any[] anyArray) {
        KTSIOMsg ktsioMsg = new KTSIOMsg("EMS", (short) 6, (short) enVendorCode._VENDOR_Mercury,
                (short) enMsgType.MSGTYPE_5MinNoti.value(), xAGW.OPCODE_STATE_EVENT
                , 0, (short) 0, (short) 0, (short) 0, (short) 0
                , (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, anyArray);

        return ktsioMsg;
    }
}
