package dk.iha.onk.group1.server.facades.rmi;

import dk.iha.onk.group1.interfaces.IAdminFacade;
import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.UserMapper;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.dataTransferObjects.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdminFacade extends UnicastRemoteObject implements IAdminFacade
{

	public AdminFacade() throws RemoteException
	{
		super();
	}
	
    private ReadingStationMapper rsMapper;
    private UserMapper userMapper;

	public boolean login(String username, String password) throws RemoteException
	{
		UserDTO userDTO = new UserDTO();
		userDTO.setAccountType("admin");
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		return login(userDTO);
	}
	
    public boolean login(UserDTO admin) throws RemoteException {
        Authenticator auth = new Authenticator();
        if (auth.authenticateAdmin(admin)) {
            rsMapper = new ReadingStationMapper();
            userMapper = new UserMapper();
            return true;
        }
        return false;
    }

    public boolean addUser(UserDTO user) throws RemoteException {
        return userMapper.addUser(user);
    }

    public boolean updateUserInfo(int id, UserDTO newUser) throws RemoteException {
        return userMapper.updateUser(id, newUser);
    }

    public boolean removeUser(String username) throws RemoteException {
        return userMapper.removeUser(username);
    }

    public boolean setRSName(int rsId, String newName) throws RemoteException {
        return rsMapper.setRSName(rsId, newName);
    }

    public boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit) throws RemoteException {
        return rsMapper.setProbeAlarmLevel(probeId, newLowerLimit, newUpperLimit);
    }

    public boolean enableRS(String rsName) throws RemoteException {
        return rsMapper.enableReadingStation(rsName);
    }

    public boolean disableRS(String rsName) throws RemoteException {
        return rsMapper.disableReadingStation(rsName);
    }

    public UserDTO[] getUsers() throws RemoteException {
        return userMapper.getUsers();
    }

    public ReadingStationDTO[] getReadingStations() throws RemoteException {
        return rsMapper.getReadingStations();
    }

}
