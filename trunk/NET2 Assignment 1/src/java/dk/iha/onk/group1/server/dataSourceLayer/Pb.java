/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server.dataSourceLayer;

/**
 *
 * @author dk021998
 */
public class Pb {

    private MySQLConnector connection;

    public Pb() {
        connection = MySQLConnector.getInstance();
    }

    public boolean setAlarmLevel(int probeId, double lowerAlarm, double upperAlarm) {
        String query = "UPDATE probe SET lowerAlarm = " + lowerAlarm + ", upperAlarm = " + upperAlarm + " WHERE idProbe = " + probeId + ";";
        connection.executeUpdate(query);
        return true;
    }
}
