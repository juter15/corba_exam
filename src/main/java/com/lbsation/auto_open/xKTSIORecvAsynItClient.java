package com.lbsation.auto_open;

import KTCosNMS.*;
import KTCosNMS.xAGWPackage.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public class xKTSIORecvAsynItClient {
    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36267", "-ORBInitialHost", "61.98.79.244", "-ORBInitialHost", "61.98.79.244"};
//    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBServerHost", "localhost", "-ORBInitialHost", "localhost"};


    public static void main(String args[]) throws IOException, InterruptedException, InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound {

        try {
            System.out.println("### xKTSIORecvAsynItClient START ###");
            //initialize orb
            Properties props = System.getProperties();
            props.put("com.sun.CORBA.ORBServerPort", "36268");
            props.put("com.sun.CORBA.ORBServerHost", "211.58.205.50");
            ORB orb = ORB.init(ORB_OPTIONS, props);
            System.out.println("Initialized ORB");

            //Instantiate Servant and create reference
            POA rootPOA = POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));
            xKTSIOImpl listener = new xKTSIOImpl();
            rootPOA.activate_object(listener);
            xKTSIO ref = xKTSIOHelper.narrow(
                    rootPOA.servant_to_reference(listener));

            String corbaNameStr = "corbaname::61.98.79.244:36267#KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD";

            log.info("corbaNameStr: {}", corbaNameStr);


            Object obj3 = orb.string_to_object(corbaNameStr);
            String iorStr3 = orb.object_to_string(obj3);
            log.info("iorStr3: {}", iorStr3);

            xKTSIO xKTSIOServer = xKTSIOHelper.narrow(orb.string_to_object(iorStr3));
            xKTSIOServer.recvAsyncIt(setKTSIOMsg(orb), ref);

//        //---------------------
//        Properties env = new Properties();
//        env.put("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
//        env.put("java.naming.provider.url", "iiop://" + "localhost" +":"+"1049");
//        Context ic = new InitialContext(env);
//
//
//        NameComponent[] nameComp = new NameComponent[1];
//
//        NamingEnumeration nen = ic.list("/");
//        List<String> nameList = new ArrayList<>();
//        while (nen.hasMore()) {
//            System.out.println("@@@ "+nen.next());
//
//        }
//        //---------------------

            System.out.println("Listener registered with NMS-SERVER");

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
