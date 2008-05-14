package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.domainObjects.Measurement;
import dk.iha.onk.group1.server.domainObjects.ReadingStation;
import dk.iha.onk.group1.server.domainObjects.User;
import java.util.Calendar;
import java.util.LinkedList;

public class DataSourceFacade {

    Usr usr;
    Rs rs;
    Pb pb;
    Ms ms;

    public DataSourceFacade() {
        usr = new Usr();
        rs = new Rs();
        ms = new Ms();
        pb = new Pb();
    }

    //<editor-fold desc="Readingstation">
    public boolean addReadingStation(ReadingStation readingStation) {
        return rs.addReadingStation(readingStation);
    }

    public boolean authenticateReadingStation(ReadingStation station) {
        return rs.authenticateReadingStation(station);
    }

    public boolean disableReadingStation(String rsName) {
        return rs.disableReadingStation(rsName);
    }

    public boolean enableReadingStation(String rsName) {
        return rs.enableReadingStation(rsName);
    }

    public String getRSName(int id) {
        return rs.getReadingStationName(id);
    }

    public ReadingStation getReadingStationById(ReadingStation station) {
        return rs.getReadingStationById(station);
    }

    public ReadingStation getReadingStationByName(ReadingStation station) {
        return rs.getReadingStationByName(station);
    }

    public LinkedList<ReadingStation> getReadingStations() {
        return rs.getReadingStations();
    }

    public LinkedList<ReadingStation> getEnabledReadingStations() {
        return rs.getEnabledReadingStations();
    }

    public boolean hasReadingStationChanged(ReadingStation station) {
        return rs.hasReadingStationChanged(station);
    }

    public boolean isReadingStationEnabled(int stationId) {
        return rs.isReadingStationEnabled(stationId);
    }

    public boolean setReadingStationName(int id, String newName) {
        return rs.setReadingStationName(id, newName);
    }
    //</editor-fold>

    //<editor-fold desc="User">
    public boolean authenticateUser(User user) {
        System.out.println("DS: " + user.getUsername() + "\t" + user.getPassword() + "\t" + user.getAccountType());
        return usr.authenticateUser(user);
    }

    public User getUser(int userId) {
        return usr.getUser(userId);
    }

    public boolean removeUser(String username) {
        return usr.removeUser(username);
    }

    public LinkedList<User> getUsers() {
        return usr.getUsers();
    }

    public boolean addUser(User user) {
        return usr.addUser(user);
    }

    public boolean updateUser(int userId, User newUser) {
        return usr.updateUser(userId, newUser);
    }
    //</editor-fold>

    //<editor-fold desc="Measurement">
    public void saveAlarm(Measurement alarm) {
        ms.saveAlarm(alarm);
    }

    public void saveMeasurement(Measurement measurement) {
        ms.saveMeasurement(measurement);
    }

    public LinkedList<Measurement> getAlarms(Calendar from, Calendar to) {
        return ms.getAlarms(from, to);
    }

    public LinkedList<Measurement> getMeasurements(int probeId, Calendar from, Calendar to) {
        return ms.getMeasurements(probeId, from, to);
    }

    public LinkedList<Measurement> getNewestMeasurements() {
        return ms.getNewestMeasurements();
    }

    public LinkedList<Measurement> getMeasurements(Calendar from, Calendar to) {
        return ms.getMeasurements(from, to);
    }

    public double[] getPressures(Calendar from, Calendar to) {
        return ms.getMeasurements("bar", from, to);
    }

    public double[] getTemperatures(Calendar from, Calendar to) {
        return ms.getMeasurements("celsius", from, to);
    }
    //</editor-fold>

    //<editor-fold desc="Probe">
    public boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit) {
        return pb.setAlarmLevel(probeId, newLowerLimit, newUpperLimit);
    }
    //</editor-fold>
}
