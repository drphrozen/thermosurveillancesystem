package dk.iha.onk.group1.server;

import dk.iha.onk.group1.dataTransferObjects.ProbeDTO;
import dk.iha.onk.group1.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataSourceLayer.DataSourceFacade;
import dk.iha.onk.group1.server.domainObjects.Probe;
import dk.iha.onk.group1.server.domainObjects.ReadingStation;
import java.util.LinkedList;

public class ReadingStationMapper {

    private DataSourceFacade dataSource;

    public ReadingStationMapper() {
        dataSource = new DataSourceFacade();
    }

    public boolean enableReadingStation(String rsName) {
        return dataSource.enableReadingStation(rsName);
    }

    public boolean disableReadingStation(String rsName) {
        return dataSource.disableReadingStation(rsName);
    }

    public ReadingStationDTO getIDs(ReadingStationDTO readingStation) {
        ReadingStation transformedStation = transfromFromDTO(readingStation);
        ReadingStation station = dataSource.getReadingStationByName(transformedStation);
        if (station == null) {
            dataSource.addReadingStation(transformedStation);
            station = dataSource.getReadingStationByName(transformedStation);
        }
        ReadingStationDTO stationDTO = transformToDTO(station);
        return stationDTO;
    }

    public ReadingStationDTO getStatus(ReadingStationDTO rs) {
        ReadingStation station = transfromFromDTO(rs);
        if (dataSource.hasReadingStationChanged(station)) {
            return transformToDTO(dataSource.getReadingStationById(station));
        }
        return null;
    }

    public ReadingStationDTO[] getReadingStations() {
        LinkedList<ReadingStationDTO> stationDTOs = new LinkedList<ReadingStationDTO>();
        LinkedList<ReadingStation> stations = dataSource.getReadingStations();
        for (ReadingStation station : stations) {
            stationDTOs.add(transformToDTO(station));
        }
        return stationDTOs.toArray(new ReadingStationDTO[0]);
    }

    public ReadingStationDTO[] getEnabledReadingStations() {
        LinkedList<ReadingStationDTO> stationDTOs = new LinkedList<ReadingStationDTO>();
        LinkedList<ReadingStation> stations = dataSource.getEnabledReadingStations();
        for (ReadingStation station : stations) {
            stationDTOs.add(transformToDTO(station));
        }
        return stationDTOs.toArray(new ReadingStationDTO[0]);

    }

    public boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit) {
        return dataSource.setProbeAlarmLevel(probeId, newLowerLimit, newUpperLimit);
    }

    public boolean setRSName(int rsId, String newName) {
        return dataSource.setReadingStationName(rsId, newName);
    }

    private ReadingStation transfromFromDTO(ReadingStationDTO rs) {
        LinkedList<Probe> probes = new LinkedList<Probe>();

        for (ProbeDTO p : rs.getProbes()) {
            probes.add(new Probe(p.getId(), p.getUpperAlarm(), p.getLowerAlarm(), p.getUnits()));
        }
        return new ReadingStation(rs.getName(), probes, rs.isEnabled(), rs.getId());
    }

    private ReadingStationDTO transformToDTO(ReadingStation station) {
        LinkedList<ProbeDTO> probes = new LinkedList<ProbeDTO>();
        ProbeDTO probe;
        for (Probe p : station.getProbes()) {
            probe = new ProbeDTO();
            probe.setData(p.getData());
            probe.setId(p.getId());
            probe.setUpperAlarm(p.getUpperAlarm());
            probe.setLowerAlarm(p.getLowerAlarm());
            probe.setUnits(p.getUnits());
            probes.add(probe);
        }

        ReadingStationDTO rs = new ReadingStationDTO();
        rs.setName(station.getName());
        rs.setId(station.getId());
        rs.setProbes(probes.toArray(new ProbeDTO[0]));
        rs.setEnabled(station.isEnabled());
        return rs;

    }
}
