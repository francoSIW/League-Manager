<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>LEAGUE MANAGER - AMMINISTRATORE CREATO!</title>
</head>
<body>
	<f:view>
		<div class="container">
			<p>L'Amministratore e' stato registrato con successo!</p>
			<a href='<c:url value="/faces/amministratoreHome.jsp" />'>Torna
				al Pannello di Controllo</a>
		</div>
	</f:view>
</body>
</html>