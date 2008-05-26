
package dk.iha.onk.group1.server;

import dk.iha.onk.group1.interfaces.IPSPObserver;
import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import java.rmi.ConnectException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.util.LinkedList;
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
	private LinkedList<IPSPObserver> toBeRemoved = new LinkedList<IPSPObserver>();

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
	
	public synchronized void raiseAlarm(MeasurementDTO m) {
		if(!pspObservers.isEmpty())
		{
			System.out.println("Raise alarms!");
			for (IPSPObserver psp : pspObservers)
			{
				try
				{
					System.out.println("Send alarm to " + psp.toString());
					psp.update(m);
				} catch (ConnectException ex) {
					System.out.println("Connection error to " + psp.toString());
					toBeRemoved.add(psp);
				} catch (RemoteException ex) {
					Logger.getLogger(AlarmController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			try {
				pspObservers.removeAll(toBeRemoved);
				toBeRemoved.clear();
			} catch(Exception ex) {
				Logger.getLogger(AlarmController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
