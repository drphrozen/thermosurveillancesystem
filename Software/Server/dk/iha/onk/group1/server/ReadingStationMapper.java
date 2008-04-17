package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataSourceLayer.RSTable;
import dk.iha.onk.group1.server.dataSourceLayer.MeasuresTable;
import dk.iha.onk.group1.server.pojo.*;
import java.util.Calendar;
import java.util.LinkedList;

public class ReadingStationMapper 
{
    private RSTable rsTable;
    
    public ReadingStationMapper()
    {
        rsTable = new RSTable();
    }
    
    public void saveReading(ReadingStationDTO rs)
    {
        ReadingStation station = transfromFromDTO(rs);
        
        if (rsTable.isReadingStationEnabled(station))
        {
//            rsTable.addMeasure(station);
        }
    }
    
    public void saveAlarm(ReadingStationDTO rsAlarm)
    {
        ReadingStation station = transfromFromDTO(rsAlarm);
        
        if (rsTable.isReadingStationEnabled(station))
        {
  //          rsTable.addMeasure(station);
        }           
    }
    
    public boolean enableReadingStation(String rsName)
    {
//        return rsTable.enableRS(rsName);
        return true;
    }
    
    public boolean disableReadingStation(String rsName)
    {
//        return rsTable.disableRS(rsName);
        return true;
    }
    
    public ReadingStationDTO getStatus(ReadingStationDTO rs)
    {
        ReadingStation station = transfromFromDTO(rs);
      //  if (rsTable.hasChanged(station))
      //      return transformToDTO(rsTable.getReadingStation(station));
        return null;
    }
    
    public ReadingStationDTO[] getNewestReadings()
    {
        LinkedList<ReadingStationDTO> stationDTOs = new LinkedList<ReadingStationDTO>();
//        LinkedList<ReadingStation> stations = rsTable.getNewestReadings();
        LinkedList<ReadingStation> stations = new LinkedList<ReadingStation>();
        for (ReadingStation station:stations)
        {
            stationDTOs.add(transformToDTO(station));
        }
        return stationDTOs.toArray(new ReadingStationDTO[0]);
    }
    
    public ReadingStationDTO[] getReadings(Calendar from, Calendar to)
    {
        LinkedList<ReadingStationDTO> stationDTOs = new LinkedList<ReadingStationDTO>();
//        LinkedList<ReadingStation> stations = rsTable.getReadings(from,to);
        LinkedList<ReadingStation> stations = new LinkedList<ReadingStation>(); // test
        for (ReadingStation station:stations)
        {
            stationDTOs.add(transformToDTO(station));
        }
        return stationDTOs.toArray(new ReadingStationDTO[0]);
    }

    public ReadingStationDTO[] getReadingStations()
    {
        LinkedList<ReadingStationDTO> stationDTOs = new LinkedList<ReadingStationDTO>();
        LinkedList<ReadingStation> stations = rsTable.getReadingStations();
        for (ReadingStation station:stations)
        {
            stationDTOs.add(transformToDTO(station));
        }
        return stationDTOs.toArray(new ReadingStationDTO[0]);
    }

    public boolean setRSAlarmLevel(String rsName,int probeId, double newLowerLimit, double newUpperLimit)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean setRSName(String oldName, String newName)
    {
//        rsTable.changeRSName(oldName,newName);
        return true;
    }
    
    private ReadingStation transfromFromDTO(ReadingStationDTO rs)
    {
        LinkedList<Probe> probes = new LinkedList<Probe>();
       
        for(ProbeDTO p: rs.getProbes())
        {
             probes.add(new Probe(p.getId(),p.getData(),p.getUpperAlarm(),p.getLowerAlarm(),p.getUnits()));
        }
        return new ReadingStation(rs.getName(), probes, rs.isEnabled(), rs.getId());
    }
    
    private ReadingStationDTO transformToDTO(ReadingStation station)
    {
        LinkedList<ProbeDTO> probes = new LinkedList<ProbeDTO>();
        ProbeDTO probe;
        for (Probe p: station.getProbes())
        {
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
