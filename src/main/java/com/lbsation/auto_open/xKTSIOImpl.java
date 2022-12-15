package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.*;
import KTCosNMS.xAGWPackage.EquipInfo;
import KTCosNMS.xAGWPackage.EquipInfoHelper;
import com.lbsation.auto_open.configuartion.DbConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Any;
import org.omg.CORBA_2_3.ORB;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.UUID;
import java.util.Vector;

@Slf4j
@Service
public class xKTSIOImpl extends xKTSIOPOA {
    private Vector clients = new Vector();
    private Connection conn = null;
    public xKTSIO xKTSIOs = null;
    private NotiThread rt = new NotiThread();
    private StatusThread st = new StatusThread();

    private static final String myIOR = CorbaDemoApplication.getIor();
    private static final ORB orb = CorbaDemoApplication.getORB();


//    public xKTSIOImpl() {
//        rt = new ReadThread(this);
//    }
//
//
////    public static void startReadThread() {
////
////        rt.start();
////    }

    @Override
    public void recvIt(KTSIOMsg in_KtSioMsg, KTSIOMsgHolder out_KtSioMsg) {
        log.info("hax: {}", String.format("%x", in_KtSioMsg.opCode)); // -> 7D000001
        ;

        log.info("xKTSIO: {}", xKTSIOs);

//        in_KtSioMsg.msgBody.
        log.info("in_KtSioMsg: {}", in_KtSioMsg);
        log.info("out_KtSioMsg: {}", out_KtSioMsg);

        if (xAGW.OPCODE_REQP_Open_Session == in_KtSioMsg.opCode) {
            String ior = stKtAgwSessionInfoHelper.extract(in_KtSioMsg.msgBody[0]).eocmsMdIOR;
            System.out.println("### GET SESSION: " + ior);
            log.info(ior);
            rt.setIOR(ior);
            st.setIOR(ior);


            try {
                if (rt.getRunStatus().get()) {
                    rt.stop();
                    Thread.sleep(1000);
                    rt.start();
                } else {
                    rt.start();
                }

                if (st.getRunStatus().get()) {
                    st.stop();
                    Thread.sleep(1000);
                    st.start();
                }
                else{
                    st.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (xAGW.OPCODE_REQP_TDX_AGW_EQUIP_CONFIG == in_KtSioMsg.opCode) {
            // DB SAVE

            EquipInfo equipInfo = EquipInfoHelper.extract(in_KtSioMsg.msgBody[0]);
            log.info("equipInfo: {}", equipInfo);
            log.info("conn: {}", conn);
            AutoOpenHistoryInsert(equipInfo);
        } else if (xAGW.OPCODE_REQP_EMS_CONFIG == in_KtSioMsg.opCode) {
//            EmsInfoSt emsInfoStIn = EmsInfoStHelper.extract(in_KtSioMsg.msgBody[0]);
//            log.info("### INPUT emsInfoSt: {}", emsInfoStIn);
            //
            if (out_KtSioMsg.value.msgBody != null) {
                Any[] anyArray = new Any[1];
                anyArray[0] = _orb().create_any();

                EmsInfoStHelper.insert(anyArray[0], xKTSIORecvItClient.setEmsInfoSt());
                out_KtSioMsg.value.msgBody = anyArray;

                log.info("newKtSioMsg: {}", out_KtSioMsg);


//                recvIt(null, out_KtSioMsg);
//                recvIt(in_KtSioMsg, out_KtSioMsg);
            }
        } else {
            log.info("### DEF OPCODE : {}", in_KtSioMsg.opCode);
        }
    }

    //USED
    @Override
    public void recvAsyncIt(KTSIOMsg in_KtSioMsg, xKTSIO in_replyKTSIO) {
//        xKTSIOs = in_replyKTSIO;


        System.out.println("*** Receive AsnycIt in_KtSioMsg: " + in_KtSioMsg);
        Any[] anyArray = in_KtSioMsg.msgBody;
        if(in_KtSioMsg.opCode == xAGW.OPCODE_ALARM_EVENT){
            System.out.println("*** Receive AsnycIt stKtAgwAlarmExtEventH: " + stKtAgwAlarmExtEventHelper.extract(anyArray[0]));
            System.out.println("*** ---------------------------------------: ");
        }
        else if(in_KtSioMsg.opCode == xAGW.OPCODE_STATE_EVENT){
            System.out.println("*** Receive AsnycIt StateChangeEventSt: " + StateChangeEventStHelper.extract(anyArray[0]));
            System.out.println("*** ---------------------------------------: ");
        }

    }

    @Override
    public void recvBulkIt(KTSIOMsg[] in_KtSioMsgSeq, KTSIOMsgSeqHolder out_KtSioMsgSeq) {

    }

    @Override
    public void recvAsyncBulkIt(KTSIOMsg[] in_KtSioMsgSeq, xKTSIO in_replyKTSIO) {

    }



//    public static void a(){
//        a.
//    }


    public void AutoOpenHistoryInsert(EquipInfo equipInfo) {
        conn = DbConfiguration.dbConnect();
        String sql = "INSERT INTO AUTO_OPEN_HISTORY_T"
                + "(AO_HISTORY_ID, EQUIP_OP_CODE, EQUIPMENT_ID, MANAGED_IP, HEADQUARTER_ID," +
                "HEADQUARTER_NAME, NSC_ID, NSC_NAME, OMC_ID, OMC_NAME," +
                "OFFICE_ID, OFFICE_NAME, RSS_OFFICE_ID, RSS_OFFICE_NAME, EQUIPMENT_NAME," +
                "READ_COMMUNITY, WRITE_COMMUNITY, EMS_IP, EQUIP_USAGE_CODE, CLASS_TYPE_CODE," +
                "VENDOR_CODE, MODEL_NAME, MODEL_NAME_SCODE, INSTALL_LOCATION, ADDR1," +
                "DEGREE, SNMP_VERSION, SPC, SPC_ALIAS, EQUIPMENT_NAME2," +
                "MAIN_CLS_TYPE, SUB_CLS_TYPE, OLT_NES_CODE, OLT_MST_IP, OLT_NE_ALIAS," +
                "OLT_MODEL_NAME, OLT_NE_USG_CODE, RN_NES_CODE, RN_NE_ALIAS, RN_MODEL_NAME," +
                "RN_NE_USAGE_CODE, OLT_LINK_IP, SLLN, IPSEC_GW_IP, TRAP_COMMUNITY," +
                "MAC, MG_ID, UPDATE_TIME)"
                + "VALUES("
                + createInsertQuery(UUID.randomUUID().toString().replaceAll("-", ""))
                + createInsertQuery(equipInfo.equipOpCode)
                + createInsertQuery(equipInfo.equipmentId)
                + createInsertQuery(equipInfo.managedIp)
                + createInsertQuery(equipInfo.headquarterId)
                + createInsertQuery(equipInfo.headquarterName)
                + createInsertQuery(equipInfo.nscId)
                + createInsertQuery(equipInfo.nscName)
                + createInsertQuery(equipInfo.omcId)
                + createInsertQuery(equipInfo.omcName)

                + createInsertQuery(equipInfo.officeId)
                + createInsertQuery(equipInfo.officeName)
                + createInsertQuery(equipInfo.rssofficeId)
                + createInsertQuery(equipInfo.rssofficeName)
                + createInsertQuery(equipInfo.equipmentName)
                + createInsertQuery(equipInfo.readCommunity)
                + createInsertQuery(equipInfo.writeCommunity)
                + createInsertQuery(equipInfo.emsIp)
                + createInsertQuery(equipInfo.equipUsageCode)
                + createInsertQuery(equipInfo.classTypeCode)

                + createInsertQuery(equipInfo.vendorCode)
                + createInsertQuery(equipInfo.modelName)
                + createInsertQuery(equipInfo.modelNameSCode)
                + createInsertQuery(equipInfo.installLocation)
                + createInsertQuery(equipInfo.addr1)
                + createInsertQuery(equipInfo.degree)
                + createInsertQuery(equipInfo.snmpversion)
                + createInsertQuery(equipInfo.spc)
                + createInsertQuery(equipInfo.spcAlias)
                + createInsertQuery(equipInfo.equipmentName2)

                + createInsertQuery(equipInfo.mainClsType)
                + createInsertQuery(equipInfo.subClsType)
                + createInsertQuery(equipInfo.oltNesCode)
                + createInsertQuery(equipInfo.oltMstIp)
                + createInsertQuery(equipInfo.oltNeAlias)
                + createInsertQuery(equipInfo.oltModelName)
                + createInsertQuery(equipInfo.oltNeUsgCode)
                + createInsertQuery(equipInfo.rnNesCode)
                + createInsertQuery(equipInfo.rnNeAlias)
                + createInsertQuery(equipInfo.rnModelName)

                + createInsertQuery(equipInfo.rnNeUsgCode)
                + createInsertQuery(equipInfo.oltLinkIp)
                + equipInfo.slln + ","
                + createInsertQuery(equipInfo.ipsecgwIp)
                + createInsertQuery(equipInfo.trapCommunity)
                + createInsertQuery(equipInfo.mac)
                + createInsertQuery(equipInfo.mgid)
//                + new Date() + ","
                + null + ")";
//                + createInsertQuery(equipInfo.id).replace(",", "") + ")"; // Update User Id
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.executeUpdate();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }

    }

    public String createInsertQuery(String contents) {
        return "'" + contents + "',";
    }
}



