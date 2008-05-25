package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.facades.AdminFacade;
import dk.iha.onk.group1.server.facades.IAdminFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

/**
 *
 * @author Esben
 */
public class rmiiiopclient {

//    private static int PORT = 65432;
//    private static String HOST = "127.0.0.1";
    

    public static void main(String[] args) {
        try {
            Context ic = new InitialContext();
            ic.addToEnvironment("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
            ic.addToEnvironment("java.naming.provider.url", "iiop://localhost:1050");
//            String path = "//" + HOST + ":" + Integer.toString(PORT);
            Object objref = ic.lookup(AdminFacade.class.getSimpleName());
            IAdminFacade adminInterface = (IAdminFacade) PortableRemoteObject.narrow(objref, IAdminFacade.class);
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
            Logger.getLogger(rmiiiopclient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
