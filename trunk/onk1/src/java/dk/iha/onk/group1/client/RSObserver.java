/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.client;

import dk.iha.onk.group1.interfaces.IRSObserver;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import java.rmi.RemoteException;

/**
 *
 * @author dk021998
 */
public class RSObserver implements IRSObserver
{

	public void setStatus(ReadingStationDTO readingStationDTO) throws RemoteException
	{
		
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
