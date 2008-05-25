/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import java.rmi.RemoteException;

/**
 *
 * @author Esben
 */
public interface IAdminFacade extends ITssFacade {

    boolean addUser(UserDTO user) throws RemoteException;

    boolean disableRS(String rsName) throws RemoteException;

    boolean enableRS(String rsName) throws RemoteException;

    ReadingStationDTO[] getReadingStations() throws RemoteException;

    UserDTO[] getUsers() throws RemoteException;

    boolean login(UserDTO admin) throws RemoteException;

    boolean removeUser(String username) throws RemoteException;

    boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit) throws RemoteException;

    boolean setRSName(int rsId, String newName) throws RemoteException;

    boolean updateUserInfo(int id, UserDTO newUser) throws RemoteException;

}
