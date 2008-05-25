
package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dk021998
 */
public class AlarmController
{
	private Vector<IPSPObserver> pspObservers = new Vector<IPSPObserver>();
	private static AlarmController alarmController = new AlarmController();
	private AlarmController(){}

	public static AlarmController getInstance() {
		return alarmController;
	}
	
	public void addObserver(IPSPObserver o)
	{
		System.out.println("Register PSP Observer (" + o.toString() + ")");
		pspObservers.add(o);
	}

	public void deleteObserver(IPSPObserver o)
	{
		pspObservers.remove(o);
	}
	
	public void raiseAlarm(MeasurementDTO m) {
		for (IPSPObserver psp : pspObservers)
		{
			try
			{
				System.out.println("Send alarm to " + psp.toString());
				psp.update(m);
			} catch (NoSuchObjectException ex) {
				// TODO: Should unregister IPSPObserver
				Logger.getLogger(AlarmController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (RemoteException ex)
			{
				Logger.getLogger(AlarmController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}
	
}
