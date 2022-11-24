package com.lbsation.auto_open;

import KTCosNMS.xKTSIO;
import KTCosNMS.xKTSIOHelper;
import com.sun.corba.se.impl.ior.iiop.IIOPProfileTemplateImpl;
import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.spi.ior.IORFactories;
import com.sun.corba.se.spi.ior.IORTemplate;
import com.sun.corba.se.spi.ior.iiop.IIOPProfileTemplate;
import org.apache.catalina.valves.rewrite.Resolver;
import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.Object;
import org.omg.CORBA.UserException;
import org.omg.CORBA_2_3.ORB;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextExtPackage.InvalidAddress;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.IOP.IOR;
import org.omg.IOP.IORHelper;
import org.omg.IOP.IORHolder;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CorbaDemoApplication {
    //    private static ApplicationContext applicationContext;
        public static final String[] ORB_OPTIONS = new String[]{"-port", "36267", "-ORBServerHost", "61.98.79.244"};

//        public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "36267", "-ORBServerHost", "61.98.79.244"};
//    public static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBServerHost", "localhost", "-ORBInitialHost", "localhost"};


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
        SpringApplication.run(CorbaDemoApplication.class, args);

    }

    private static void bindService(String[] options) throws UserException, FileNotFoundException, UnknownHostException {
        Properties prop = new Properties();
        // 서버 실행 리슨포트 10000으로 설정
        prop.put("com.sun.CORBA.ORBServerPort", "36268");
        prop.put("com.sun.CORBA.ORBServerHost", "61.98.79.244");


        ORB orb = (ORB) ORB.init(options, prop);

        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();


        xKTSIOImpl server = new xKTSIOImpl();

        org.omg.CORBA.Object ref = rootPOA.servant_to_reference(server);

        xKTSIO href = xKTSIOHelper.narrow(ref);

        org.omg.CORBA.Object objRef =
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

        server.startReadThread();

        orb.run();

    }

    public static void createContextPath(
            NamingContextExt nc,
            NameComponent[] name
    )
            throws org.omg.CORBA.UserException {
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


        for (int i = 1; i < name.length-1; i++){
//            System.out.println("i "+name[i]);
            NameComponent[] tmpName = new NameComponent[1+i];
            for (int j = 0; j <= i; j++) {
                tmpName[j] = name[j];
            }
            tmpCtx = nc.bind_new_context(tmpName);
        }

    }
}
