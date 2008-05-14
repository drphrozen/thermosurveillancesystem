package dk.iha.onk.group1.server.domainObjects;

/**
 *
 * @author dk021998
 */
public class Probe implements Comparable<Probe> {

    private int id;
    private double data;
    private double upperAlarm;
    private double lowerAlarm;
    private String units;

    public Probe(int id, double upperAlarm, double lowerAlarm, String units) {
        setId(id);
        setLowerAlarm(lowerAlarm);
        setUpperAlarm(upperAlarm);
        setUnits(units);
    }

    public int compareTo(Probe p) {
        if (this.getData() < p.getData()) {
            return -1;
        } else if (this.getData() > p.getData()) {
            return 1;
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public double getUpperAlarm() {
        return upperAlarm;
    }

    public void setUpperAlarm(double upperAlarm) {
        this.upperAlarm = upperAlarm;
    }

    public double getLowerAlarm() {
        return lowerAlarm;
    }

    public void setLowerAlarm(double lowerAlarm) {
        this.lowerAlarm = lowerAlarm;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
