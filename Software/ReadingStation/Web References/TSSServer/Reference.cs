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

namespace ReadingStation.TSSServer {
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
    [System.Xml.Serialization.SoapIncludeAttribute(typeof(ProbeDTO))]
    public partial class ReadingStationFacadeService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback getStatusOperationCompleted;
        
        private System.Threading.SendOrPostCallback loginOperationCompleted;
        
        private System.Threading.SendOrPostCallback deliverMeasurementsOperationCompleted;
        
        private System.Threading.SendOrPostCallback deliverAlarmOperationCompleted;
        
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
        public event loginCompletedEventHandler loginCompleted;
        
        /// <remarks/>
        public event deliverMeasurementsCompletedEventHandler deliverMeasurementsCompleted;
        
        /// <remarks/>
        public event deliverAlarmCompletedEventHandler deliverAlarmCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getStatusReturn")]
        public ReadingStationDTO getStatus(ReadingStationDTO in0) {
            object[] results = this.Invoke("getStatus", new object[] {
                        in0});
            return ((ReadingStationDTO)(results[0]));
        }
        
        /// <remarks/>
        public void getStatusAsync(ReadingStationDTO in0) {
            this.getStatusAsync(in0, null);
        }
        
        /// <remarks/>
        public void getStatusAsync(ReadingStationDTO in0, object userState) {
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
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        [return: System.Xml.Serialization.SoapElementAttribute("loginReturn")]
        public ReadingStationDTO login(ReadingStationDTO in0) {
            object[] results = this.Invoke("login", new object[] {
                        in0});
            return ((ReadingStationDTO)(results[0]));
        }
        
        /// <remarks/>
        public void loginAsync(ReadingStationDTO in0) {
            this.loginAsync(in0, null);
        }
        
        /// <remarks/>
        public void loginAsync(ReadingStationDTO in0, object userState) {
            if ((this.loginOperationCompleted == null)) {
                this.loginOperationCompleted = new System.Threading.SendOrPostCallback(this.OnloginOperationCompleted);
            }
            this.InvokeAsync("login", new object[] {
                        in0}, this.loginOperationCompleted, userState);
        }
        
        private void OnloginOperationCompleted(object arg) {
            if ((this.loginCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.loginCompleted(this, new loginCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        public void deliverMeasurements(MeasurementDTO[] in0) {
            this.Invoke("deliverMeasurements", new object[] {
                        in0});
        }
        
        /// <remarks/>
        public void deliverMeasurementsAsync(MeasurementDTO[] in0) {
            this.deliverMeasurementsAsync(in0, null);
        }
        
        /// <remarks/>
        public void deliverMeasurementsAsync(MeasurementDTO[] in0, object userState) {
            if ((this.deliverMeasurementsOperationCompleted == null)) {
                this.deliverMeasurementsOperationCompleted = new System.Threading.SendOrPostCallback(this.OndeliverMeasurementsOperationCompleted);
            }
            this.InvokeAsync("deliverMeasurements", new object[] {
                        in0}, this.deliverMeasurementsOperationCompleted, userState);
        }
        
        private void OndeliverMeasurementsOperationCompleted(object arg) {
            if ((this.deliverMeasurementsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.deliverMeasurementsCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSReadingStationService")]
        public void deliverAlarm(MeasurementDTO in0) {
            this.Invoke("deliverAlarm", new object[] {
                        in0});
        }
        
        /// <remarks/>
        public void deliverAlarmAsync(MeasurementDTO in0) {
            this.deliverAlarmAsync(in0, null);
        }
        
        /// <remarks/>
        public void deliverAlarmAsync(MeasurementDTO in0, object userState) {
            if ((this.deliverAlarmOperationCompleted == null)) {
                this.deliverAlarmOperationCompleted = new System.Threading.SendOrPostCallback(this.OndeliverAlarmOperationCompleted);
            }
            this.InvokeAsync("deliverAlarm", new object[] {
                        in0}, this.deliverAlarmOperationCompleted, userState);
        }
        
        private void OndeliverAlarmOperationCompleted(object arg) {
            if ((this.deliverAlarmCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.deliverAlarmCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
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
        
        private bool enabledField;
        
        private int idField;
        
        private string nameField;
        
        private ProbeDTO[] probesField;
        
        /// <remarks/>
        public bool enabled {
            get {
                return this.enabledField;
            }
            set {
                this.enabledField = value;
            }
        }
        
        /// <remarks/>
        public int id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public ProbeDTO[] probes {
            get {
                return this.probesField;
            }
            set {
                this.probesField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class ProbeDTO {
        
        private double dataField;
        
        private int idField;
        
        private double lowerAlarmField;
        
        private string unitsField;
        
        private double upperAlarmField;
        
        /// <remarks/>
        public double data {
            get {
                return this.dataField;
            }
            set {
                this.dataField = value;
            }
        }
        
        /// <remarks/>
        public int id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
            }
        }
        
        /// <remarks/>
        public double lowerAlarm {
            get {
                return this.lowerAlarmField;
            }
            set {
                this.lowerAlarmField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string units {
            get {
                return this.unitsField;
            }
            set {
                this.unitsField = value;
            }
        }
        
        /// <remarks/>
        public double upperAlarm {
            get {
                return this.upperAlarmField;
            }
            set {
                this.upperAlarmField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class MeasurementDTO {
        
        private double lowerAlarmField;
        
        private int probeIdField;
        
        private int readingStationIdField;
        
        private System.Nullable<System.DateTime> timestampField;
        
        private double upperAlarmField;
        
        private double valueField;
        
        /// <remarks/>
        public double lowerAlarm {
            get {
                return this.lowerAlarmField;
            }
            set {
                this.lowerAlarmField = value;
            }
        }
        
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
        public int readingStationId {
            get {
                return this.readingStationIdField;
            }
            set {
                this.readingStationIdField = value;
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
        
        /// <remarks/>
        public double upperAlarm {
            get {
                return this.upperAlarmField;
            }
            set {
                this.upperAlarmField = value;
            }
        }
        
        /// <remarks/>
        public double value {
            get {
                return this.valueField;
            }
            set {
                this.valueField = value;
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
    public delegate void loginCompletedEventHandler(object sender, loginCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class loginCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal loginCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
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
    public delegate void deliverMeasurementsCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void deliverAlarmCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
}

#pragma warning restore 1591