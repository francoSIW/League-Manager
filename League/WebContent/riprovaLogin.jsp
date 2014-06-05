<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - OPS!</title>
</head>
<body style="background-color: #a8f7ff;">
	<h1>Qualcosa e' andato storto..</h1>
	<f:view>
		<h:form>
			<div>
				Reinserisci l'e-mail:
				<h:inputText value="#{responsabileController.email}" required="true"
					requiredMessage="Questo campo e' obbligatorio!" id="email" />
				<h:message for="email" />
			</div>

			<div>
				Reinserisci la password:
				<h:inputSecret value="#{responsabileController.password}"
					required="true" requiredMessage="Questo campo e' obbligatorio!"
					validatorMessage="La password deve contenere almeno 8 caratteri."
					id="password">
					<f:validateLength minimum="6" maximum="10" />
				</h:inputSecret>
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="login"
					action="#{responsabileController.login}" />

				<a href='<c:url value="/faces/index.jsp" />'>Torna alla HomePage</a>

			</div>
		</h:form>
	</f:view>
</body>
</html>