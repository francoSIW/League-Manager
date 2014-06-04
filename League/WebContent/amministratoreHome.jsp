<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - PANNELLO AMMINISTRATORE</title>
</head>
<body>
	<f:view>
		<h:form>
			<c:choose>
				<c:when test="${amministratoreController.amministratore == null}">
					<h1>Bentornato
						${amministratoreController.amministratore.nome}!</h1>
					<h2>Pannello di controllo:</h2>
					<ul>

						<li><h:commandLink
								action="#{partitaController.generaPartite(squadraController.getAllSquadre())}"
								value="Chiudi iscrizioni e genera Calendario">
							</h:commandLink></li>
						<li><h:commandLink action="#{squadraController.listaSquadre}"
								value="Visualizza Classifica" /></li>
						<li><h:commandLink action="#{responsabileController.logout}"
								value="Logout" /></li>

					</ul>
				</c:when>
				<c:otherwise>
					<h2>Non hai le credenziali per accedere alla pagina!</h2>
				</c:otherwise>
			</c:choose>
		</h:form>
	</f:view>
</html>