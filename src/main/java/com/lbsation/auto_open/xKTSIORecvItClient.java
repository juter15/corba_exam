package com.lbsation.auto_open;

import KTCosNMS.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class xKTSIORecvItClient {

    public static void main(String args[]) throws IOException, InterruptedException, InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound, WrongPolicy, ServantNotActive, ServantAlreadyActive, AdapterInactive {

//        try {

            //initialize orb
            Properties props = System.getProperties();
            props.put("org.omg.CORBA.ORBInitialPort", "36268");
            //Replace MyHost with the name of the host on which you are running the server
            props.put("org.omg.CORBA.ORBInitialHost", "61.98.79.244");
            ORB orb = ORB.init(args, props);
            System.out.println("Initialized ORB");

            //Instantiate Servant and create reference
            POA rootPOA = POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));
            xKTSIOImpl listener = new xKTSIOImpl();
            rootPOA.activate_object(listener);
            xKTSIO ref = xKTSIOHelper.narrow(
                    rootPOA.servant_to_reference(listener));

//        org.omg.CORBA.Object obj = orb.string_to_object(
//                "corbaloc::61.98.79.244:1050/NameService");
//        NamingContextExt initCtx = NamingContextExtHelper.narrow(obj);

            xKTSIO xKTSIOServer = xKTSIOHelper.narrow(
                    orb.string_to_object("corbaname:iiop:1.2@61.98.79.244:36268#BcN-NMS"));
//                    orb.string_to_object("corbaloc::61.98.79.244:1050/NameService"));

            KTSIOMsg ktsioMsg = setKTSIOMsg(orb);
            KTSIOMsgHolder ktsioMsgHolder = new KTSIOMsgHolder(ktsioMsg);

//            ref.recvIt(ktsioMsg, ktsioMsgHolder);
            xKTSIOServer.recvIt(ktsioMsg, ktsioMsgHolder);

//            xKTSIOServer.recvIt(ktsioMsg, ktsioMsgHolder);
            //Activate rootpoa
            rootPOA.the_POAManager().activate();

            //Wait for messages
            orb.run();

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static KTSIOMsg setKTSIOMsg(ORB orb) throws JsonProcessingException {

        org.omg.CORBA.Any[] anyArray = new org.omg.CORBA.Any[1];
        Any any = orb.create_any();

        anyArray[0] = any;
        EquipInfoHelper.insert(anyArray[0], setEquipInfo());


        KTSIOMsg ktsioMsg = new KTSIOMsg("sourceSys", (short) 1, (short) 1,
                (short) 1, 1, 1, (short) 1, (short) 1, (short) 1, (short) 1,
                (short) 1, (short) 1, (short) 1, (short) 1, (short) 1, anyArray);

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

}
