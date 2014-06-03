<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>LEAGUE MANAGER- SQUADRA ISCRITTA!</title>
</head>
<body style="background-color:#a8f7ff;">
<f:view>
<h3>hai appena iscritto la squadra: </h3>
<h1>Nome: ${squadraController.squadra.nome}</h1>
<h2>Details</h2>
<div>Colori sociali: ${squadraController.squadra.coloriSociali}</div>
	<div>
		<a href='<c:url value="/faces/aggiungiGiocatore.jsp" />'>Aggiungi giocatori</a>
		<a href='<c:url value="/faces/responsabileHome.jsp" />'>Torna alla Home</a>
	</div>
</f:view>
</body>
</html>
