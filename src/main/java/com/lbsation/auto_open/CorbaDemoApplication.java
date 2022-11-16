package com.lbsation.auto_open;

import KTCosNMS.xKTSIO;
import KTCosNMS.xKTSIOHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CorbaDemoApplication {
    //    private static ApplicationContext applicationContext;
        public static final String[] ORB_OPTIONS = new String[]{"-port ", "36267", "-ORBInitialPort", "36268", "-ORBServerHost", "61.98.79.244"};
//        public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36268","-ORBServerPort", "36267", "-ORBInitialHost", "61.98.79.244"};
//    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36268", "-ORBServerPort", "36267", "-ORBInitialHost", "ation.com"};

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("### ation.com config3 ###");

        List<String> orbdStartupCommands = new ArrayList<>();
        orbdStartupCommands.add("orbd");
        orbdStartupCommands.addAll(Arrays.asList(ORB_OPTIONS));

        Process orbdProcess = new ProcessBuilder(orbdStartupCommands).start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("NMS-SERVER Exiting ...");
            orbdProcess.destroy();
        }));

        TimeUnit.SECONDS.sleep(1);
        try {
            bindService(ORB_OPTIONS);
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        SpringApplication.run(CorbaDemoApplication.class, args);

    }

    private static void bindService(String[] options) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
        Properties prop = new Properties();
        // 서버 실행 리슨포트 10000으로 설정
        prop.put("com.sun.CORBA.ORBServerPort", "10000");
        prop.put("com.sun.CORBA.ORBServerHost", "61.98.79.244");
//        prop.put("com.sun.CORBA.activation.Port", "36267");
//        prop.put("com.coremedia.corba.server.port", "36267");
        ORB orb = ORB.init(options, prop);

        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();

        xKTSIOImpl server = new xKTSIOImpl();

        org.omg.CORBA.Object ref = rootPOA.servant_to_reference(server);
        xKTSIO href = xKTSIOHelper.narrow(ref);

        org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

//        NameComponent path[] = ncRef.to_name("corbaname:iiop:1.2@61.98.79.244:1049#BcN-NMS");
        NameComponent path[] = ncRef.to_name("BcN-NMS");
        ncRef.rebind(path, href);

        System.out.println("NMS-SERVER ready started and waiting request ...");

        server.startReadThread();

        orb.run();
    }



}
