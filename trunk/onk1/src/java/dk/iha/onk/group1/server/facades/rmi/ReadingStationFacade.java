package dk.iha.onk.group1.server.facades.rmi;

import dk.iha.onk.group1.interfaces.IReadingStationFacade;
import dk.iha.onk.group1.server.AlarmController;
import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ESRA
 */
public class ReadingStationFacade extends UnicastRemoteObject implements IReadingStationFacade {

    private ReadingStationMapper rsMapper;
    private MeasurementMapper measurementMapper;
	private AlarmController alarmController;

	public ReadingStationFacade() throws RemoteException
	{
		super();
	}
	
	public boolean login(String username, String password) throws RemoteException
	{
		Authenticator auth = new Authenticator();
		ReadingStationDTO readingStation = new ReadingStationDTO();
		readingStation.setName(username);
        if (auth.authenticateReadingStation(readingStation)) 
		{
            rsMapper = new ReadingStationMapper();
            measurementMapper = new MeasurementMapper();
			alarmController = AlarmController.getInstance();
            return true;
        }
        return false;
	}

    public ReadingStationDTO login(ReadingStationDTO readingStation) throws RemoteException {
        Authenticator auth = new Authenticator();
		
        if (auth.authenticateReadingStation(readingStation)) {
            rsMapper = new ReadingStationMapper();
            measurementMapper = new MeasurementMapper();
            return rsMapper.getIDs(readingStation);
        }
        return null;
    }

    public void deliverMeasurements(MeasurementDTO[] measurements) throws RemoteException {
        measurementMapper.saveMeasurements(measurements);
    }

    public void deliverAlarm(MeasurementDTO alarm) throws RemoteException {
		new Thread(new DeliverAlarm(measurementMapper, alarmController, alarm)).start();
    }

    public ReadingStationDTO getStatus(ReadingStationDTO rs) throws RemoteException {
        return rsMapper.getStatus(rs);
    }
}
