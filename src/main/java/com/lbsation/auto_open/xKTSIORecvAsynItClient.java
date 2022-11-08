package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class xKTSIORecvAsynItClient {
    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};


    public static void main(String args[]) throws IOException, InterruptedException, InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound {

        try {

            //initialize orb
            Properties props = System.getProperties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            //Replace MyHost with the name of the host on which you are running the server
            props.put("org.omg.CORBA.ORBInitialHost", "localhost");
            ORB orb = ORB.init(args, props);
            System.out.println("Initialized ORB");

            //Instantiate Servant and create reference
            POA rootPOA = POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));
            xKTSIOImpl listener = new xKTSIOImpl();
            rootPOA.activate_object(listener);
            xKTSIO ref = xKTSIOHelper.narrow(
                    rootPOA.servant_to_reference(listener));

//            EquipInfo equipInfo = (EquipInfo) PortableRemoteObject.narrow(ref, EquipInfo.class);// line 127

            //Resolve MessageServer
            xKTSIO xKTSIOServer = xKTSIOHelper.narrow(
                    orb.string_to_object("corbaname:iiop:1.2@localhost:1050#xKTSIOServer"));
//            xKTSIOServer.echoString("@@@@@@@@@@");
            //Register listener reference (callback object) with MessageServer

//            KTSIOMsg ktsioMsg = setKTSIOMsg(orb);

            xKTSIOServer.recvAsyncIt(setKTSIOMsg(orb), ref);

            System.out.println("Listener registered with xKTSIOServer");

            //Activate rootpoa
            rootPOA.the_POAManager().activate();

            //Wait for messages
            System.out.println("Wait for incoming messages");
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KTSIOMsg setKTSIOMsg(ORB orb) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        KTSIOMsgHolder ktsioMsgHolder = new KTSIOMsgHolder();
        Any[] anyArray = new Any[1];
        anyArray[0] = orb.create_any();

        stKtAgwAlarmExtEventHelper.insert(anyArray[0], new stKtAgwAlarmExtEvent().setStKtAgwAlarmExtEvent());
//        StatEventStHelper.insert(anyArray[0], new StatEventSt().setStatEventSt());
//        stKtAgwAlarmExtEventHelper.insert(anyArray[0], new stKtAgwAlarmExtEvent());


        ////            Any any = orb.create_any();
        KTSIOMsg ktsioMsg = new KTSIOMsg("SLGA12132", (short) 6, (short) 3,
                (short) 3, 7, 0, (short) 0, (short) 0, (short) 0, (short) 0,
                (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, anyArray);

        return ktsioMsg;
    }



}
