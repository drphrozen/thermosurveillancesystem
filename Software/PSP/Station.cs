using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using PSP.TSSServer;
using System.Drawing;

namespace PSP
{
	class Station
	{
		List<Probe> probes = null;

		private string name;
		public string Name
		{
			get { return name; }
			set { name = value; }
		}

		public Station(ReadingStationDTO station)
		{
			name = station.name;
			probes=new List<Probe>();
			foreach (ProbeDTO probe in station.probes)
			{
				probes.Add(new Probe(probe));
			}
		}

		public TreeNode GetAsTreeNode()
		{
			TreeNode node = new TreeNode();
			node.Name = name;
			node.Text = name;
			node.Tag = this;
			foreach (Probe probe in probes)
			{
				node.Nodes.Add(probe.GetAsTreeNode());
				if (probe.AlarmRaised())
				{
					node.ForeColor = Color.Red;
				}
			}
			return node;
		}
	}
}
