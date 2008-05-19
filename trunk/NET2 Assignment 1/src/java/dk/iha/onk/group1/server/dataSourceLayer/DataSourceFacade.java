package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.domainObjects.Measurement;
import dk.iha.onk.group1.server.domainObjects.ReadingStation;
import dk.iha.onk.group1.server.domainObjects.User;
import java.util.Calendar;
import java.util.LinkedList;

public class DataSourceFacade {

    UserDSL userDSL;
    ReadingStationDSL readingStationDSL;
    ProbeDSL probeDSL;
    MeasurementDSL measurementDSL;

    public DataSourceFacade() {
        userDSL = new UserDSL();
        readingStationDSL = new ReadingStationDSL();
        measurementDSL = new MeasurementDSL();
        probeDSL = new ProbeDSL();
    }

    public MeasurementDSL getMeasurementDSL() {
        return measurementDSL;
    }

    public ProbeDSL getProbeDSL() {
        return probeDSL;
    }

    public ReadingStationDSL getReadingStationDSL() {
        return readingStationDSL;
    }

    public UserDSL getUserDSL() {
        return userDSL;
    }
    
    
    

    //<editor-fold desc="Readingstation">
    public boolean addReadingStation(ReadingStation readingStation) {
        return readingStationDSL.addReadingStation(readingStation);
    }

    public boolean authenticateReadingStation(ReadingStation station) {
        return readingStationDSL.authenticateReadingStation(station);
    }

    public boolean disableReadingStation(String rsName) {
        return readingStationDSL.disableReadingStation(rsName);
    }

    public boolean enableReadingStation(String rsName) {
        return readingStationDSL.enableReadingStation(rsName);
    }

    public String getRSName(int id) {
        return readingStationDSL.getReadingStationName(id);
    }

    public ReadingStation getReadingStationById(ReadingStation station) {
        return readingStationDSL.getReadingStationById(station);
    }

    public ReadingStation getReadingStationByName(ReadingStation station) {
        return readingStationDSL.getReadingStationByName(station);
    }

    public LinkedList<ReadingStation> getReadingStations() {
        return readingStationDSL.getReadingStations();
    }

    public LinkedList<ReadingStation> getEnabledReadingStations() {
        return readingStationDSL.getEnabledReadingStations();
    }

    public boolean hasReadingStationChanged(ReadingStation station) {
        return readingStationDSL.hasReadingStationChanged(station);
    }

    public boolean isReadingStationEnabled(int stationId) {
        return readingStationDSL.isReadingStationEnabled(stationId);
    }

    public boolean setReadingStationName(int id, String newName) {
        return readingStationDSL.setReadingStationName(id, newName);
    }
    //</editor-fold>

    //<editor-fold desc="User">
    public boolean authenticateUser(User user) {
        System.out.println("DS: " + user.getUsername() + "\t" + user.getPassword() + "\t" + user.getAccountType());
        return userDSL.authenticateUser(user);
    }

    public User getUser(int userId) {
        return userDSL.getUser(userId);
    }

    public boolean removeUser(String username) {
        return userDSL.removeUser(username);
    }

    public LinkedList<User> getUsers() {
        return userDSL.getUsers();
    }

    public boolean addUser(User user) {
        return userDSL.addUser(user);
    }

    public boolean updateUser(int userId, User newUser) {
        return userDSL.updateUser(userId, newUser);
    }
    //</editor-fold>

    //<editor-fold desc="Measurement">
    public void saveAlarm(Measurement alarm) {
        measurementDSL.saveAlarm(alarm);
    }

    public void saveMeasurement(Measurement measurement) {
        measurementDSL.saveMeasurement(measurement);
    }

    public LinkedList<Measurement> getAlarms(Calendar from, Calendar to) {
        return measurementDSL.getAlarms(from, to);
    }

    public LinkedList<Measurement> getMeasurements(int probeId, Calendar from, Calendar to) {
        return measurementDSL.getMeasurements(probeId, from, to);
    }

    public LinkedList<Measurement> getNewestMeasurements() {
        return measurementDSL.getNewestMeasurements();
    }

    public LinkedList<Measurement> getMeasurements(Calendar from, Calendar to) {
        return measurementDSL.getMeasurements(from, to);
    }

    public double[] getPressures(Calendar from, Calendar to) {
        return measurementDSL.getMeasurements("bar", from, to);
    }

    public double[] getTemperatures(Calendar from, Calendar to) {
        return measurementDSL.getMeasurements("celsius", from, to);
    }
    //</editor-fold>

    //<editor-fold desc="Probe">
    public boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit) {
        return probeDSL.setAlarmLevel(probeId, newLowerLimit, newUpperLimit);
    }
    //</editor-fold>
}
