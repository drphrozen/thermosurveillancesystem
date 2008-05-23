<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : 13-05-2008, 17:46:32
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
                        <webuijsf:passwordField binding="#{Login.passwordFieldLogin}" id="passwordFieldLogin" label="Password:"
                            style="left: 25px; top: 48px; position: absolute" tabIndex="2"/>
                        <webuijsf:textField binding="#{Login.textFieldUsername}" id="textFieldUsername" label="Username:"
                            style="left: 24px; top: 24px; position: absolute" tabIndex="1"/>
                        <webuijsf:button actionExpression="#{Login.button1_action}" id="button1" style="left: 23px; top: 96px; position: absolute" tabIndex="3" text="Login"/>
                        <webuijsf:label id="label1" style="position: absolute; left: 24px; top: 144px" text="Result:"/>
                        <webuijsf:label binding="#{Login.labelResult}" id="labelResult" style="position: absolute; left: 72px; top: 144px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
