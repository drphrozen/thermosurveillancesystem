/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.client;

import dk.iha.onk.group1.server.IPSPObserver;
import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author dk021998
 */
public class PSPObserver extends UnicastRemoteObject implements IPSPObserver
{

	public PSPObserver() throws RemoteException
	{
		super();
	}
	
	public void update(MeasurementDTO alarm) throws RemoteException
	{
		System.out.println("Alarm: " + alarm.getProbeId() + " " + alarm.getValue());
	}

}
