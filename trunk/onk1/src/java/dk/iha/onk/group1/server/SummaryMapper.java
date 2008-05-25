package dk.iha.onk.group1.server;

import dk.iha.onk.group1.dataTransferObjects.SummaryDTO;
import dk.iha.onk.group1.server.dataSourceLayer.DataSourceFacade;
import dk.iha.onk.group1.server.domainObjects.Measurement;
import java.util.Calendar;
import java.util.LinkedList;

public class SummaryMapper {

    private DataSourceFacade dataSource;

    public SummaryMapper() {
        dataSource = new DataSourceFacade();
    }

    public SummaryDTO generateSummary(Calendar from, Calendar to) {
        SummaryDTO summary = new SummaryDTO();
        LinkedList<String> alarms_summary = new LinkedList<String>();
        LinkedList<Measurement> alarms = new LinkedList<Measurement>();
        String alarmInfo;

        double[] temperatures = dataSource.getTemperatures(from, to);
        double[] pressures = dataSource.getPressures(from, to);

        summary.setPeriodHighestTemp(getHighest(temperatures));
        summary.setPeriodLowestTemp(getLowest(temperatures));
        summary.setPeriodHighestPressure(getHighest(pressures));
        summary.setPeriodLowestPressure(getLowest(pressures));

        alarms = dataSource.getAlarms(from, to);
        for (Measurement alarm : alarms) {
            alarmInfo = alarm.getProbeId() + " at " + alarm.getTimestamp().getTime() + " raised alarm with value = " + String.format("%02.1f", alarm.getValue()) + " (upper = " + alarm.getUpperAlarm() + ", lower = " + alarm.getLowerAlarm() + ")";
            alarms_summary.add(alarmInfo);
        }
        summary.setAlarms(alarms_summary.toArray(new String[0]));

        return summary;
    }

    private double getHighest(double[] values) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double current : values) {
            if (current > highest) {
                highest = current;
            }
        }
        return highest;
    }

    private double getLowest(double[] values) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double current : values) {
            if (current < lowest) {
                lowest = current;
            }
        }
        return lowest;
    }
}
