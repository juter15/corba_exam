package com.lbsation.auto_open;

import KTCosNMS.KTSIOMsg;
import KTCosNMS.KTSIOMsgHolder;
import KTCosNMS.xAGWPackage.stKtAgwSessionInfoHelper;
import KTCosNMS.xKTSIO;
import KTCosNMS.xKTSIOHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Any;
import org.omg.CORBA.Object;
import org.omg.CORBA.UserException;
import org.omg.CORBA_2_3.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LocalApplication {
    public static ORB orb = null;


    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36267", "-ORBInitialHost", "localhost"};

//        public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36267", "-ORBServerHost", "localhost", "-ORBInitialHost", "localhost"};
    public static ORB getORB() {
        return orb;
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("### ation.com config3 ###");

        List<String> orbdStartupCommands = new ArrayList<>();

//        orbdStartupCommands.add("orbd");
//        orbdStartupCommands.addAll(Arrays.asList(ORB_OPTIONS));
//
//        Process orbdProcess = new ProcessBuilder(orbdStartupCommands).start();
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("NMS-SERVER Exiting ...");
//            orbdProcess.destroy();
//        }));

        TimeUnit.SECONDS.sleep(1);
        try {
            bindService(ORB_OPTIONS);
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        SpringApplication.run(LocalApplication.class, args);

    }

    private static void bindService(String[] options) throws UserException, FileNotFoundException, UnknownHostException, JsonProcessingException {
        Properties prop = new Properties();
        // 서버 실행 리슨포트 10000으로 설정
        prop.put("com.sun.CORBA.ORBServerPort", "36268");
        prop.put("com.sun.CORBA.ORBServerHost", "211.58.205.50");
//

        orb = (ORB) ORB.init(options, prop);

        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();


        xKTSIOImpl server = new xKTSIOImpl();

        Object ref = rootPOA.servant_to_reference(server);

        xKTSIO href = xKTSIOHelper.narrow(ref);

        Object objRef =
                orb.resolve_initial_references("NameService");

        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        NameComponent[] name = {
                new NameComponent("KT", ""),
                new NameComponent("AGW", ""),
                new NameComponent("EMOVE_NOMS2", ""),
                new NameComponent("KT_BCNNMS_MD", "")
        };

        String nameStr = ncRef.to_string(name);
        NameComponent[] theName = {
                new NameComponent(nameStr, "")
        };

        try {
            ncRef.rebind(name, href);
        } catch (NotFound nf) {

            createContextPath(ncRef, name);
            ncRef.rebind(name, href);
        }
//        ((com.sun.corba.se.spi.orb.ORB) orb).register_initial_reference("KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD", href);
        System.out.println("New account created and registered.  URLs are: ");
        System.out.println("\nIOR");
        System.out.println("\t" + orb.object_to_string(href));

        System.out.println("NMS-SERVER ready started and waiting request ...");

//        server.startReadThread();
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

        KTSIOMsg ktsioMsgSession = xKTSIORecvItClient.setKTSIOMsg(orb, 1342177280);
        stKtAgwSessionInfoHelper.insert(anyArray[0], xKTSIORecvItClient.setStKtAgwSessionInfo(orb.object_to_string(href)));
        ktsioMsgSession.msgBody = anyArray;
        KTSIOMsgHolder ktsioMsgSessionHolder = new KTSIOMsgHolder(ktsioMsgSession);
        xKTSIOServer.recvIt(ktsioMsgSession, ktsioMsgSessionHolder);
        log.info("### CALL SESSION ### ");
        orb.run();

    }

    public static void createContextPath(
            NamingContextExt nc,
            NameComponent[] name
    )
            throws UserException {
        boolean isNotFound = false;


        NamingContext tmpCtx = null;
        try {
            NameComponent[] name2 = new NameComponent[1];
            name2[0] = name[0];
            tmpCtx = nc.bind_new_context(name2);
            System.err.println("@@@");
        } catch (NotFound nf) {
            System.err.println("!!!");
            isNotFound = true;
        }

        if (isNotFound) {
            System.err.println("This cannot happen!");
            return;
        }


        for (int i = 1; i < name.length - 1; i++) {
//            System.out.println("i "+name[i]);
            NameComponent[] tmpName = new NameComponent[1 + i];
            for (int j = 0; j <= i; j++) {
                tmpName[j] = name[j];
            }
            tmpCtx = nc.bind_new_context(tmpName);
        }

    }
}
