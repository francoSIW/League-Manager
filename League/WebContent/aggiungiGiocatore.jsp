<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - AGGIUNGI GIOCATORE</title>
</head>
<body style="background-color:#a8f7ff;">
<f:view>
<h:form>
<c:choose>
<c:when test="${responsabileController.responsabile == null or responsabileController.responsabile.squadra == null }">
<h2>Non hai le credenziali per visualizzare questa pagina!</h2>
</c:when>
<c:otherwise>
<h2>Giocatori:</h2>



    <div>Nome: <h:inputText value="#{giocatoreController.nome}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
    <div>Cognome: <h:inputText value="#{giocatoreController.cognome}" 
                     required="true"
                     requiredMessage="Code is mandatory"
                     id="code"/> <h:message for="code" />
	</div>

	    <div>Eta': <h:inputText value="#{giocatoreController.eta}" 
                     required="true"
                     requiredMessage="Age is mandatory"
                     id="eta"/> <h:message for="eta" />
	</div>
    <div>Numero Maglia: <h:inputText value="#{giocatoreController.numeroMaglia}" 
                     required="true"
                     requiredMessage="Number is mandatory"
                     id="numero"/> <h:message for="numero" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{giocatoreController.createGiocatore(giocatoreController.squadra)}"/>
	</div>	
</c:otherwise>
</c:choose>
</h:form>
</f:view>
</body>
</html>