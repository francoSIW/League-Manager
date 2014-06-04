<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER</title>
</head>
<body style="background-color: #a8f7ff;">
	<f:view>
		<h1>----LEAGUE MANAGER-----</h1>
		<div>


			<h3>Benvenuto! Accedi alla tua area personale:</h3>

			<ul>

				<li><h:form>
						<div>
							e-mail:
							<h:inputText value="#{responsabileController.email}"
								required="true" requiredMessage="Questo campo è obbligatorio!" id="email" />
							<h:message for="email" />
						</div>
						<div>
							password:
							<h:inputSecret value="#{responsabileController.password}"
								required="true" requiredMessage="Questo campo è obbligatorio!"
								validatorMessage="La password deve avere dai 6 ai 10 caratteri."
								id="password">
								<f:validateLength minimum="6" maximum="10" />
							</h:inputSecret>
							<h:message for="password" />
						</div>
						<div>

							<h:commandButton value="login"
								action="#{responsabileController.login}" />

						</div>
						<h5>
							Non sei registrato e vuoi iscrivere una squadra? Clicca <a
								href='<c:url value="/faces/registrazione.jsp" />'>qui!</a>
						</h5>

					</h:form></li>
			</ul>

			<ul>
				<li><h:form>
						<h:commandLink action="#{squadraController.listaSquadre}"
							value="Visualizza la classifica" />
					</h:form></li>
				<li><h:form>
						<h:commandLink action="#{partitaController.listaPartite}"
							value="Visualizza Partite" />
					</h:form></li>
			</ul>
		</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			
			<a href='<c:url value="/faces/loginAmministratore.jsp" />'>Accedi come Amministratore</a>

	</f:view>
</body>
</html>

