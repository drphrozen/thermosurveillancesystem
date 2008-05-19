/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.domainObjects.Measurement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dk021998
 */
public class MeasurementDSL {

    private MySQLConnector connection;

    public MeasurementDSL() {
        connection = MySQLConnector.getInstance();
    }

    public void saveAlarm(Measurement alarm) {
        String query = "INSERT INTO measurement (timestamp,Probe_idProbe,lowerAlarm,upperAlarm,value) Values (null," + alarm.getProbeId() + "," + alarm.getLowerAlarm() + "," + alarm.getUpperAlarm() + "," + alarm.getValue() + ");";
        connection.executeUpdate(query);
    }

    public void saveMeasurement(Measurement measurement) {
        String query = "INSERT INTO measurement (timestamp,Probe_idProbe,lowerAlarm,upperAlarm,value) Values (null," + measurement.getProbeId() + "," + measurement.getLowerAlarm() + "," + measurement.getUpperAlarm() + "," + measurement.getValue() + ");";
        connection.executeUpdate(query);
    }

    public LinkedList<Measurement> getAlarms(Calendar from, Calendar to) {
        LinkedList<Measurement> alarms = new LinkedList<Measurement>();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM measurement WHERE timestamp > ? AND timestamp < ? AND (value > upperAlarm OR value < lowerAlarm);");
            statement.setTimestamp(1, new Timestamp(from.getTimeInMillis()));
            statement.setTimestamp(2, new Timestamp(to.getTimeInMillis()));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                alarms.add(new Measurement(result.getInt("Probe_idProbe"), getCalendarFromTimestamp(result.getTimestamp("timeStamp")), result.getDouble("value"), result.getDouble("upperAlarm"), result.getDouble("lowerAlarm")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return alarms;
    }

    public LinkedList<Measurement> getMeasurements(int probeId, Calendar from, Calendar to) {
        LinkedList<Measurement> measurements = new LinkedList<Measurement>();

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM measurement WHERE timestamp > ? AND timestamp < ? AND Probe_idProbe = " + probeId + ";");
            statement.setTimestamp(1, new Timestamp(from.getTimeInMillis()));
            statement.setTimestamp(2, new Timestamp(to.getTimeInMillis()));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                measurements.add(new Measurement(result.getInt("Probe_idProbe"), getCalendarFromTimestamp(result.getTimestamp("timeStamp")), result.getDouble("value"), result.getDouble("upperAlarm"), result.getDouble("lowerAlarm")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return measurements;
    }

    public LinkedList<Measurement> getNewestMeasurements() {
        LinkedList<Measurement> measurements = new LinkedList<Measurement>();
        //String query = "SELECT * FROM measurement GROUP BY Probe_idProbe ORDER BY timestamp DESC;";
        String query = "SELECT measurement.Probe_idProbe, measurement.timestamp, measurement.value, measurement.upperAlarm,measurement.lowerAlarm FROM measurement INNER JOIN " +
                "(SELECT Probe_idProbe, MAX(timestamp) as timestamp FROM measurement WHERE Probe_idProbe IN " +
                "(SELECT idProbe FROM probe WHERE ReadingStation_idReadingStation IN" +
                " (SELECT idReadingStation FROM readingstation WHERE enabled = 1)) " +
                "GROUP BY Probe_idProbe)ids ON ids.timestamp = measurement.timestamp AND ids.Probe_idProbe = measurement.Probe_idProbe;";

        try {
            ResultSet result = connection.executeQuery(query);
            while (result.next()) {
                System.out.println("result: " + result.getDouble("value"));
                measurements.add(new Measurement(result.getInt("Probe_idProbe"), getCalendarFromTimestamp(result.getTimestamp("timeStamp")), result.getDouble("value"), result.getDouble("upperAlarm"), result.getDouble("lowerAlarm")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MeasurementDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return measurements;
    }

    public LinkedList<Measurement> getMeasurements(Calendar from, Calendar to) {
        LinkedList<Measurement> measurements = new LinkedList<Measurement>();

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM measurement WHERE timestamp > ? AND timestamp < ?;");
            statement.setTimestamp(1, new Timestamp(from.getTimeInMillis()));
            statement.setTimestamp(2, new Timestamp(to.getTimeInMillis()));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                measurements.add(new Measurement(result.getInt("Probe_idProbe"), getCalendarFromTimestamp(result.getTimestamp("timeStamp")), result.getDouble("value"), result.getDouble("upperAlarm"), result.getDouble("lowerAlarm")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return measurements;
    }

    public double[] getMeasurements(String units, Calendar from, Calendar to) {
        LinkedList<Double> measurements = new LinkedList<Double>();

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("SELECT value FROM measurement WHERE timestamp > ? AND timestamp < ? AND Probe_idProbe IN (SELECT idProbe FROM probe WHERE units = '" + units + "');");
            statement.setTimestamp(1, new Timestamp(from.getTimeInMillis()));
            statement.setTimestamp(2, new Timestamp(to.getTimeInMillis()));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                measurements.add(result.getDouble("value"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        double[] ms = new double[measurements.size()];
        for (int i = 0; i < ms.length; i++) {
            ms[i] = measurements.get(i);
        }
        return ms;
    }

    private Calendar getCalendarFromTimestamp(Timestamp stamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(stamp.getTime());
        return cal;
    }
}
