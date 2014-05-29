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

		<!-- Se l'utente �� loggato come responsabile di una squadra mostra questo... -->

		<div>
			<c:choose>
				<c:when test="${responsabileController.responsabile != null}">
					<h1>Ciao ${responsabileController.responsabile.nome}!</h1>
					<h2>Cosa vuoi fare?</h2>
					<ul>
						<h:form>
				<c:choose>
				<c:when test="${responsabileController.responsabile.squadra != null}">
							<h:commandLink action="#{squadraController.findSquadra}"
								value="Vai alla tua squadra">
								<f:param name="id"
									value="#{responsabileController.responsabile.squadra.id}" />
							</h:commandLink>
							</c:when>
											<c:otherwise>
											<li><a
										href='<c:url value="/faces/newSquadra.jsp" />'>Crea una squadra!</a></li>
										</c:otherwise>
											
										</c:choose>										
							<li><h:commandLink
									action="#{squadraController.listaSquadre}"
									value="Visualizza Classifica" /></li>
																<li><h:commandLink
									action="#{responsabileController.logout}"
									value="Logout" /></li>
						</h:form>
					</ul>
				</c:when>


				<c:otherwise>
					<!-- altrimenti mostra questo (utente non registrato) -->


					<h3>Benvenuto! Accedi alla tua area personale:</h3>

					<ul>

						<li><h:form>
								<div>
									e-mail:
									<h:inputText value="#{responsabileController.email}"
										required="true" requiredMessage="email is mandatory"
										id="email" />
									<h:message for="email" />
								</div>
								<div>
									password:
									<h:inputSecret value="#{responsabileController.password}"
										required="true" requiredMessage="password is mandatory"
										validatorMessage="password: min 6 max 10 characters"
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


					<li><h:form>
							<h:commandLink action="#{squadraController.listaSquadre}"
								value="Visualizza la classifica" />
						</h:form></li>
				</c:otherwise>
			</c:choose>
		</div>

	</f:view>
</body>
</html>

