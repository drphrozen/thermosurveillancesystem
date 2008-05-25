package dk.iha.onk.group1.server.facades.rmi;

import dk.iha.onk.group1.interfaces.IPSPObserver;
import dk.iha.onk.group1.interfaces.IUserFacade;
import dk.iha.onk.group1.server.AlarmController;
import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.SummaryMapper;
import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.dataTransferObjects.SummaryDTO;
import dk.iha.onk.group1.dataTransferObjects.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class UserFacade extends UnicastRemoteObject implements IUserFacade {

	public UserFacade() throws RemoteException
	{
		super();
	}

    private SummaryMapper summaryMapper;
    private MeasurementMapper measurementMapper;
    private ReadingStationMapper stationMapper;
	private AlarmController alarmController;

	public boolean login(String username, String password) throws RemoteException
	{
		UserDTO userDTO = new UserDTO();
		userDTO.setAccountType("user");
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		return login(userDTO);
	}
		
    public boolean login(UserDTO user) throws RemoteException {
        Authenticator auth = new Authenticator();
        if (auth.authenticateUser(user) || auth.authenticateAdmin(user)) {
            summaryMapper = new SummaryMapper();
            measurementMapper = new MeasurementMapper();
            stationMapper = new ReadingStationMapper();
			alarmController = AlarmController.getInstance();
            return true;
        }
        return false;
    }
	
    public ReadingStationDTO[] getReadingStations() throws RemoteException {
        return stationMapper.getEnabledReadingStations();
    }

    public MeasurementDTO[] getLastHourOfReadings(int probeId) throws RemoteException {
        return measurementMapper.getLastHourOfReadings(probeId);
    }

    public SummaryDTO getHistoricalData(Calendar from, Calendar to) throws RemoteException {
        return summaryMapper.generateSummary(from, to);
    }

    public MeasurementDTO[] getMeasurements(Calendar from, Calendar to) throws RemoteException {
        return measurementMapper.getMeasurements(from, to);
    }

    public MeasurementDTO[] getNewestMeasurements() throws RemoteException {
        return measurementMapper.getNewestMeasurements();
    }
	
	public void registerObserver(IPSPObserver o) throws RemoteException {
		alarmController.addObserver(o);
	}
}
