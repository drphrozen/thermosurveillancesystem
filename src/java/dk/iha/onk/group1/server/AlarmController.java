
package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.facades.IUserFacade;
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
	private Vector<IUserFacade> pspObservers = new Vector<IUserFacade>();
	private static AlarmController alarmController = new AlarmController();
	private AlarmController(){}

	public static AlarmController getInstance() {
		return alarmController;
	}
	
	public void addObserver(IUserFacade o)
	{
		pspObservers.add(o);
	}

	public void deleteObserver(IUserFacade o)
	{
		pspObservers.remove(o);
	}
	
	public void raiseAlarm(MeasurementDTO m) {
		for (IUserFacade user : pspObservers)
		{
			try
			{
				user.update(m);
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
