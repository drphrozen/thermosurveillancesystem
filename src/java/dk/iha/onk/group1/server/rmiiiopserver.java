/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.facades.AdminFacade;
import dk.iha.onk.group1.server.facades.ReadingStationFacade;
import dk.iha.onk.group1.server.facades.UserFacade;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Esben
 */
public class rmiiiopserver {

    private static AdminFacade adminFacade;
    private static ReadingStationFacade readingStationFacade = new ReadingStationFacade();
    private static UserFacade userFacade = new UserFacade();
//    private static int PORT = 65432;
//    private static String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try {
            adminFacade = new AdminFacade();
            Hashtable<String, Object> env = new Hashtable<String, Object>(2);
            env.put("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
            env.put("java.naming.provider.url", "iiop://localhost:1050");
            Context ic = new InitialContext(env);
//            String path = "//" + HOST + ":" + Integer.toString(PORT) + "/";
//            LocateRegistry.createRegistry(PORT);
//            UnicastRemoteObject.exportObject(adminFacade);
            System.out.println("Bound: " + AdminFacade.class.getSimpleName());
            ic.rebind(AdminFacade.class.getSimpleName(), adminFacade);
//            UnicastRemoteObject.exportObject(userFacade);
//            ic.bind(path + ReadingStationFacade.class.getSimpleName(), readingStationFacade);
//            UnicastRemoteObject.exportObject(readingStationFacade);
//            ic.bind(path + UserFacade.class.getSimpleName(), userFacade);
            System.out.println("All services successfully bound.");
        } catch (Exception ex) {
            Logger.getLogger(rmiiiopserver.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
