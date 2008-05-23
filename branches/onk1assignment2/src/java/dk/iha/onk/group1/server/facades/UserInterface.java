/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataTransferObjects.SummaryDTO;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import java.rmi.RemoteException;
import java.util.Calendar;

/**
 *
 * @author Esben
 */
public interface UserInterface extends TssFacade
{

    SummaryDTO getHistoricalData(Calendar from, Calendar to) throws RemoteException;

    MeasurementDTO[] getLastHourOfReadings(int probeId) throws RemoteException;

    MeasurementDTO[] getMeasurements(Calendar from, Calendar to) throws RemoteException;

    MeasurementDTO[] getNewestMeasurements() throws RemoteException;

    ReadingStationDTO[] getReadingStations() throws RemoteException;

    boolean login(UserDTO user) throws RemoteException;

}
