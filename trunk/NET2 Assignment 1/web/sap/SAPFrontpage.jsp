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
                        <webuijsf:label id="labelWelcome" style="left: 24px; top: 48px; position: absolute" text="Welcome, "/>
                        <webuijsf:label binding="#{sap$SAPFrontpage.labelUsername}" id="labelUsername" style="left: 96px; top: 48px; position: absolute"/>
                        <webuijsf:listbox binding="#{sap$SAPFrontpage.listboxReadingStations}" id="listboxReadingStations"
                            items="#{sap$SAPFrontpage.listboxReadingStationsDefaultOptions.options}" style="left: 24px; top: 72px; position: absolute"/>
                        <webuijsf:button actionExpression="#{sap$SAPFrontpage.buttonEdit_action}" id="buttonEdit"
                            style="left: 23px; top: 288px; position: absolute" text="Edit"/>
                        <div style="left: 24px; top: 0px; position: absolute">
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
