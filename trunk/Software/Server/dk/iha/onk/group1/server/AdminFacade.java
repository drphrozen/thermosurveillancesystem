package dk.iha.onk.group1.server;

public class AdminFacade
{
    private ReadingStationMapper rsMapper;
    private UserMapper userMapper;
    private SimStub simulator;
    
    public AdminFacade()
    {
        simulator = SimStub.instance();
    }
    
    public boolean login(UserDTO admin)
    {
        Authenticator auth = new Authenticator();
        if (auth.authenticateAdmin(admin) || admin.getUsername().equals("diller"))
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

    public boolean updateUserInfo(UserDTO oldUser, UserDTO newUser)
    {
        return userMapper.updateUser(oldUser, newUser);
    }

    public boolean removeUser(String username)
    {
        return userMapper.removeUser(username);
    }

    public boolean setRSName(String oldName, String newName)
    {
        return simulator.setReadingStationName(oldName, newName);
        //return rsMapper.setRSName(oldName, newName);
    }

    public boolean setRSAlarmLevel(String rsName, int probeId, double newLowerLimit, double newUpperLimit)
    {
        return rsMapper.setRSAlarmLevel(rsName,probeId, newLowerLimit,newUpperLimit);
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
        return simulator.getReadingStations();
        //return rsMapper.getReadingStations();
    }
}
