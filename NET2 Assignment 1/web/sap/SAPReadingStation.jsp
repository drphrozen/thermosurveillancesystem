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
                        <webuijsf:label id="label1" style="position: absolute; left: 24px; top: 24px" text="Reading Station"/>
                        <webuijsf:label id="label2" style="position: absolute; left: 24px; top: 48px" text="Name:"/>
                        <webuijsf:label id="label3" style="position: absolute; left: 24px; top: 72px" text="ID:"/>
                        <webuijsf:label binding="#{sap$SAPReadingStation.labelName}" id="labelName" style="position: absolute; left: 72px; top: 48px"/>
                        <webuijsf:label binding="#{sap$SAPReadingStation.labelID}" id="labelID" style="position: absolute; left: 72px; top: 72px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
