<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - ERRORE!</title>
</head>
<body>
<div>Il numero di maglia selezionato e' gia' stato assegnato ad un altro giocatore!</div>
<div>
		<a href='<c:url value="/faces/aggiungiGiocatore.jsp" />'>Torna all'inserimento del giocatore</a>
		</div>
		<div>
		<a href='<c:url value="/faces/responsabileHome.jsp" />'>Torna alla Home</a>
		</div>

</body>
</html>