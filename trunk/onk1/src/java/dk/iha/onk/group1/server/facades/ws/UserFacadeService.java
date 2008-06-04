/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades.ws;

import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.dataTransferObjects.SummaryDTO;
import dk.iha.onk.group1.server.MeasurementMapper;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.SummaryMapper;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Esben
 */
@WebService()
public class UserFacadeService {
    private SummaryMapper summaryMapper;
    private MeasurementMapper measurementMapper;
    private ReadingStationMapper stationMapper;

    @WebMethod(operationName = "addAlarmListener")
    public boolean addAlarmListener() {
        return false;
    }

    @WebMethod(operationName = "getReadingStations")
    public ReadingStationDTO[] getReadingStations() {
        return stationMapper.getEnabledReadingStations();
    }

    @WebMethod(operationName = "getLastHourOfReadings")
    public MeasurementDTO[] getLastHourOfReadings(@WebParam(name = "probeId") int probeId) {
        return measurementMapper.getLastHourOfReadings(probeId);
    }

    @WebMethod(operationName = "getHistoricalData")
    public SummaryDTO getHistoricalData(@WebParam(name = "from") Calendar from, @WebParam(name = "to") Calendar to) {
        return summaryMapper.generateSummary(from, to);
    }

    @WebMethod(operationName = "getMeasurements")
    public MeasurementDTO[] getMeasurements(@WebParam(name = "from") Calendar from, @WebParam(name = "to") Calendar to) {
        return measurementMapper.getMeasurements(from, to);
    }

    @WebMethod(operationName = "getNewestMeasurements")
    public MeasurementDTO[] getNewestMeasurements() {
        return measurementMapper.getNewestMeasurements();
    }
}
