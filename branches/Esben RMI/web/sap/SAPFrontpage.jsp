<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SAP
    Created on : 14-05-2008, 16:38:30
    Author     : ESRA
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
                        <div style="left: 24px; top: 0px; position: absolute">
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <webuijsf:panelGroup id="groupPanel1" style="left: 24px; top: 48px; position: absolute; width: 238px">
                            <webuijsf:label id="labelWelcome" text="Welcome, "/>
                            <webuijsf:label id="labelUsername" text="#{SessionBean1.username}"/>
                        </webuijsf:panelGroup>
                        <webuijsf:tabSet id="tabSet" selected="tabUsers" style="height: 286px; left: 24px; top: 72px; position: absolute; width: 622px">
                            <webuijsf:tab id="tabReadingStations" text="Reading Stations">
                                <webuijsf:panelLayout id="layoutPanel1" panelLayout="flow" style="height: 251px; position: relative; width: 623px; -rave-layout: grid">
                                    <webuijsf:listbox binding="#{sap$SAPFrontpage.listboxReadingStations}" id="listboxReadingStations"
                                        items="#{sap$SAPFrontpage.listboxReadingStationsDefaultOptions.options}" style=" left: 0px; top: 0px; position: absolute"/>
                                    <webuijsf:button actionExpression="#{sap$SAPFrontpage.buttonEditReadingStation_action}" id="buttonEditReadingStation"
                                        style="left: -1px; top: 216px; position: absolute" text="Edit"/>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                            <webuijsf:tab actionExpression="#{sap$SAPFrontpage.tabUsers_action}" id="tabUsers" text="Users">
                                <webuijsf:panelLayout id="layoutPanel2" style="height: 249px; position: relative; width: 621px; -rave-layout: grid">
                                    <webuijsf:listbox binding="#{sap$SAPFrontpage.listboxUsers}" id="listboxUsers"
                                        items="#{sap$SAPFrontpage.listboxUsersDefaultOptions.options}" style="position: absolute; left: 0px; top: 0px"/>
                                    <webuijsf:textField binding="#{sap$SAPFrontpage.textFieldUsername}" id="textFieldUsername" style="left: 192px; top: 168px; position: absolute"/>
                                    <webuijsf:button actionExpression="#{sap$SAPFrontpage.buttonAdd_action}" id="buttonAdd"
                                        style="left: 191px; top: 216px; position: absolute" text="Add"/>
                                    <webuijsf:button actionExpression="#{sap$SAPFrontpage.buttonRemove_action}" id="buttonRemove"
                                        style="left: -1px; top: 216px; position: absolute" text="Remove"/>
                                    <webuijsf:passwordField binding="#{sap$SAPFrontpage.passwordFieldPassword}" id="passwordFieldPassword" style="left: 192px; top: 192px; position: absolute"/>
                                    <webuijsf:dropDown binding="#{sap$SAPFrontpage.dropDownAccountType}" id="dropDownAccountType"
                                        items="#{sap$SAPFrontpage.dropDownAccountTypeDefaultOptions.options}" style="left: 192px; top: 144px; position: absolute"/>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                        </webuijsf:tabSet>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
