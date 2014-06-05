<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LEAGUE MANAGER - ACCEDI COME AMMINISTRATORE</title>
</head>
<body>
	<h3>Inserisci le tue credenziali di Amministratore:</h3>
	<f:view>
		<h:form id="login-form">

			<div>
				Pin: 
				<h:inputText value="#{amministratoreController.pin}" required="true"
					requiredMessage="Questo campo è obbligatorio!" id="pin" />
				<h:message for="pin" />
			</div>
			<div>
				Password: 
				<h:inputSecret value="#{amministratoreController.password}"
					required="true" requiredMessage="Questo campo è obbligatorio!"
					id="password">
				</h:inputSecret>
				<h:message for="password" />
			</div>
			<div>

				<h:commandButton value="login"
					action="#{amministratoreController.login}" />

			</div>

			<br />

			<a href='<c:url value="/faces/index.jsp" />'>Torna alla HomePage</a>

		</h:form>

	</f:view>
</body>
</html>