/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author dk021998
 */
public interface IPSPObserver extends Remote
{
	void update(MeasurementDTO alarm) throws RemoteException;
}
