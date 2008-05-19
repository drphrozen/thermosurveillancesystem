<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SAPReadingStation
    Created on : 19-05-2008, 07:10:21
    Author     : Esben
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:label id="label1" style="left: 24px; top: 48px; position: absolute" text="Reading Station"/>
                        <webuijsf:label id="label2" style="left: 24px; top: 72px; position: absolute" text="Name:"/>
                        <webuijsf:label id="label3" style="left: 24px; top: 96px; position: absolute" text="ID:"/>
                        <webuijsf:label binding="#{sap$SAPReadingStation.labelID}" id="labelID" style="left: 96px; top: 96px; position: absolute"/>
                        <webuijsf:table augmentTitle="false" binding="#{sap$SAPReadingStation.tableProbes}" id="tableProbes"
                            style="height: 125px; left: 24px; top: 168px; position: absolute; width: 720px" title="Probes Table" width="720">
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{sap$SAPReadingStation.probes}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="data" id="tableColumn1" sort="data">
                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['data']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="id" id="tableColumn2" sort="id">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['id']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="lowerAlarm" id="tableColumn3" sort="lowerAlarm">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['lowerAlarm']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="units" id="tableColumn4" sort="units">
                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['units']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="upperAlarm" id="tableColumn5" sort="upperAlarm">
                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['upperAlarm']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:label id="label4" style="left: 24px; top: 120px; position: absolute" text="Enabled:"/>
                        <div style="left: 24px; top: 0px; position: absolute">
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <webuijsf:textField binding="#{sap$SAPReadingStation.textFieldName}" id="textFieldName"
                            style="left: 96px; top: 72px; position: absolute" tabIndex="1" text="#{SessionBean1.readingStation.name}"/>
                        <webuijsf:button actionExpression="#{sap$SAPReadingStation.buttonUpdate_action}" binding="#{sap$SAPReadingStation.buttonUpdate}"
                            id="buttonUpdate" style="left: 95px; top: 144px; position: absolute" tabIndex="2" text="Update"/>
                        <webuijsf:checkbox binding="#{sap$SAPReadingStation.checkboxEnabled}" id="checkboxEnabled" onClick="" style="left: 96px; top: 120px; position: absolute"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
