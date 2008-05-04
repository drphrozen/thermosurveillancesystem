package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.*;
import dk.iha.onk.group1.server.dataTransferObjects.*;

public class ReadingStationFacade
{
    private ReadingStationMapper rsMapper;
    private MeasurementMapper measurementMapper;
   
    public ReadingStationFacade()
    {
    }
    
    public ReadingStationDTO login(ReadingStationDTO readingStation)
    {
        Authenticator auth = new Authenticator();
        if (auth.authenticateReadingStation(readingStation))
        {
            rsMapper = new ReadingStationMapper();
            measurementMapper = new MeasurementMapper();
            return rsMapper.getIDs(readingStation);
        }
        return null;
    }
    
    public void deliverMeasurements(MeasurementDTO[] measurements)
    {
        measurementMapper.saveMeasurements(measurements);
    }
    
    public void deliverAlarm(MeasurementDTO alarm)
    {
        measurementMapper.saveAlarm(alarm);
    }

    public ReadingStationDTO getStatus(ReadingStationDTO rs)
    {
        return rsMapper.getStatus(rs);
    }
}
