/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.client;

import dk.iha.onk.group1.interfaces.IAdminFacade;
import dk.iha.onk.group1.interfaces.IReadingStationFacade;
import dk.iha.onk.group1.interfaces.IUserFacade;
import dk.iha.onk.group1.interfaces.ITssFacadeFactory;
import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.UserDTO;
import java.rmi.Naming;


public class TssClient
{
	private static final int PORT = 1099;
	private static final String IP = "172.21.186.14";
	private static final String SERVER = "TssServer";
	
	public TssClient()
	{
		try
		{ 
			ITssFacadeFactory obj = (ITssFacadeFactory)Naming.lookup("rmi://"+IP+":"+PORT+"/"+SERVER); 
			Object o = obj.createFacade("AdminFacade","onk","kaffekande");
			IAdminFacade adminFacade = (IAdminFacade)o;
			for (UserDTO user: adminFacade.getUsers())
			{
				System.out.println("User: "+ user.getUsername());
			}
			IUserFacade userFacade = (IUserFacade)obj.createFacade("UserFacade","user","");
			PSPObserver pspObserver = new PSPObserver();
			IReadingStationFacade readingStationFacade = (IReadingStationFacade)obj.createFacade("ReadingStationFacade", "", "");
			MeasurementDTO measurement = new MeasurementDTO();
			measurement.setLowerAlarm(10);
			measurement.setUpperAlarm(200);
			measurement.setValue(201);
			measurement.setProbeId(31);
			readingStationFacade.deliverAlarm(measurement);
			System.out.println("Register PSP Observer");
			userFacade.registerObserver(pspObserver);
			Thread.sleep(2000);
			readingStationFacade.deliverAlarm(measurement);
		} 
		catch (Exception e)
		{ 
			System.out.println("TssClient exception: " +e.getMessage()); 
			e.printStackTrace(); 
		} 
	}
	
    public static void main(String[] args)
	{ 
		new TssClient();
    } 
}
