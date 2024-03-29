/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades.ws;

import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Esben
 */
@WebService()
public class ReadingStationFacadeService {
    private ReadingStationMapper rsMapper;
    private MeasurementMapper measurementMapper;

    @WebMethod(operationName = "deliverMeasurements")
    public void deliverMeasurements(@WebParam(name = "measurements") MeasurementDTO[] measurements) {
        measurementMapper.saveMeasurements(measurements);
    }

    @WebMethod(operationName = "deliverAlarm")
    public void deliverAlarm(@WebParam(name = "alarm") MeasurementDTO alarm) {
        measurementMapper.saveAlarm(alarm);
    }

    @WebMethod(operationName = "getStatus")
    public ReadingStationDTO getStatus(@WebParam(name = "readingStation") ReadingStationDTO readingStation) {
        return rsMapper.getStatus(readingStation);
    }
}
