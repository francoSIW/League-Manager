<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LEAGUE MANAGER - GENERA CALENDARIO</title>
</head>
<body>
	<h3>Inserisci la data di inizio del torneo:</h3>
	<f:view>
		<h:form id="login-form">
			<table>
			<tr>
			<th>giorno</th>
			<th>mese</th>
			<th>anno</th>
			<th></th>
			<th>ora</th>
			<th>minuti</th>
			<div>
			</tr>
			<tr>
			<td>
				<h:inputText value="#{partitaController.giorno}" required="true"
					requiredMessage="Questo campo è obbligatorio!" id="giorno"
					validatorMessage="Il giorno inserito non e' valido!">
						<f:validateLongRange minimum="1" maximum="31" />
					<h:message for="giorno" />
				</h:inputText>
				</td>
				<td>
				<h:inputText value="#{partitaController.mese}" required="true"
					requiredMessage="Questo campo è obbligatorio!" id="mese"
					validatorMessage="Il mese inserito non e' valido!">
						<f:validateLongRange minimum="1" maximum="12" />
					<h:message for="mese" />
				</h:inputText>
				</td>
				<td>
				<h:inputText value="#{partitaController.anno}" required="true"
					requiredMessage="Questo campo è obbligatorio!" id="anno"
					validatorMessage="L'anno inserito non e' valido!">
						<f:validateLongRange minimum="2014" />
					<h:message for="anno" />
				</h:inputText>
				</td>
				<td> si gioca alle </td>
				<td>
								<h:inputText value="#{partitaController.ora}" required="true"
					requiredMessage="Questo campo è obbligatorio!" id="ora"
					validatorMessage="L'ora inserito non e' valida!">
						<f:validateLongRange minimum="0" maximum="23" />
					<h:message for="anno" />
				</h:inputText>
				</td>
				<td>: <h:inputText value="#{partitaController.minuti}" required="true"
					requiredMessage="Questo campo è obbligatorio!" id="minuti"
					validatorMessage="I minuti inseriti non sono validi!">
						<f:validateLongRange minimum="0" maximum="59" />
					<h:message for="anno" />
				</h:inputText>
</td>
</tr>	
			</table>
			<div>

				<h:commandButton value="Genera Calendario"
					action="#{partitaController.generaPartite(squadraController.getAllSquadre())}" />

			</div>

			<br />

			<a href='<c:url value="/faces/amministratoreHome.jsp" />'>Torna
				al Pannello di Controllo</a>

		</h:form>
	</f:view>
</body>
</html>