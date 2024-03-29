/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.interfaces;

import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.dataTransferObjects.SummaryDTO;
import dk.iha.onk.group1.dataTransferObjects.UserDTO;
import java.rmi.RemoteException;
import java.util.Calendar;

/**
 *
 * @author Esben
 */
public interface IUserFacade extends ITssFacade
{

    SummaryDTO getHistoricalData(Calendar from, Calendar to) throws RemoteException;

    MeasurementDTO[] getLastHourOfReadings(int probeId) throws RemoteException;

    MeasurementDTO[] getMeasurements(Calendar from, Calendar to) throws RemoteException;

    MeasurementDTO[] getNewestMeasurements() throws RemoteException;

    ReadingStationDTO[] getReadingStations() throws RemoteException;

    boolean login(UserDTO user) throws RemoteException;
	
	void registerObserver(IPSPObserver o) throws RemoteException;

}
