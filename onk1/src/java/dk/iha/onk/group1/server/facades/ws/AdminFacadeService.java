/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades.ws;

import com.sun.xml.ws.developer.servlet.HttpSessionScope;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.UserMapper;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Esben
 */
@HttpSessionScope
@WebService()
public class AdminFacadeService {

    private ReadingStationMapper rsMapper;
    private UserMapper userMapper;

    @WebMethod(operationName = "addUser")
    public boolean addUser(@WebParam(name = "user") UserDTO user) {
        return userMapper.addUser(user);
    }

    @WebMethod(operationName = "updateUserInfo")
    public boolean updateUserInfo(@WebParam(name = "id") int id, @WebParam(name = "user") UserDTO newUser) {
        return userMapper.updateUser(id, newUser);
    }

    @WebMethod(operationName = "removeUser")
    public boolean removeUser(@WebParam(name = "username") String username) {
        return userMapper.removeUser(username);
    }

    @WebMethod(operationName = "setRSName")
    public boolean setRSName(@WebParam(name = "rsId") int rsId, @WebParam(name = "newName") String newName) {
        return rsMapper.setRSName(rsId, newName);
    }

    @WebMethod(operationName = "setProbeAlarmLevel")
    public boolean setProbeAlarmLevel(@WebParam(name = "probeId") int probeId, @WebParam(name = "newLowerLimit") double newLowerLimit, @WebParam(name = "newUpperLimit") double newUpperLimit) {
        return rsMapper.setProbeAlarmLevel(probeId, newLowerLimit, newUpperLimit);
    }

    @WebMethod(operationName = "enableRS")
    public boolean enableRS(@WebParam(name = "rsName") String rsName) {
        return rsMapper.enableReadingStation(rsName);
    }

    @WebMethod(operationName = "disableRS")
    public boolean disableRS(@WebParam(name = "rsName") String rsName) {
        return rsMapper.disableReadingStation(rsName);
    }

    @WebMethod(operationName = "getUsers")
    public UserDTO[] getUsers() {
        return userMapper.getUsers();
    }

    @WebMethod(operationName = "getReadingStations")
    public ReadingStationDTO[] getReadingStations() {
        return rsMapper.getReadingStations();
    }
}
