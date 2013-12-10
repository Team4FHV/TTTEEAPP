/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import controller.CorbaController;
import corba.CorbaConterollerInterface;
import corba.CorbaConterollerInterfaceHelper;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Bürgi • Dietrich • Fedorova • Shabanova
 */
public class CorbaServer {
    public static void main (String[] args){
        try {
            
             Properties props = new Properties();
             props.put("org.omg.CORBA.ORBInitialPort", "2050");
             props.put("org.omg.CORBA.ORBInitialHost", "localhost");
             ORB orb = ORB.init(args, props);
             
//            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            CorbaController servant = new CorbaController();
            servant.setORB(orb);
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(servant);
            CorbaConterollerInterface href = CorbaConterollerInterfaceHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent cosName[] = ncRef.to_name("ControllerObject");
            ncRef.rebind(cosName, href);
            System.out.println("CorbaServer ready and waiting ...");
            orb.run();
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }
    
}
