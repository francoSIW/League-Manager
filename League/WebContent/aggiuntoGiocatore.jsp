<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Giocatore aggiunto!</title>
</head>
<body>
<f:view>
<h:form>
	<div>
	<a href='<c:url value="/faces/aggiungiGiocatore.jsp" />'>Aggiungi un altro giocatore:</a>
</div>
		<div>
					<a href='<c:url value="/faces/responsabileHome.jsp" />'>Torna alla Home</a>
	</div>
</h:form>
</f:view>
</body>
</html>