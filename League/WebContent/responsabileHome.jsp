<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h1>ciao ${responsabileController.responsabile.nome}!</h1>
		
			 <jsp:useBean id="emp" class="it.uniroma3.controller.SquadraController" scope="session" />
        
    <jsp:setProperty name="emp" property="responsabile" value="#{responsabileController.responsabile}"/>
		
		<ul>
			<li><a href='<c:url value="/faces/newSquadra.jsp" />'>Iscrivi una squadra!</a></li>
			<li><h:form>
					<h:commandLink action="#{squadraController.listaSquadre}"
						value="Elenco squadre" />
				</h:form></li>
							<li><h:form>
					<h:commandLink action="#{partitaController.generaPartite}"
						value="Genera Calendario" />
				</h:form>
				</li>
				</ul>
				</f:view>
</html>