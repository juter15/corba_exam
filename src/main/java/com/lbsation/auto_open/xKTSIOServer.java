//package com.lbsation.auto_open;
//
//import KTCosNMS.xKTSIO;
//import KTCosNMS.xKTSIOHelper;
//import org.omg.CORBA.ORB;
//import org.omg.CORBA.ORBPackage.InvalidName;
//import org.omg.CosNaming.NameComponent;
//import org.omg.CosNaming.NamingContextExt;
//import org.omg.CosNaming.NamingContextExtHelper;
//import org.omg.CosNaming.NamingContextPackage.CannotProceed;
//import org.omg.CosNaming.NamingContextPackage.NotFound;
//import org.omg.PortableServer.POA;
//import org.omg.PortableServer.POAHelper;
//import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
//import org.omg.PortableServer.POAPackage.ServantNotActive;
//import org.omg.PortableServer.POAPackage.WrongPolicy;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class xKTSIOServer {
//    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};
//
//
//    public static void main(String args[]) throws IOException, InterruptedException {
//        RedisTemplate<String, String> redisTemplate;
//        List<String> orbdStartupCommands = new ArrayList<>();
//        orbdStartupCommands.add("orbd");
//        orbdStartupCommands.addAll(Arrays.asList(ORB_OPTIONS));
//        ProcessBuilder processBuilder = new ProcessBuilder(orbdStartupCommands);
//
//        Process orbdProcess = processBuilder.start();
//
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("Service Exiting ...");
//            orbdProcess.destroy();
//        }));
//
//        TimeUnit.SECONDS.sleep(2);
//
//        try {
//            bindService(ORB_OPTIONS);
//        } catch (Exception e) {
//            System.err.println("ERROR: " + e);
//            e.printStackTrace(System.out);
//        }
//
//    }
//
//    private static void bindService(String[] options) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
//
//        ORB orb = ORB.init(options, null);
//
//        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
//        poa.the_POAManager().activate();
//
//        xKTSIOImpl server = new xKTSIOImpl();
//
//        org.omg.CORBA.Object ref = poa.servant_to_reference(server);
//        xKTSIO href = xKTSIOHelper.narrow(ref);
//
//        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
//        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
//
//        NameComponent path[] = ncRef.to_name("xKTSIO");
//        ncRef.rebind(path, href);
//
//        System.out.println("xKTSIOService ready started and waiting request ...");
//
////        server.startReadThread();
//
//        orb.run();
//
//    }
//
//
//}
//
