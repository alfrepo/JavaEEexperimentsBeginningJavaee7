<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>

    <h:outputLabel value="Application: "></h:outputLabel> 
    <h:outputLabel value="#{uUIDContainerApplicationScoped.uuid}"></h:outputLabel>
    <br>
    
    <h:outputLabel value="Session: "></h:outputLabel>
    <h:outputLabel value="#{uUIDContainerSessionScoped.uuid}"></h:outputLabel>
    <br>
    
    <h:outputLabel value="Request: "></h:outputLabel>
    <h:outputLabel value="#{uUIDContainerRequestScoped.uuid}"></h:outputLabel>
    <br>
    
    <h:outputLabel value="Conversation: "></h:outputLabel>
    <h:outputLabel value="#{scopesServiceConversation.uuid}"></h:outputLabel>
    <br>
    
    <h:outputLabel value="Conversation state: "></h:outputLabel>
    <h:outputLabel value="#{scopesServiceConversation.state}"></h:outputLabel>
    <br>
    <h:panelGroup rendered="#{scopesServiceConversation.conversationStarted==true}">
    	<h:outputLabel value="Add to url to stay within the conversation: ?cid="></h:outputLabel>
    	<h:outputLabel value="#{scopesServiceConversation.conversationCid}"></h:outputLabel>
    </h:panelGroup>
    <br>
    
  	<h:panelGroup rendered="#{scopesServiceConversation.conversationStarted==false}">
	    <h:form>
		    <h:commandButton action="#{scopesServiceConversation.startConversation}" value="Start Conversation"></h:commandButton>
		</h:form>
	</h:panelGroup>
	
	<h:panelGroup rendered="#{scopesServiceConversation.conversationStarted==true}">
	    <h:form>
		    <h:commandButton action="#{scopesServiceConversation.endConversation}" value="End Conversation"></h:commandButton>
		</h:form>
	</h:panelGroup>

</f:view>
</body>
</html>