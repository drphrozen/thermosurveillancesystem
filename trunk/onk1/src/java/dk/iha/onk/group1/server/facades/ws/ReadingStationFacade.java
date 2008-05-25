package dk.iha.onk.group1.server.facades.ws;

import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ESRA
 */
@WebService(name="ReadingStationFacadeService")
public class ReadingStationFacade {

    private ReadingStationMapper rsMapper;
    private MeasurementMapper measurementMapper;
	
	@WebMethod(operationName = "login")
	public ReadingStationDTO login(@WebParam(name = "readingStation")ReadingStationDTO readingStation) {
        Authenticator auth = new Authenticator();
		
        if (auth.authenticateReadingStation(readingStation)) {
            rsMapper = new ReadingStationMapper();
            measurementMapper = new MeasurementMapper();
            return rsMapper.getIDs(readingStation);
        }
        return null;
    }

	@WebMethod(operationName = "deliverMeasurements")
    public void deliverMeasurements(@WebParam(name = "measurements")MeasurementDTO[] measurements) {
        measurementMapper.saveMeasurements(measurements);
    }

	@WebMethod(operationName = "deliverAlarm")
    public void deliverAlarm(@WebParam(name = "alarm")MeasurementDTO alarm) {
        measurementMapper.saveAlarm(alarm);
    }

	@WebMethod(operationName = "getStatus")
    public ReadingStationDTO getStatus(@WebParam(name = "readingStation")ReadingStationDTO readingStation) {
        return rsMapper.getStatus(readingStation);
    }

}
