<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - CALENDARIO CREATO!</title>
</head>
<body style="background-color: #a8f7ff;">
	<f:view>
		<h1>Calendario creato con successo!</h1>
		<ul>
			<li><h:form>
					<h:commandLink action="#{partitaController.listaPartite}"
						value="Visualizza Partite" />
				</h:form></li>
			<li><a href='<c:url value="/faces/amministratoreHome.jsp" />'>Torna
					al Pannello di Controllo</a></li>
		</ul>
	</f:view>
</body>
</html>
