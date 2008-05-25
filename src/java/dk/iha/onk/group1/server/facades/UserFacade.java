package dk.iha.onk.group1.server.facades;

import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.SummaryMapper;
import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataTransferObjects.SummaryDTO;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import javax.jws.WebService;


@WebService()
public class UserFacade extends UnicastRemoteObject implements IUserFacade {

    public UserFacade() throws RemoteException
	{
        super();
    }

    private SummaryMapper summaryMapper;
    private MeasurementMapper measurementMapper;
    private ReadingStationMapper stationMapper;

	public boolean login(String username, String password)
	{
		UserDTO userDTO = new UserDTO();
		userDTO.setAccountType("user");
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		return login(userDTO);
	}
		
    public boolean login(UserDTO user) {
        Authenticator auth = new Authenticator();
        if (auth.authenticateUser(user) || auth.authenticateAdmin(user)) {
            summaryMapper = new SummaryMapper();
            measurementMapper = new MeasurementMapper();
            stationMapper = new ReadingStationMapper();
            return true;
        }
        return false;
    }
	
	public boolean addAlarmListener()
	{
		return false;
	}

    public ReadingStationDTO[] getReadingStations() {
        return stationMapper.getEnabledReadingStations();
    }

    public MeasurementDTO[] getLastHourOfReadings(int probeId) {
        return measurementMapper.getLastHourOfReadings(probeId);
    }

    public SummaryDTO getHistoricalData(Calendar from, Calendar to) {
        return summaryMapper.generateSummary(from, to);
    }

    public MeasurementDTO[] getMeasurements(Calendar from, Calendar to) {
        return measurementMapper.getMeasurements(from, to);
    }

    public MeasurementDTO[] getNewestMeasurements() {
        return measurementMapper.getNewestMeasurements();
    }
}
