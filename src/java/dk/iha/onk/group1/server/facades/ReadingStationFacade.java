package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.jws.WebService;

/**
 *
 * @author ESRA
 */
@WebService()
public class ReadingStationFacade extends UnicastRemoteObject implements  ReadingStationInterface, Serializable
{
    public ReadingStationFacade() throws RemoteException
	{
        super();
    }

    private ReadingStationMapper rsMapper;
    private MeasurementMapper measurementMapper;
	
	public boolean login(String username, String password)
	{
		Authenticator auth = new Authenticator();
		ReadingStationDTO readingStation = new ReadingStationDTO();
		readingStation.setName(username);
        if (auth.authenticateReadingStation(readingStation)) 
		{
            rsMapper = new ReadingStationMapper();
            measurementMapper = new MeasurementMapper();
            return true;
        }
        return false;
	}

    public ReadingStationDTO login(ReadingStationDTO readingStation) {
        Authenticator auth = new Authenticator();
		
        if (auth.authenticateReadingStation(readingStation)) {
            rsMapper = new ReadingStationMapper();
            measurementMapper = new MeasurementMapper();
            return rsMapper.getIDs(readingStation);
        }
        return null;
    }

    public void deliverMeasurements(MeasurementDTO[] measurements) {
        measurementMapper.saveMeasurements(measurements);
    }

    public void deliverAlarm(MeasurementDTO alarm) {
        measurementMapper.saveAlarm(alarm);
    }

    public ReadingStationDTO getStatus(ReadingStationDTO rs) {
        return rsMapper.getStatus(rs);
    }
}
