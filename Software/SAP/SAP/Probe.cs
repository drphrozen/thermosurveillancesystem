using System;
using System.Collections.Generic;
using System.Text;
using SAP.AdminFacade;
using System.ComponentModel;
using System.Collections;

namespace SAP
{
    [TypeConverter(typeof(ProbeConverter))]
    class Probe
    {
        private double data;

        [Browsable(false)]
        public double Data
        {
            get { return data; }
            set { data = value; }
        }
        private int id;

        [Browsable(false)]
        public int ID
        {
            get { return id; }
            set { id = value; }
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

        public Probe()
        {

        }

        public Probe(ProbeDTO probe)
        {
            data = probe.data;
            id = probe.id;
            lowerAlarm = probe.lowerAlarm;
            upperAlarm = probe.upperAlarm;
        }

        public static ProbeCollection GetProbes(ProbeDTO[] probes)
        {
            int length = probes.Length;
            ProbeCollection probesOut = new ProbeCollection();
            for(int i = 0; i<length ; i++)
                probesOut.Add(new Probe(probes[i]));
            return probesOut;
        }

        public override string ToString()
        {
            return "Probe #" + ID + ", data: " + Data + ", alarm: " + LowerAlarm + " - " + UpperAlarm;
        }
    }

    class ProbeCollection : CollectionBase, ICustomTypeDescriptor
    {
        private PropertyDescriptorCollection pds;

        public void Add(Probe probe)
        {
            this.List.Add(probe);
        }
        
        public void Remove(Probe probe)
        {
            this.List.Remove(probe);
        }
        
        public Probe this[int index]
        {
            get
            {
                return (Probe)this.List[index];
            }
        }

        #region ICustomTypeDescriptor Members

        public String GetClassName()
        {
            return TypeDescriptor.GetClassName(this, true);
        }

        public AttributeCollection GetAttributes()
        {
            return TypeDescriptor.GetAttributes(this, true);
        }

        public String GetComponentName()
        {
            return TypeDescriptor.GetComponentName(this, true);
        }

        public TypeConverter GetConverter()
        {
            return TypeDescriptor.GetConverter(this, true);
        }

        public EventDescriptor GetDefaultEvent()
        {
            return TypeDescriptor.GetDefaultEvent(this, true);
        }

        public PropertyDescriptor GetDefaultProperty()
        {
            return TypeDescriptor.GetDefaultProperty(this, true);
        }

        public object GetEditor(Type editorBaseType)
        {
            return TypeDescriptor.GetEditor(this, editorBaseType, true);
        }

        public EventDescriptorCollection GetEvents(Attribute[] attributes)
        {
            return TypeDescriptor.GetEvents(this, attributes, true);
        }

        public EventDescriptorCollection GetEvents()
        {
            return TypeDescriptor.GetEvents(this, true);
        }

        public object GetPropertyOwner(PropertyDescriptor pd)
        {
            return this;
        }

        public PropertyDescriptorCollection GetProperties(Attribute[] attributes)
        {
            return GetProperties();
        }

        public PropertyDescriptorCollection GetProperties()
        {
            // Create a new collection object PropertyDescriptorCollection
            pds = new PropertyDescriptorCollection(null);

            // Iterate the list of employees
            for (int i = 0; i < this.List.Count; i++)
            {
                // For each employee create a property descriptor 
                // and add it to the 
                // PropertyDescriptorCollection instance
                ProbeCollectionPropertyDescriptor pd = new ProbeCollectionPropertyDescriptor(this, i);
                pds.Add(pd);
            }
            return pds;
        }

        #endregion
    }

    class ProbeCollectionPropertyDescriptor : PropertyDescriptor
    {
            private ProbeCollection collection = null;
            private int index = -1;

        public ProbeCollectionPropertyDescriptor(ProbeCollection coll, int idx) : base( "#"+idx.ToString(), null )
        {
            this.collection = coll;
            this.index = idx;
        } 

        public override AttributeCollection Attributes
        {
            get 
            { 
                return new AttributeCollection(null);
            }
        }

        public override bool CanResetValue(object component)
        {
            return true;
        }

        public override Type ComponentType
        {
            get 
            { 
                return this.collection.GetType();
            }
        }

        public override string DisplayName
        {
            get 
            {
                Probe probe = this.collection[index];
                return "#" + probe.ID;
            }
        }

        public override string Description
        {
            get
            {
                Probe probe = this.collection[index];
                return "#" + probe.ID + " " + probe.LowerAlarm + "-" + probe.UpperAlarm;
            }
        }

        public override object GetValue(object component)
        {
            return this.collection[index];
        }

        public override bool IsReadOnly
        {
            get { return true;  }
        }

        public override string Name
        {
            get { return "#"+index.ToString(); }
        }

        public override Type PropertyType
        {
            get { return this.collection[index].GetType(); }
        }

        public override void ResetValue(object component) {}

        public override bool ShouldSerializeValue(object component)
        {
            return true;
        }

        public override void SetValue(object component, object value)
        {
            // this.collection[index] = value;

        }
    }

    internal class ProbeConverter : ExpandableObjectConverter
    {
        public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType)
        {
            if (destType == typeof(string) && value is Probe)
            {
                Probe probe = (Probe)value;
                return probe.LowerAlarm + " - " + probe.UpperAlarm;
            }
            return base.ConvertTo(context, culture, value, destType);
        }
    }

    internal class ProbeCollectionConverter : ExpandableObjectConverter
    {
        public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType)
        {
            if (destType == typeof(string) && value is ProbeCollection)
            {
                ProbeCollection collection = (ProbeCollection)value;
                return collection.Count + " entries.";
            }
            return base.ConvertTo(context, culture, value, destType);
        }
    }
}
