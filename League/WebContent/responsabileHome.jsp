<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<c:choose>
			<c:when test="${responsabileController.responsabile != null}">
				<h1>Ciao ${responsabileController.responsabile.nome}!</h1>
				<h2>Cosa vuoi fare?</h2>
				<ul>
					<h:form>
						<c:choose>
							<c:when
								test="${responsabileController.responsabile.squadra != null}">
								<h:commandLink
									action="#{giocatoreController.findGiocatoriSquadraResponsabile(responsabileController.responsabile)}"
									value="Gestisci la tua squadra">
								</h:commandLink>
							</c:when>
							<c:otherwise>
								<li><a href='<c:url value="/faces/newSquadra.jsp" />'>Crea
										una squadra!</a></li>
							</c:otherwise>
						</c:choose>
						<li><h:commandLink action="#{squadraController.listaSquadre}"
								value="Visualizza Classifica" /></li>
						<li><h:commandLink action="#{responsabileController.logout}"
								value="Logout" /></li>
					</h:form>
				</ul>
			</c:when>
			<c:otherwise>
				<h2>Non hai le credenziali per accedere alla pagina!</h2>
			</c:otherwise>
		</c:choose>
	</f:view>
</html>