/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.domainObjects.Probe;
import dk.iha.onk.group1.server.domainObjects.ReadingStation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dk021998
 */
public class ReadingStationDSL {

    private MySQLConnector connection;

    public ReadingStationDSL() {
        connection = MySQLConnector.getInstance();
    }

    public boolean addReadingStation(ReadingStation station) {
        try {
            String query = "INSERT INTO readingstation (idReadingStation,name,enabled) VALUES (null,'" + station.getName() + "'," + station.isEnabled() + ");";
            connection.executeUpdate(query);

            query = "SELECT idReadingStation FROM readingstation WHERE name = '" + station.getName() + "';";
            ResultSet idResult = connection.executeQuery(query);
            int id = -1;
            if (idResult.next()) {
                id = idResult.getInt("idReadingStation");
            }
            for (Probe probe : station.getProbes()) {
                query = "INSERT INTO probe (ReadingStation_idReadingStation,upperAlarm,lowerAlarm,units) VALUES (" + id + "," + probe.getUpperAlarm() + "," + probe.getLowerAlarm() + ",'" + probe.getUnits() + "');";
                connection.executeUpdate(query);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean isReadingStationEnabled(int stationId) {
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement("SELECT enabled FROM readingstation WHERE idReadingStation = ? AND enabled = 1;");
            pst.setInt(1, stationId);
            ResultSet result = pst.executeQuery();
            if (result != null) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public LinkedList<ReadingStation> getReadingStations() {
        String query = "SELECT * FROM readingstation;";
        LinkedList<Probe> prbs;
        LinkedList<ReadingStation> stations = new LinkedList<ReadingStation>();
        try {

            ResultSet stationsResult = connection.executeQuery(query);
            if(stationsResult == null)
                return stations;
            while (stationsResult.next()) {
                query = "SELECT * FROM probe WHERE Readingstation_idReadingStation = " + stationsResult.getInt("idReadingStation") + ";";
                ResultSet probesResult = connection.executeQuery(query);
                prbs = new LinkedList<Probe>();
                while (probesResult.next()) {
                    prbs.add(new Probe(probesResult.getInt("idProbe"), probesResult.getDouble("upperAlarm"), probesResult.getDouble("lowerAlarm"), probesResult.getString("units")));
                }
                stations.add(new ReadingStation(stationsResult.getString("name"), prbs, stationsResult.getBoolean("enabled"), stationsResult.getInt("idReadingStation")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stations;
    }

    public LinkedList<ReadingStation> getEnabledReadingStations() {
        String query = "SELECT * FROM readingstation WHERE enabled = 1;";
        LinkedList<Probe> prbs;
        LinkedList<ReadingStation> stations = new LinkedList<ReadingStation>();
        try {
            ResultSet stationsResult = connection.executeQuery(query);
            while (stationsResult.next()) {
                query = "SELECT * FROM probe WHERE Readingstation_idReadingStation = " + stationsResult.getInt("idReadingStation") + ";";
                ResultSet probesResult = connection.executeQuery(query);
                prbs = new LinkedList<Probe>();
                while (probesResult.next()) {
                    prbs.add(new Probe(probesResult.getInt("idProbe"), probesResult.getDouble("upperAlarm"), probesResult.getDouble("lowerAlarm"), probesResult.getString("units")));
                }
                stations.add(new ReadingStation(stationsResult.getString("name"), prbs, stationsResult.getBoolean("enabled"), stationsResult.getInt("idReadingStation")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stations;
    }

    public boolean enableReadingStation(String readingStationName) {
        String query = "UPDATE readingstation SET enabled = 1 WHERE name = '" + readingStationName + "';";
        connection.executeUpdate(query);
        return true;
    }

    public boolean disableReadingStation(String readingStationName) {
        String query = "UPDATE readingstation SET enabled = 0 WHERE name = '" + readingStationName + "';";
        connection.executeUpdate(query);
        return true;
    }

    public ReadingStation getReadingStationById(int id) {
        String query = "SELECT * FROM readingstation WHERE idReadingStation = " + id + ";";
        LinkedList<Probe> prbs;
        try {
            ResultSet stationSQL = connection.executeQuery(query);

            if (stationSQL.next()) {
                ReadingStation station = new ReadingStation(stationSQL.getString("name"), new LinkedList<Probe>(), (stationSQL.getByte("enabled") == 1), stationSQL.getInt("idReadingStation"));
                station.setEnabled((stationSQL.getByte("enabled") == 1) ? true : false);

                prbs = new LinkedList<Probe>();
                query = "SELECT * FROM probe WHERE Readingstation_idReadingStation = " + station.getId() + ";";
                ResultSet probesResult = connection.executeQuery(query);
                while (probesResult.next()) {
                    prbs.add(new Probe(probesResult.getInt("idProbe"), probesResult.getDouble("upperAlarm"), probesResult.getDouble("lowerAlarm"), probesResult.getString("units")));
                }
                station.setProbes(prbs);
                return station;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public ReadingStation getReadingStationById(ReadingStation station) {
        String query = "SELECT * FROM readingstation WHERE idReadingStation = " + station.getId() + ";";
        LinkedList<Probe> prbs;
        try {
            ResultSet stationSQL = connection.executeQuery(query);
            if (stationSQL.next()) {
                station.setId(stationSQL.getInt("idReadingStation"));
                station.setName(stationSQL.getString("name"));
                station.setEnabled((stationSQL.getByte("enabled") == 1) ? true : false);
                prbs = new LinkedList<Probe>();
                query = "SELECT * FROM probe WHERE Readingstation_idReadingStation = " + station.getId() + ";";
                ResultSet probesResult = connection.executeQuery(query);
                while (probesResult.next()) {
                    prbs.add(new Probe(probesResult.getInt("idProbe"), probesResult.getDouble("upperAlarm"), probesResult.getDouble("lowerAlarm"), probesResult.getString("units")));
                }
                station.setProbes(prbs);
                return station;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ReadingStation getReadingStationByName(ReadingStation station) {
        String query = "SELECT * FROM readingstation WHERE name = '" + station.getName() + "';";
        LinkedList<Probe> prbs;
        try {
            ResultSet stationSQL = connection.executeQuery(query);
            if (stationSQL.next()) {
                station.setId(stationSQL.getInt("idReadingStation"));
                station.setName(stationSQL.getString("name"));
                station.setEnabled((stationSQL.getByte("enabled") == 1) ? true : false);
                prbs = new LinkedList<Probe>();
                query = "SELECT * FROM probe WHERE Readingstation_idReadingStation = " + station.getId() + ";";
                ResultSet probesResult = connection.executeQuery(query);
                while (probesResult.next()) {
                    prbs.add(new Probe(probesResult.getInt("idProbe"), probesResult.getDouble("upperAlarm"), probesResult.getDouble("lowerAlarm"), probesResult.getString("units")));
                }
                station.setProbes(prbs);
                return station;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getReadingStationName(int id) {
        try {
            String query = "SELECT name FROM readingstation WHERE idReadingStation = " + id + ";";
            ResultSet result = connection.executeQuery(query);
            if (result.next()) {
                return result.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public boolean setReadingStationName(int id, String newName) {
        String query = "UPDATE readingstation SET name = '" + newName + "' WHERE idReadingStation = " + id + ";";
        connection.executeUpdate(query);
        return true;
    }

    public boolean authenticateReadingStation(ReadingStation rs) {
        return true;
    }

    public boolean hasReadingStationChanged(ReadingStation station) {
        try {
            String query = "SELECT * FROM readingstation WHERE idReadingStation = " + station.getId() + ";";
            ResultSet stationResult = connection.executeQuery(query);
            ReadingStation sqlStation = new ReadingStation();
            if (stationResult.next()) {
                sqlStation.setName(stationResult.getString("name"));
                sqlStation.setEnabled((stationResult.getByte("enabled") == 1) ? true : false);
                sqlStation.setId(stationResult.getInt("idReadingStation"));

                if ((!station.getName().equals(sqlStation.getName()) || (station.isEnabled() != sqlStation.isEnabled()) || (station.getId() != sqlStation.getId()))) {
                    return true;
                }
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReadingStationDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
