package com.example.corba_demo;

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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Schedules;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CorbaDemoApplication {
    //    private static ApplicationContext applicationContext;
    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};

    public static void main(String[] args) throws InterruptedException, IOException {


        List<String> orbdStartupCommands = new ArrayList<>();
        orbdStartupCommands.add("orbd");
        orbdStartupCommands.addAll(Arrays.asList(ORB_OPTIONS));

        Process orbdProcess = new ProcessBuilder(orbdStartupCommands).start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("xKTSIOService Exiting ...");
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
        ORB orb = ORB.init(options, null);

        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();

        xKTSIOImpl server = new xKTSIOImpl();

        org.omg.CORBA.Object ref = rootPOA.servant_to_reference(server);
        xKTSIO href = xKTSIOHelper.narrow(ref);

        org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        NameComponent path[] = ncRef.to_name("xKTSIOServer");
        ncRef.rebind(path, href);

        System.out.println("xKTSIOService ready started and waiting request ...");

        server.startReadThread();

        orb.run();
    }



}
