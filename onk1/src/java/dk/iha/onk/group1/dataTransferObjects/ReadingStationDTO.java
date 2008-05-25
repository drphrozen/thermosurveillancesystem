package dk.iha.onk.group1.dataTransferObjects;

import java.io.Serializable;

public class ReadingStationDTO implements Serializable {

    private String name;
    private ProbeDTO[] probes;
    private boolean enabled;
    private int id;

    public ReadingStationDTO() {
        setName("Unknown");
        setProbes(new ProbeDTO[]{});
        setEnabled(false);
        setId(-1);
    }

    public String getName() {
        return name;
    }

    public void setName(String stationName) {
        this.name = stationName;
    }

    public ProbeDTO[] getProbes() {
        return probes;
    }

    public void setProbes(ProbeDTO[] probes) {
        this.probes = probes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
