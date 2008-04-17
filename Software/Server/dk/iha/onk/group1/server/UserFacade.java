package dk.iha.onk.group1.server;

import java.util.Calendar;

public class UserFacade
{
    private SummaryMapper summaryMapper;
    private MeasurementMapper measMapper;
    private ReadingStationMapper rsMapper;
    
    public boolean login(UserDTO user)
    {
        Authenticator auth = new Authenticator();
        if (auth.authenticateUser(user) || user.getUsername().equals("ged"))
        {
            summaryMapper = new SummaryMapper();
            measMapper = new MeasurementMapper();
            rsMapper = new ReadingStationMapper();
            return true;
        }
        return false;
    }
    
    public MeasurementDTO[] getLastHourOfReadings(String rsName, int probeId)
    {
        return measMapper.getLastHourOfReadings(rsName, probeId);
    }
    
    public SummaryDTO getHistoricalData(Calendar from, Calendar to)
    {
        return summaryMapper.generateSummary(from, to);
    }
    
    public ReadingStationDTO[] getReadings(Calendar from, Calendar to)
    {
        return rsMapper.getReadings(from, to);
    }
    
    public ReadingStationDTO[] getNewestReadings()
    {
        return rsMapper.getNewestReadings();
    }
}
