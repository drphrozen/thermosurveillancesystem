package dk.iha.onk.group1.server;

public class ReadingStationFacade
{
    private ReadingStationMapper rsMapper;
    
    public ReadingStationFacade()
    {
    }
    
    public boolean login(ReadingStationDTO readingStation)
    {
        Authenticator auth = new Authenticator();
        if (auth.authenticateReadingStation(readingStation))
        {
            rsMapper = new ReadingStationMapper();
            return true;
        }
        return false;
    }
    
    public void deliverReading(ReadingStationDTO rs)
    {
        rsMapper.saveReading(rs);
    }
    
    public void deliverAlarm(ReadingStationDTO rsAlarm)
    {
        rsMapper.saveAlarm(rsAlarm);
    }

    public ReadingStationDTO getStatus(ReadingStationDTO rs)
    {
        return rsMapper.getStatus(rs);
    }
}
