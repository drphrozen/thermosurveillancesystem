using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

using System.Drawing;

using java.rmi;
using dk.iha.onk.group1.interfaces;
using dk.iha.onk.group1.dataTransferObjects;

namespace PSP
{
	class Station
	{
		private string name;
		public string Name
		{
			get { return name; }
			set { name = value; }
		}

		private int id;
		public int Id
		{
			get { return id; }
			set { id = value; }
		}

		private List<Probe> probes = null;
		public List<Probe> Probes
		{
			get { return probes; }
			set { probes = value; }
		}

		public Station(ReadingStationDTO station)
		{
			id = station.getId();
			name = station.getName();
			probes = new List<Probe>();
			foreach (ProbeDTO probe in station.getProbes())
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
