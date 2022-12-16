package com.lbsation.auto_open;

import KTCosNMS.xKTSIO;
import KTCosNMS.xKTSIOHelper;
import com.lbsation.auto_open.configuartion.ConfigFile;
import com.lbsation.auto_open.model.ConfigModel;
import com.sun.corba.se.impl.ior.iiop.IIOPProfileTemplateImpl;
import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.spi.ior.IORFactories;
import com.sun.corba.se.spi.ior.IORTemplate;
import com.sun.corba.se.spi.ior.iiop.IIOPProfileTemplate;
import org.apache.catalina.valves.rewrite.Resolver;
import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.apache.commons.lang3.StringUtils;
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
    public static ORB orb = null;
    public static String ior = null;

//    public static final String[] ORB_OPTIONS = new String[]{"-port", configModel.getOrbPort(), "-ORBInitialPort", "1050", "-ORBInitialHost", configModel.getOrbServerHost(), "-ORBServerHost", configModel.getOrbServerHost()};
//
    public static final ConfigModel configModel = ConfigFile.getConfig();
    public static final String[] ORB_OPTIONS = new String[]{"-port", configModel.getOrbPort(), "-ORBInitialPort", "1050",  "-ORBInitialHost", configModel.getOrbInitialHost()};
//        public static final String[] ORB_OPTIONS = new String[]{"-port", "36267", "-ORBServerHost", "localhost", "-ORBInitialHost", "localhost"};
    public static ORB getORB() {
        return orb;
    }

    public static void main(String[] args) throws InterruptedException, IOException {


        System.out.println("### ation.com config3 ###");

        List<String> orbdStartupCommands = new ArrayList<>();
        if(!StringUtils.isEmpty(configModel.getJavaHome())) {
            orbdStartupCommands.add(configModel.getJavaHome() + "orbd");
        }
        else{
            orbdStartupCommands.add("orbd");

        }
        orbdStartupCommands.addAll(Arrays.asList(ORB_OPTIONS));

        if(!StringUtils.isEmpty(configModel.getOrbServerHost())){
            orbdStartupCommands.add("-ORBServerHost");
            orbdStartupCommands.add(configModel.getOrbServerHost());
        }

        Process orbdProcess = new ProcessBuilder(orbdStartupCommands).start();
        System.out.println("ORB START ..." + orbdStartupCommands);

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

    private static void bindService(String[] options) throws UserException, FileNotFoundException, UnknownHostException {
        String[] nameComponent = configModel.getNameComponent();

        Properties prop = new Properties();
        prop.put("com.sun.CORBA.ORBServerPort", configModel.getServerPort());
        prop.put("com.sun.CORBA.ORBServerHost", configModel.getServerHost());
//

        orb = (ORB) ORB.init(options, prop);

        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();


        xKTSIOImpl server = new xKTSIOImpl();

        org.omg.CORBA.Object ref = rootPOA.servant_to_reference(server);

        xKTSIO href = xKTSIOHelper.narrow(ref);

        org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        NameComponent[] name = {
                new NameComponent(nameComponent[0], ""),
                new NameComponent(nameComponent[1], ""),
                new NameComponent(nameComponent[2], ""),
                new NameComponent(nameComponent[3], "")
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
        ior = orb.object_to_string(href);
//        ((com.sun.corba.se.spi.orb.ORB) orb).register_initial_reference("KT/AGW/EMOVE_NOMS2/KT_BCNNMS_MD", href);
        System.out.println("New account created and registered.  URLs are: ");
        System.out.println("\nIOR");
        System.out.println("\t" + ior);

        System.out.println("NMS-SERVER ready started and waiting request ...");

//        server.startReadThread();

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
            System.out.println("@@@");
            tmpCtx = nc.bind_new_context(name2);
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
//
    }

    public static String getIor(){
        return ior;
    }

    public static ConfigModel getConfigModel(){
        return configModel;
    }
}
