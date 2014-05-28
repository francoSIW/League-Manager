<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nuova Squadra</title>
</head>
<body>
<f:view>
<h:form>
    <div>Nome: <h:inputText value="#{squadraController.nomeSquadra}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
    <div>Colori: <h:inputText value="#{squadraController.colori}" 
                     required="true"
                     requiredMessage="Colors are mandatory"
                     id="code"/> <h:message for="code" />
	</div>
    
        <div>Via: <h:inputText value="#{squadraController.via}" 
                     required="true"
                     requiredMessage="Address is mandatory"
                     id="via"/> <h:message for="via" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{squadraController.createSquadra(responsabileController.responsabile)}"/>

	</div>
	<li><a href='index.html'>Torna alla Home</a></li>
</h:form>
</f:view>
</body>
</html>