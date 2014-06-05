<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - REGISTRAZIONE</title>
</head>
<body style="background-color: #a8f7ff;">
	<hgroup>
		<h1>BENVENUTO IN LEAGUE MANAGER</h1>
		<h2>inserisci i tuoi dati</h2>
	</hgroup>
	<f:view>
		<h:form>
			<div>
				Nome:
				<h:inputText value="#{responsabileController.nome}" required="true"
					requiredMessage="Questo campo e' obbligatorio!" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Cognome:
				<h:inputText value="#{responsabileController.cognome}"
					required="true" requiredMessage="Questo campo e' obbligatorio!" id="code" />
				<h:message for="code" />
			</div>

			<div>
				e-mail:
				<h:inputText value="#{responsabileController.email}" required="true"
					requiredMessage="Questo campo e' obbligatorio!" id="email" />
				<h:message for="email" />
			</div>
			<div>
				password:
				<h:inputSecret value="#{responsabileController.password}"
					required="true" requiredMessage="Questo campo e' obbligatorio!"
					validatorMessage="La password deve contenere almeno 8 caratteri."
					id="password">
					<f:validateLength minimum="8" />
				</h:inputSecret>
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="Registrati"
					action="#{responsabileController.registraResponsabile}" />

			</div>
			<li><a href='index.html'>Torna alla Home</a></li>
		</h:form>
	</f:view>
</body>
</html>