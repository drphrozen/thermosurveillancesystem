/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DAL.database.*;
import DAL.OC.*;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
/**
 *
 * @author Martin
 */
public class FacadeToDB 
{
    MeasuresTable _db_measures;
    ProbeTable _db_probes;
    RSTable _db_rs;
    UnitsTable _db_units;
    UserTable _db_users;
    
    ResultSet resultset;
    
    public FacadeToDB()
    {
        _db_measures = new MeasuresTable();
        _db_probes = new ProbeTable();
        _db_rs = new RSTable();
        _db_units = new UnitsTable();
        _db_users = new UserTable();
    }
    
    public void setRS(ReadingStation rs)
    {
        resultset = null;
        resultset = _db_rs.getRS(rs.getId());
        if(resultset == null)
        {
            _db_rs.addRS(rs.getName(), rs.isEnabled());
        }
    }
    
    public ReadingStation getRS(ReadingStation rs)
    {
        ReadingStation result = new ReadingStation();
        
        resultset = null;
        resultset = _db_rs.getRS(rs.getId());
        
        if(resultset != null)
        {
            result.setId(rs.getId());
            result.setEnabled(rs.isEnabled());
            result.setName(rs.getName());
            result.setProbes(rs.getProbes());
        }
        
        return result;
    }
    
    public void setMeasure(Measurement measurement)
    {
        resultset = null;
        Timestamp ts = Timestamp.valueOf(measurement.getTimestamp().toString());
        resultset = _db_measures.getMeasure(measurement.getProbeId(), ts);
        if(resultset == null)
        {
            _db_measures.addMeasure(measurement.getProbeId(), ts, measurement.getValue(), measurement.getUpperAlarm(), measurement.getLowerAlarm(), measurement.getReadingStationName());
        }
    }
    
    public Measurement getMeasure(Measurement measurement)
    {
        Measurement result = new Measurement();
        resultset = null;
        Timestamp ts = Timestamp.valueOf(measurement.getTimestamp().toString());
        resultset = _db_measures.getMeasure(measurement.getProbeId(), ts);
        
        if(resultset != null)
        {
            result.setLowerAlarm(measurement.getLowerAlarm());
            result.setUpperAlarm(measurement.getUpperAlarm());
            result.setProbeId(measurement.getProbeId());
            result.setReadingStationName(measurement.getReadingStationName());
            result.setTimestamp(measurement.getTimestamp());
            result.setValue(measurement.getValue());
        }
        return result;
    }
    
    public void setProbe(Probe probe, String ReadingStationName)
    {
        int RSID = _db_rs.getRSID(ReadingStationName);
        
        resultset = null;
        resultset = _db_probes.getProbe(probe.getId(), RSID);
        if(resultset == null)
        {
            _db_probes.addProbe(probe.getId(), ReadingStationName, _db_units.getUnitID(probe.getUnits()), probe.getUpperAlarm(), probe.getLowerAlarm());
        }
    }
    
    public Probe getProbe(Probe probe, String ReadingStationName)
    {
        Probe result = new Probe();
        
        int rsresult = -1;
        rsresult = _db_rs.getRSID(ReadingStationName);
        
        if(rsresult != -1)
        {
            resultset = null;
            resultset = _db_probes.getProbe(probe.getId(), rsresult);

            if(resultset != null)
            {
                result.setLowerAlarm(probe.getLowerAlarm());
                result.setUpperAlarm(probe.getUpperAlarm());
                result.setId(probe.getId());
                result.setData(probe.getData());
                result.setUnits(probe.getUnits());
            }
        }
        return result;
    }
    
    public void setUnit(Unit unit)
    {
        resultset = null;
        resultset = _db_units.getUnit(unit.getUnitID());
        if(resultset == null)
        {
            _db_units.addUnit(unit.getUnitText());
        }
    }
    
    public Unit getUnit(Unit unit)
    {
        Unit result = new Unit();
        resultset = null;
        resultset = _db_units.getUnit(unit.getUnitID());
        if(resultset != null)
        {
            result.setUnitID(unit.getUnitID());
            result.setUnitText(unit.getUnitText());
        }
        return result;
    }
    
    public void setUser(User user)
    {
        resultset = null;
        resultset = _db_users.getUser(user.getUsername(), user.getPassword());
        
        if(resultset != null)
        {
            _db_users.addUser(user.getUsername(), user.getPassword(), user.getAccountTypeId());
        }
    }
    
    public User getUser(User user)
    {
        User result = new User();
        resultset = null;
        resultset = _db_users.getUser(user.getUsername(), user.getPassword());
        
        if(resultset != null)
        {
            result.setUsername(user.getUsername());
            result.setPassword(user.getPassword());
            result.setAccountTypeId(user.getAccountTypeId());
        }
        return result;
    }
}
