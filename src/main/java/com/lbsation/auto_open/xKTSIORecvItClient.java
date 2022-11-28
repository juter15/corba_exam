package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.corba.se.impl.corba.ContextImpl;
import com.sun.corba.se.impl.ior.iiop.IIOPAddressImpl;
import com.sun.corba.se.impl.ior.iiop.IIOPProfileTemplateImpl;
import com.sun.corba.se.impl.orb.ORBSingleton;
import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.ior.IORFactories;
import com.sun.corba.se.spi.ior.iiop.IIOPAddress;
import com.sun.corba.se.spi.ior.iiop.IIOPProfileTemplate;
import com.sun.jndi.toolkit.corba.CorbaUtils;
import lombok.extern.slf4j.Slf4j;
import org.jacorb.orb.ParsedIOR;
import org.jacorb.orb.iiop.IIOPProfile;
import org.jacorb.orb.portableInterceptor.ORBInitInfoImpl;
import org.jacorb.orb.util.PrintIOR;
//import org.omg.CORBA.*;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA_2_3.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.IOP.IORHelper;
import org.omg.IOP.IORHolder;
import org.omg.PortableInterceptor.ORBInitInfo;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.springframework.context.annotation.Profile;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import java.io.*;
import java.net.URL;
import java.util.*;

import static org.jacorb.orb.util.PrintIOR.printIOR;

@Slf4j
public class xKTSIORecvItClient {
    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36267", "-ORBInitialHost", "localhost"};
    public static String ior = null;

    public static void main(String args[]) throws Exception {

//        try {

        //initialize orb
        Properties props = System.getProperties();
        props.put("com.sun.CORBA.ORBServerPort", "36268");
        props.put("com.sun.CORBA.ORBServerHost", "211.58.205.50");

        ORB orb = (ORB) ORB.init(ORB_OPTIONS, props);
//        ORB orb = (ORB) ORB.init();
//            ORB orb = ORB.init(ORB_OPTIONS, props);
        System.out.println("Initialized ORB");

        //Instantiate Servant and create reference
        POA rootPOA = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA"));
        xKTSIOImpl listener = new xKTSIOImpl();

        rootPOA.activate_object(listener);
        rootPOA.the_POAManager().activate();

        org.omg.CORBA.Object ref = rootPOA.servant_to_reference(listener);

        xKTSIO href = xKTSIOHelper.narrow(ref);


        org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);


        System.out.print("Got Ref.\nGetting naming context root ... ");


//        String corbaNameStr = "corbaname::localhost:36267#KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD";

        String corbaNameStr = "corbaname::61.98.79.244:36267#KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD";
        log.info("corbaNameStr: {}", corbaNameStr);
//        String corbaNameStr2 = "corbaname::14.63.156.52:36267#KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD";




        Object obj = orb.string_to_object(corbaNameStr);
        String iorStr = orb.object_to_string(obj);
//        log.info("iorStr: {}", iorStr);

        xKTSIO xKTSIOServer = xKTSIOHelper.narrow(orb.string_to_object(iorStr));
//        xKTSIO xKTSIOServer2 = xKTSIOHelper.narrow(orb.string_to_object("corbaname::61.98.79.244:36267#KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD"));
        org.omg.CORBA.Any[] anyArray = new org.omg.CORBA.Any[1];
        Any any = orb.create_any();
        anyArray[0] = any;

        KTSIOMsg ktsioMsgSession = setKTSIOMsg(orb, 1342177280);
        stKtAgwSessionInfoHelper.insert(anyArray[0], setStKtAgwSessionInfo(orb.object_to_string(href)));
        ktsioMsgSession.msgBody = anyArray;
        KTSIOMsgHolder ktsioMsgSessionHolder = new KTSIOMsgHolder(ktsioMsgSession);
        xKTSIOServer.recvIt(ktsioMsgSession, ktsioMsgSessionHolder);
        log.info("### CALL SESSION ### ");

        KTSIOMsg ktsioMsgEm = setKTSIOMsg(orb, 2080382976);
        EmsInfoStHelper.insert(anyArray[0], setEmsInfoSt());
        ktsioMsgEm.msgBody = anyArray;
        KTSIOMsgHolder ktsioMsgEmHolder = new KTSIOMsgHolder(ktsioMsgEm);
        xKTSIOServer.recvIt(ktsioMsgEm, ktsioMsgEmHolder);

        log.info("### CALL EMSINFO ### ");
        log.info("{}", EmsInfoStHelper.extract(ktsioMsgEmHolder.value.msgBody[0]));

        KTSIOMsg ktsioMsgEq = setKTSIOMsg(orb, 2097152001);
        EquipInfoHelper.insert(anyArray[0], setEquipInfo());
        ktsioMsgEq.msgBody = anyArray;
        KTSIOMsgHolder ktsioMsgEqHolder = new KTSIOMsgHolder(ktsioMsgEq);
        xKTSIOServer.recvIt(ktsioMsgEq, ktsioMsgEqHolder);
        log.info("### CALL EQUIPINFO ### ");


//        //---------------------
//        Properties env = new Properties();
//        env.put("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
//        env.put("java.naming.provider.url", "iiop://" + "14.63.156.52" +":"+"36267");
//        Context ic = new InitialContext(env);
//
//
//        NameComponent[] nameComp = new NameComponent[1];
//
//        NamingEnumeration nen = ic.list("/KT/AGW/EMOVE_NOMS2");
//        List<String> nameList = new ArrayList<>();
//        while (nen.hasMore()) {
//            System.out.println("@@@ "+nen.next());
//        }

//        //---------------------

        //Wait for messages
        orb.run();
    }

    public static KTSIOMsg setKTSIOMsg(ORB orb, int opCode) throws JsonProcessingException {


        KTSIOMsg ktsioMsg = new KTSIOMsg("sourceSys", (short) 1, (short) 1,
                (short) 1, opCode, 1, (short) 1, (short) 1, (short) 1, (short) 1,
                (short) 1, (short) 1, (short) 1, (short) 1, (short) 1, new Any[1]);

        return ktsioMsg;
    }

    public static EquipInfo setEquipInfo() {
        return new EquipInfo("I", "eqId", "managIp", "headrId", "headName",
                "nscId", "nscName", "omcId", "omcName", "ofId",
                "officeName", "rsoId", "rsoName", "eqName", "read",
                "write", "emsIp", "eqUCd", "cTCd", "vCd",
                "modelName", "mNCd", "itLo", "addr1", "dg",
                "v", "spc", "spcAlias", "eqN2", "mainClsType",
                "subClsType", "oNCd", "oltMstIp", "oltNeAlias", "oMl",
                "oUCd", "rnNesCode", "rnNeAlias", "rnMN", "rUCd",
                "oltLinkIp", 111, "ipsecgwIp", "tCom", "mac", "mgid");
    }

    public static EmsInfoSt setEmsInfoSt() {
        return  new EmsInfoSt("EMOVE_NOMS", "EOCMS", "61.98.79.244",
                "2022-11-24 13:30:48", "EOCMS5.1", "2017-04-01 00:00:00", setUsageStateEnum(), setCommonOptSt());

    }

    public static UsageStateEnum setUsageStateEnum(){
        return UsageStateEnum.ACTIVE_USAGESTATE;
    }

    public static CommonOptSt setCommonOptSt(){
        return new CommonOptSt("sun4v", "2017-04-01 00:00:00", "SunOS_EOCMS_T1_5.10_Generic_150400-40_sun4v_sparc_sun4v", "EOCMS description");
    }

    public static stKtAgwSessionInfo setStKtAgwSessionInfo(String ior){
        log.info("retrun : {}", ior);
        return new stKtAgwSessionInfo("testClient", ior);
    }
}
