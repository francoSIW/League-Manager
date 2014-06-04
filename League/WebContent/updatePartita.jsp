<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				${partitaController.partita.squadraCasa.nome}:
				<h:inputText value="#{partitaController.puntiCasa}" required="true"
					requiredMessage="Questo campo e' obbligatorio!" id="puntiCasa" />
				<h:message for="puntiCasa" />
			</div>
			<div>
				${partitaController.partita.squadraOspiti.nome}:
				<h:inputText value="#{partitaController.puntiOspiti}"
					required="true" requiredMessage="Questo campo e' obbligatorio!"
					id="puntiOspiti" />
				<h:message for="puntiOspiti" />
			</div>

			<div>
				<h:commandButton value="aggiorna"
					action="#{partitaController.updatePartita}" />

			</div>
			<a href='<c:url value="/faces/amministratoreHome.jsp" />'>Torna
				alla Home</a>
		</h:form>
	</f:view>
</body>
</html>