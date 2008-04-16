using System;
using System.Collections.Generic;
using System.Text;
using PSP.TSSServer;
using System.Windows.Forms;
using System.Drawing;

namespace PSP
{
	class Probe
	{
		private int id;
		public int Id
		{
			get { return id; }
			set { id = value; }
		}

		private double data;
		public double Data
		{
			get { return data; }
			set { data = value; }
		}

		private double lowerAlarm;
		public double LowerAlarm
		{
			get { return lowerAlarm; }
			set { lowerAlarm = value; }
		}

		private double upperAlarm;
		public double UpperAlarm
		{
			get { return upperAlarm; }
			set { upperAlarm = value; }
		}

		private string units;
		public string Units
		{
			get { return units; }
			set { units = value; }
		}


		public Probe(ProbeDTO probe)
		{
			id = probe.id;
			data = probe.data;
			lowerAlarm = probe.lowerAlarm;
			upperAlarm = probe.upperAlarm;
			units = probe.units;
		}

		public bool AlarmRaised()
		{
			return (LowerAlarmRaised() || UpperAlarmRaised());
		}

		public bool UpperAlarmRaised()
		{
			return (data > upperAlarm);
		}

		public bool LowerAlarmRaised()
		{
			return (lowerAlarm > data);
		}

		public TreeNode GetAsTreeNode()
		{
			TreeNode node = new TreeNode();
			node.Name = id.ToString();
			node.Text = id.ToString() + " - " + data.ToString() + " " + units;
			node.Tag = this;
			if (AlarmRaised())
			{
				node.ForeColor = Color.Red;
			}
			return node;
		}
	}
}
