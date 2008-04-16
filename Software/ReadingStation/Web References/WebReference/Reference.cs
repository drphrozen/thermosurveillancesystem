﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:2.0.50727.1433
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by Microsoft.VSDesigner, Version 2.0.50727.1433.
// 
#pragma warning disable 1591

namespace ReadingStation.WebReference {
    using System.Diagnostics;
    using System.Web.Services;
    using System.ComponentModel;
    using System.Web.Services.Protocols;
    using System;
    using System.Xml.Serialization;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="TSSReadingStationServiceSoapBinding", Namespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
    public partial class ReadingStationFacadeService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback getStatusOperationCompleted;
        
        private System.Threading.SendOrPostCallback deliverReadingOperationCompleted;
        
        private System.Threading.SendOrPostCallback presentOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public ReadingStationFacadeService() {
            this.Url = global::ReadingStation.Properties.Settings.Default.ReadingStation_WebReference_RSFacadeService;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event getStatusCompletedEventHandler getStatusCompleted;
        
        /// <remarks/>
        public event deliverReadingCompletedEventHandler deliverReadingCompleted;
        
        /// <remarks/>
        public event presentCompletedEventHandler presentCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getStatusReturn")]
        public ReadingStationDTO getStatus(string in0) {
            object[] results = this.Invoke("getStatus", new object[] {
                        in0});
            return ((ReadingStationDTO)(results[0]));
        }
        
        /// <remarks/>
        public void getStatusAsync(string in0) {
            this.getStatusAsync(in0, null);
        }
        
        /// <remarks/>
        public void getStatusAsync(string in0, object userState) {
            if ((this.getStatusOperationCompleted == null)) {
                this.getStatusOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetStatusOperationCompleted);
            }
            this.InvokeAsync("getStatus", new object[] {
                        in0}, this.getStatusOperationCompleted, userState);
        }
        
        private void OngetStatusOperationCompleted(object arg) {
            if ((this.getStatusCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getStatusCompleted(this, new getStatusCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        public void deliverReading(MeasurementDTO in0) {
            this.Invoke("deliverReading", new object[] {
                        in0});
        }
        
        /// <remarks/>
        public void deliverReadingAsync(MeasurementDTO in0) {
            this.deliverReadingAsync(in0, null);
        }
        
        /// <remarks/>
        public void deliverReadingAsync(MeasurementDTO in0, object userState) {
            if ((this.deliverReadingOperationCompleted == null)) {
                this.deliverReadingOperationCompleted = new System.Threading.SendOrPostCallback(this.OndeliverReadingOperationCompleted);
            }
            this.InvokeAsync("deliverReading", new object[] {
                        in0}, this.deliverReadingOperationCompleted, userState);
        }
        
        private void OndeliverReadingOperationCompleted(object arg) {
            if ((this.deliverReadingCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.deliverReadingCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        [return: System.Xml.Serialization.SoapElementAttribute("presentReturn")]
        public bool present(ReadingStationDTO in0) {
            object[] results = this.Invoke("present", new object[] {
                        in0});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void presentAsync(ReadingStationDTO in0) {
            this.presentAsync(in0, null);
        }
        
        /// <remarks/>
        public void presentAsync(ReadingStationDTO in0, object userState) {
            if ((this.presentOperationCompleted == null)) {
                this.presentOperationCompleted = new System.Threading.SendOrPostCallback(this.OnpresentOperationCompleted);
            }
            this.InvokeAsync("present", new object[] {
                        in0}, this.presentOperationCompleted, userState);
        }
        
        private void OnpresentOperationCompleted(object arg) {
            if ((this.presentCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.presentCompleted(this, new presentCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class ReadingStationDTO {
        
        private int alarmLevelField;
        
        private string stationNameField;
        
        /// <remarks/>
        public int alarmLevel {
            get {
                return this.alarmLevelField;
            }
            set {
                this.alarmLevelField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string stationName {
            get {
                return this.stationNameField;
            }
            set {
                this.stationNameField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.SoapIncludeAttribute(typeof(PressureDTO))]
    [System.Xml.Serialization.SoapIncludeAttribute(typeof(TemperatureDTO))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class MeasurementDTO {
        
        private int probeIdField;
        
        private string readingStationNameField;
        
        private System.Nullable<System.DateTime> timestampField;
        
        /// <remarks/>
        public int probeId {
            get {
                return this.probeIdField;
            }
            set {
                this.probeIdField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string readingStationName {
            get {
                return this.readingStationNameField;
            }
            set {
                this.readingStationNameField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public System.Nullable<System.DateTime> timestamp {
            get {
                return this.timestampField;
            }
            set {
                this.timestampField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class PressureDTO : MeasurementDTO {
        
        private int dataField;
        
        /// <remarks/>
        public int data {
            get {
                return this.dataField;
            }
            set {
                this.dataField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class TemperatureDTO : MeasurementDTO {
        
        private int dataField;
        
        /// <remarks/>
        public int data {
            get {
                return this.dataField;
            }
            set {
                this.dataField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void getStatusCompletedEventHandler(object sender, getStatusCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getStatusCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getStatusCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public ReadingStationDTO Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((ReadingStationDTO)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void deliverReadingCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void presentCompletedEventHandler(object sender, presentCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class presentCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal presentCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591