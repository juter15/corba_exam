package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.*;
import com.lbsation.auto_open.configuartion.DbConfiguration;
import com.lbsation.auto_open.enums.RecvItType;
import lombok.extern.slf4j.Slf4j;
import org.jacorb.orb.ORBSingleton;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;

@Slf4j
@Service
public class xKTSIOImpl extends xKTSIOPOA {
    public static final String[] ORB_OPTIONS = new String[]{"-port", "36267", "-ORBServerHost", "61.98.79.244"};
//    public static final String[] ORB_OPTIONS = new String[]{"-port", "36267", "-ORBServerHost", "localhost"};
    private Vector clients = new Vector();
    public static String clientIOR = null;
    private Connection conn = null;
    public xKTSIO xKTSIOs = null;
    private static ReadThread rt = null;

    public xKTSIOImpl() {
        rt = new ReadThread(this);
    }

    public String getClientIOR(){
        return clientIOR;
    }
    public static void startReadThread() {

        rt.start();
    }

    @Override
    public void recvIt(KTSIOMsg in_KtSioMsg, KTSIOMsgHolder out_KtSioMsg){
        log.info("hax: {}", String.format("%x", in_KtSioMsg.opCode)); // -> 7D000001


        log.info("xKTSIO: {}", xKTSIOs);

//        in_KtSioMsg.msgBody.
        log.info("in_KtSioMsg: {}", in_KtSioMsg);
        log.info("out_KtSioMsg: {}", out_KtSioMsg);

        if(Integer.parseInt(RecvItType.SESSIONINFO.getTypeHax(), 16) == in_KtSioMsg.opCode){
            String ior = stKtAgwSessionInfoHelper.extract(in_KtSioMsg.msgBody[0]).eocmsMdIOR;
            log.info(ior);
            clientIOR = ior;

        }
        else if(Integer.parseInt(RecvItType.EQUIPIFO.getTypeHax(), 16) == in_KtSioMsg.opCode){
            // DB SAVE

            if (conn == null) {
                conn = DbConfiguration.dbConnect();
            }

            EquipInfo equipInfo = EquipInfoHelper.extract(in_KtSioMsg.msgBody[0]);
            log.info("equipInfo: {}", equipInfo);
            log.info("conn: {}", conn);
            AutoOpenHistoryInsert(equipInfo);
        }
        else if(Integer.parseInt(RecvItType.EMSINFO.getTypeHax(), 16) == in_KtSioMsg.opCode){
//            EmsInfoSt emsInfoStIn = EmsInfoStHelper.extract(in_KtSioMsg.msgBody[0]);
//            log.info("### INPUT emsInfoSt: {}", emsInfoStIn);
            //
            if(out_KtSioMsg.value.msgBody != null){
                Any[] anyArray = new Any[1];
                anyArray[0] = _orb().create_any();

                EmsInfoStHelper.insert(anyArray[0], xKTSIORecvItClient.setEmsInfoSt());
                out_KtSioMsg.value.msgBody = anyArray;

                log.info("newKtSioMsg: {}", out_KtSioMsg);


//                recvIt(null, out_KtSioMsg);
//                recvIt(in_KtSioMsg, out_KtSioMsg);
            }
        }
        else{
            log.info("### DEF OPCODE : {}", in_KtSioMsg.opCode);
        }
    }

    //USED
    @Override
    public void recvAsyncIt(KTSIOMsg in_KtSioMsg, xKTSIO in_replyKTSIO) {
        xKTSIOs = in_replyKTSIO;



        System.out.println("$$$ Receive AsnycIt in_KtSioMsg: " + in_KtSioMsg);
        Any[] anyArray = in_KtSioMsg.msgBody;
        System.out.println("$$$ Receive AsnycIt stKtAgwAlarmExtEventH: " + stKtAgwAlarmExtEventHelper.extract(anyArray[0]));

    }

    @Override
    public void recvBulkIt(KTSIOMsg[] in_KtSioMsgSeq, KTSIOMsgSeqHolder out_KtSioMsgSeq) {

    }

    @Override
    public void recvAsyncBulkIt(KTSIOMsg[] in_KtSioMsgSeq, xKTSIO in_replyKTSIO) {

    }

    @Override
    public String echoString(String message) {
        log.info("MESSGE: {}", message);
        xKTSIOs.echoString(message);
//        Iterator it = clients.iterator();
//
//        while (it.hasNext()) {
//            xKTSIO lt = (xKTSIO) it.next();
//            lt.echoString(message);
//            //FOR THE SIMPLER EXAMPLE, ADD A SIMPLE
//            //MESSAGE TO BE CALLED BACK, FOR EXAMPLE,
//            //SLEEP FOR 30 SECONDS, THEN SEND THE TIME
//        }
        System.out.println("### Server Message: " + message);
        return "## M ##";
    }

//    public static void a(){
//        a.
//    }


    public void AutoOpenHistoryInsert(EquipInfo equipInfo) {
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
                + createInsertQuery(equipInfo.modelNamesCode)
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
//            conn.close();
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }

    }

    public String createInsertQuery(String contents) {
        return "'" + contents + "',";
    }
}



