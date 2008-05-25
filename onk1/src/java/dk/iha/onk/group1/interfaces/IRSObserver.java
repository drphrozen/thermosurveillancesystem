/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.interfaces;

import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author dk021998
 */
public interface IRSObserver extends Remote
{
	void setStatus(ReadingStationDTO readingStationDTO) throws RemoteException;
}
