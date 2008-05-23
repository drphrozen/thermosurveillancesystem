/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Esben
 */
public interface ReadingStationInterface extends Remote {

    void deliverAlarm(MeasurementDTO alarm) throws RemoteException;

    void deliverMeasurements(MeasurementDTO[] measurements) throws RemoteException;

    ReadingStationDTO getStatus(ReadingStationDTO rs) throws RemoteException;

    ReadingStationDTO login(ReadingStationDTO readingStation) throws RemoteException;

}
