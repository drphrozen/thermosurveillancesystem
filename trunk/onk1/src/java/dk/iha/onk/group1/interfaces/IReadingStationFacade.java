/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.interfaces;

import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import java.rmi.RemoteException;

/**
 *
 * @author Esben
 */
public interface IReadingStationFacade extends ITssFacade
{

    void deliverAlarm(MeasurementDTO alarm) throws RemoteException;

    void deliverMeasurements(MeasurementDTO[] measurements) throws RemoteException;

    ReadingStationDTO getStatus(ReadingStationDTO rs) throws RemoteException;

    ReadingStationDTO login(ReadingStationDTO readingStation) throws RemoteException;

}
