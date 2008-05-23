package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.ProbeDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import java.io.File;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SimStub {

    private LinkedList<ReadingStationDTO> stations = new LinkedList<ReadingStationDTO>();
    private static SimStub Instance;
    private File file;

    private SimStub() {
        file = new File("C:/IHA/Programs/Tomcat 5.5/webapps/ROOT/tss/readings/readings.xml");

        ReadingStationDTO rs = new ReadingStationDTO();
        LinkedList<ProbeDTO> probes = new LinkedList<ProbeDTO>();
        ProbeDTO probe1 = new ProbeDTO();
        probe1.setId(1);
        probe1.setData(42);
        probe1.setLowerAlarm(-1.5);
        probe1.setUpperAlarm(75.8);
        probe1.setUnits("*C");
        probes.add(probe1);

        ProbeDTO probe2 = new ProbeDTO();
        probe2.setId(2);
        probe2.setData(3);
        probe2.setLowerAlarm(-5.9);
        probe2.setUpperAlarm(35.3);
        probe2.setUnits("bar");
        probes.add(probe2);
        rs.setName("det er flot");
        rs.setProbes(probes.toArray(new ProbeDTO[0]));
        stations.add(rs);


        rs = new ReadingStationDTO();
        probes = new LinkedList<ProbeDTO>();
        probe1 = new ProbeDTO();
        probe1.setId(56);
        probe1.setData(30);
        probe1.setLowerAlarm(1);
        probe1.setUpperAlarm(80.4);
        probe1.setUnits("*C");
        probes.add(probe1);

        probe2 = new ProbeDTO();
        probe2.setId(57);
        probe2.setData(45);
        probe2.setLowerAlarm(-20.5);
        probe2.setUpperAlarm(15.3);
        probe2.setUnits("bar");
        probes.add(probe2);
        rs.setName("Esbens station");
        rs.setProbes(probes.toArray(new ProbeDTO[0]));
        stations.add(rs);
    }

    public static SimStub instance() {
        if (Instance == null) {
            Instance = new SimStub();
        }
        return Instance;
    }

    public void writeToFile(ReadingStationDTO rs) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmlDoc = db.parse(file);

            Element root = xmlDoc.getDocumentElement();
            String output = "";
            String rsName = rs.getName();
            // String tStamp = rs.getTimestamp().getTime().toString();
            Element newChild = xmlDoc.createElement("reading");

            Element name = xmlDoc.createElement("name");
            name.setTextContent(rsName);

            newChild.appendChild(name);

            //Element stamp = xmlDoc.createElement("timestamp");
            //stamp.setTextContent(tStamp);

            //newChild.appendChild(stamp);

            root.appendChild(newChild);

            TransformerFactory tf = TransformerFactory.newInstance();
            // set all necessary features for your transformer -> see OutputKeys
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(xmlDoc), new StreamResult(file));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ReadingStationDTO[] getReadingStations() {
        return stations.toArray(new ReadingStationDTO[0]);
    }

    public boolean setReadingStationName(String oldName, String newName) {
        for (ReadingStationDTO rs : stations) {
            if (rs.getName().equals(oldName)) {
                rs.setName(newName);
                return true;
            }
        }
        return false;
    }

    public void saveReading(ReadingStationDTO reading) {
        stations.add(reading);
    }
}
