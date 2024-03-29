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

namespace PSP.TSSServer {
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
    [System.Web.Services.WebServiceBindingAttribute(Name="TSSUserServiceSoapBinding", Namespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
    [System.Xml.Serialization.SoapIncludeAttribute(typeof(MeasurementDTO))]
    [System.Xml.Serialization.SoapIncludeAttribute(typeof(ProbeDTO))]
    [System.Xml.Serialization.SoapIncludeAttribute(typeof(ReadingStationDTO))]
    public partial class UserFacadeService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback loginOperationCompleted;
        
        private System.Threading.SendOrPostCallback getReadingStationsOperationCompleted;
        
        private System.Threading.SendOrPostCallback getMeasurementsOperationCompleted;
        
        private System.Threading.SendOrPostCallback getNewestMeasurementsOperationCompleted;
        
        private System.Threading.SendOrPostCallback getLastHourOfReadingsOperationCompleted;
        
        private System.Threading.SendOrPostCallback getHistoricalDataOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public UserFacadeService() {
            this.Url = global::PSP.Properties.Settings.Default.PSP_TSSServer_UserFacadeService;
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
        public event loginCompletedEventHandler loginCompleted;
        
        /// <remarks/>
        public event getReadingStationsCompletedEventHandler getReadingStationsCompleted;
        
        /// <remarks/>
        public event getMeasurementsCompletedEventHandler getMeasurementsCompleted;
        
        /// <remarks/>
        public event getNewestMeasurementsCompletedEventHandler getNewestMeasurementsCompleted;
        
        /// <remarks/>
        public event getLastHourOfReadingsCompletedEventHandler getLastHourOfReadingsCompleted;
        
        /// <remarks/>
        public event getHistoricalDataCompletedEventHandler getHistoricalDataCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
        [return: System.Xml.Serialization.SoapElementAttribute("loginReturn")]
        public bool login(UserDTO in0) {
            object[] results = this.Invoke("login", new object[] {
                        in0});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void loginAsync(UserDTO in0) {
            this.loginAsync(in0, null);
        }
        
        /// <remarks/>
        public void loginAsync(UserDTO in0, object userState) {
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
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getReadingStationsReturn")]
        public ReadingStationDTO[] getReadingStations() {
            object[] results = this.Invoke("getReadingStations", new object[0]);
            return ((ReadingStationDTO[])(results[0]));
        }
        
        /// <remarks/>
        public void getReadingStationsAsync() {
            this.getReadingStationsAsync(null);
        }
        
        /// <remarks/>
        public void getReadingStationsAsync(object userState) {
            if ((this.getReadingStationsOperationCompleted == null)) {
                this.getReadingStationsOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetReadingStationsOperationCompleted);
            }
            this.InvokeAsync("getReadingStations", new object[0], this.getReadingStationsOperationCompleted, userState);
        }
        
        private void OngetReadingStationsOperationCompleted(object arg) {
            if ((this.getReadingStationsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getReadingStationsCompleted(this, new getReadingStationsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getMeasurementsReturn")]
        public MeasurementDTO[] getMeasurements(System.DateTime in0, System.DateTime in1) {
            object[] results = this.Invoke("getMeasurements", new object[] {
                        in0,
                        in1});
            return ((MeasurementDTO[])(results[0]));
        }
        
        /// <remarks/>
        public void getMeasurementsAsync(System.DateTime in0, System.DateTime in1) {
            this.getMeasurementsAsync(in0, in1, null);
        }
        
        /// <remarks/>
        public void getMeasurementsAsync(System.DateTime in0, System.DateTime in1, object userState) {
            if ((this.getMeasurementsOperationCompleted == null)) {
                this.getMeasurementsOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetMeasurementsOperationCompleted);
            }
            this.InvokeAsync("getMeasurements", new object[] {
                        in0,
                        in1}, this.getMeasurementsOperationCompleted, userState);
        }
        
        private void OngetMeasurementsOperationCompleted(object arg) {
            if ((this.getMeasurementsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getMeasurementsCompleted(this, new getMeasurementsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getNewestMeasurementsReturn")]
        public MeasurementDTO[] getNewestMeasurements() {
            object[] results = this.Invoke("getNewestMeasurements", new object[0]);
            return ((MeasurementDTO[])(results[0]));
        }
        
        /// <remarks/>
        public void getNewestMeasurementsAsync() {
            this.getNewestMeasurementsAsync(null);
        }
        
        /// <remarks/>
        public void getNewestMeasurementsAsync(object userState) {
            if ((this.getNewestMeasurementsOperationCompleted == null)) {
                this.getNewestMeasurementsOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetNewestMeasurementsOperationCompleted);
            }
            this.InvokeAsync("getNewestMeasurements", new object[0], this.getNewestMeasurementsOperationCompleted, userState);
        }
        
        private void OngetNewestMeasurementsOperationCompleted(object arg) {
            if ((this.getNewestMeasurementsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getNewestMeasurementsCompleted(this, new getNewestMeasurementsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getLastHourOfReadingsReturn")]
        public MeasurementDTO[] getLastHourOfReadings(int in0) {
            object[] results = this.Invoke("getLastHourOfReadings", new object[] {
                        in0});
            return ((MeasurementDTO[])(results[0]));
        }
        
        /// <remarks/>
        public void getLastHourOfReadingsAsync(int in0) {
            this.getLastHourOfReadingsAsync(in0, null);
        }
        
        /// <remarks/>
        public void getLastHourOfReadingsAsync(int in0, object userState) {
            if ((this.getLastHourOfReadingsOperationCompleted == null)) {
                this.getLastHourOfReadingsOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetLastHourOfReadingsOperationCompleted);
            }
            this.InvokeAsync("getLastHourOfReadings", new object[] {
                        in0}, this.getLastHourOfReadingsOperationCompleted, userState);
        }
        
        private void OngetLastHourOfReadingsOperationCompleted(object arg) {
            if ((this.getLastHourOfReadingsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getLastHourOfReadingsCompleted(this, new getLastHourOfReadingsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://facades.server.group1.onk.iha.dk", ResponseNamespace="http://172.21.185.177:8080/axis/services/TSSUserService")]
        [return: System.Xml.Serialization.SoapElementAttribute("getHistoricalDataReturn")]
        public SummaryDTO getHistoricalData(System.DateTime in0, System.DateTime in1) {
            object[] results = this.Invoke("getHistoricalData", new object[] {
                        in0,
                        in1});
            return ((SummaryDTO)(results[0]));
        }
        
        /// <remarks/>
        public void getHistoricalDataAsync(System.DateTime in0, System.DateTime in1) {
            this.getHistoricalDataAsync(in0, in1, null);
        }
        
        /// <remarks/>
        public void getHistoricalDataAsync(System.DateTime in0, System.DateTime in1, object userState) {
            if ((this.getHistoricalDataOperationCompleted == null)) {
                this.getHistoricalDataOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetHistoricalDataOperationCompleted);
            }
            this.InvokeAsync("getHistoricalData", new object[] {
                        in0,
                        in1}, this.getHistoricalDataOperationCompleted, userState);
        }
        
        private void OngetHistoricalDataOperationCompleted(object arg) {
            if ((this.getHistoricalDataCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getHistoricalDataCompleted(this, new getHistoricalDataCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
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
    public partial class UserDTO {
        
        private string accountTypeField;
        
        private int idField;
        
        private string passwordField;
        
        private string usernameField;
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string accountType {
            get {
                return this.accountTypeField;
            }
            set {
                this.accountTypeField = value;
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
        public string password {
            get {
                return this.passwordField;
            }
            set {
                this.passwordField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string username {
            get {
                return this.usernameField;
            }
            set {
                this.usernameField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "2.0.50727.1433")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.SoapTypeAttribute(Namespace="urn:BeanService")]
    public partial class SummaryDTO {
        
        private string[] alarmsField;
        
        private double periodHighestPressureField;
        
        private double periodHighestTempField;
        
        private double periodLowestPressureField;
        
        private double periodLowestTempField;
        
        /// <remarks/>
        [System.Xml.Serialization.SoapElementAttribute(IsNullable=true)]
        public string[] alarms {
            get {
                return this.alarmsField;
            }
            set {
                this.alarmsField = value;
            }
        }
        
        /// <remarks/>
        public double periodHighestPressure {
            get {
                return this.periodHighestPressureField;
            }
            set {
                this.periodHighestPressureField = value;
            }
        }
        
        /// <remarks/>
        public double periodHighestTemp {
            get {
                return this.periodHighestTempField;
            }
            set {
                this.periodHighestTempField = value;
            }
        }
        
        /// <remarks/>
        public double periodLowestPressure {
            get {
                return this.periodLowestPressureField;
            }
            set {
                this.periodLowestPressureField = value;
            }
        }
        
        /// <remarks/>
        public double periodLowestTemp {
            get {
                return this.periodLowestTempField;
            }
            set {
                this.periodLowestTempField = value;
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
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void getReadingStationsCompletedEventHandler(object sender, getReadingStationsCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getReadingStationsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getReadingStationsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public ReadingStationDTO[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((ReadingStationDTO[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void getMeasurementsCompletedEventHandler(object sender, getMeasurementsCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getMeasurementsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getMeasurementsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public MeasurementDTO[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((MeasurementDTO[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void getNewestMeasurementsCompletedEventHandler(object sender, getNewestMeasurementsCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getNewestMeasurementsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getNewestMeasurementsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public MeasurementDTO[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((MeasurementDTO[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void getLastHourOfReadingsCompletedEventHandler(object sender, getLastHourOfReadingsCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getLastHourOfReadingsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getLastHourOfReadingsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public MeasurementDTO[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((MeasurementDTO[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    public delegate void getHistoricalDataCompletedEventHandler(object sender, getHistoricalDataCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getHistoricalDataCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getHistoricalDataCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public SummaryDTO Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((SummaryDTO)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591