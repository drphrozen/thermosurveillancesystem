using System;
using System.Collections.Generic;
using System.Text;
using SAP.AdminFacade;
using System.ComponentModel;

namespace SAP
{
    class ReadingStation
    {
        private int id;
        private string name;
        private ProbeCollection probes;
        private bool enabled;

        public ReadingStation()
        {
            name = "";
            enabled = false;
            probes = new ProbeCollection();
        }

        public ReadingStation(ReadingStationDTO rs)
        {
            id = rs.id;
            name = rs.name;
            enabled = rs.enabled;
            probes = Probe.GetProbes(rs.probes);
            id = rs.id;
        }

        public bool Enabled
        {
            get { return enabled; }
            set { enabled = value; }
        }

        [TypeConverter(typeof(ProbeCollectionConverter))]
        public ProbeCollection Probes
        {
            get { return probes; }
            set { probes = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        [ReadOnly(true)]
        public int ID
        {
            get { return id; }
            set { id = value; }
        }

        public static ReadingStation[] GetReadingStations(ReadingStationDTO[] readingStations)
        {
            int length = readingStations.Length;
            ReadingStation[] readingStationsOut = new ReadingStation[length];
            for (int i = 0; i < length; i++)
                readingStationsOut[i] = new ReadingStation(readingStations[i]);
            return readingStationsOut;
        }

        public override string ToString()
        {
            return "Name: " + Name;
        }
    }
}
