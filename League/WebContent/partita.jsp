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
			<h1>${partitaController.partita.squadraCasa.nome}
				${partitaController.partita.puntiCasa} -
				${partitaController.partita.puntiOspiti}
				${partitaController.partita.squadraOspiti.nome}</h1>
			<ul>
				<li><a href='<c:url value="/faces/updatePartita.jsp" />'>Aggiorna
						risultato</a></li>
				<li><h:commandLink action="#{partitaController.listaPartite}"
						value="Visualizza Partite">
					</h:commandLink></li>
			</ul>
		</h:form>
	</f:view>
</body>
</html>