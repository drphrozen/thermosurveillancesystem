/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net2assignment1;

import dk.iha.onk.group1.server.facades.AdminFacade;
import dk.iha.onk.group1.server.facades.ReadingStationFacade;
import dk.iha.onk.group1.server.facades.UserFacade;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esben
 */
public class rmiserver {

    private static AdminFacade adminFacade = new AdminFacade();
    private static ReadingStationFacade readingStationFacade = new ReadingStationFacade();
    private static UserFacade userFacade = new UserFacade();
    private static int PORT = 65432;
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try {
            String path = "//" + HOST + ":" + Integer.toString(PORT) + "/";
            LocateRegistry.createRegistry(PORT);
            UnicastRemoteObject.exportObject(adminFacade);
            Naming.rebind(path + AdminFacade.class.getSimpleName(), adminFacade);
            UnicastRemoteObject.exportObject(userFacade);
            Naming.rebind(path + ReadingStationFacade.class.getSimpleName(), readingStationFacade);
            UnicastRemoteObject.exportObject(readingStationFacade);
            Naming.rebind(path + UserFacade.class.getSimpleName(), userFacade);
            System.out.println("All services successfully bound.");
        } catch (Exception ex) {
            Logger.getLogger(rmiserver.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
