package net2assignment1;

import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.facades.AdminFacade;
import dk.iha.onk.group1.server.facades.AdminInterface;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esben
 */
public class rmiclient {

    private static int PORT = 65432;
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try {
            String path = "//" + HOST + ":" + Integer.toString(PORT);
            AdminInterface adminInterface = (AdminInterface) Naming.lookup(path + "/" + AdminFacade.class.getSimpleName());
            UserDTO user = new UserDTO();
            user.setUsername("onk");
            user.setPassword("kaffekande");
            user.setAccountType("admin");
            System.out.println("login: " + adminInterface.login(user));
            ReadingStationDTO[] readingStations = adminInterface.getReadingStations();
            System.out.print("Reading Stations: ");
            for (ReadingStationDTO readingStation : readingStations) {
                System.out.print(readingStation.getName() + ", ");
            }
            System.out.println("");
        } catch (Exception ex) {
            Logger.getLogger(rmiclient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
