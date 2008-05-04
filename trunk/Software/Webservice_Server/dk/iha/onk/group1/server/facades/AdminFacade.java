package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.*;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminFacade
{
    private ReadingStationMapper rsMapper;
    private UserMapper userMapper;
    
    public AdminFacade()
    {
    }
    
    public boolean login(UserDTO admin) throws IOException
    {
        Authenticator auth = new Authenticator();
        if (auth.authenticateAdmin(admin))
        {
            rsMapper = new ReadingStationMapper();
            userMapper = new UserMapper();
            return true;
        }
        return false;
    }

    public boolean addUser(UserDTO user)
    {
        return userMapper.addUser(user);
    }

    public boolean updateUserInfo(int id, UserDTO newUser)
    {
        return userMapper.updateUser(id, newUser);
    }

    public boolean removeUser(String username)
    {
        return userMapper.removeUser(username);
    }

    public boolean setRSName(int rsId, String newName)
    {
        return rsMapper.setRSName(rsId, newName);
    }

    public boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit)
    {
        return rsMapper.setProbeAlarmLevel(probeId, newLowerLimit,newUpperLimit);
    }

    public boolean enableRS(String rsName)
    {
        return rsMapper.enableReadingStation(rsName);
    }

    public boolean disableRS(String rsName)
    {
        return rsMapper.disableReadingStation(rsName);
    }
    
    public UserDTO[] getUsers()
    {
        return userMapper.getUsers();
    }
    
    public ReadingStationDTO[] getReadingStations()
    {
        return rsMapper.getReadingStations();
    }
}
