<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TUTTE LE PARTITE DEL TORNEO</title>
</head>
<body style="background-color:#a8f7ff;">
	<h:form>
		<table>
			<tr>
				<th>luogo</th>
				<th>SquadraA</th>
				<th>SquadraB</th>
				<th>PuntiA</th>
				<th>PuntiB</th>
			</tr>
			
			<c:forEach var="partita" items="#{partitaController.partite}">
				<tr>
					<td><h:commandLink action="#{partitaController.findPartita}"
							value="#{Partita.luogo}">
							<f:param name="id" value="#{partita.id}" />
						</h:commandLink></td>
						
					<td><h:commandLink action="#{partitaController.findPartita}"
							value="#{Partita.squadraA}">
							<f:param name="id" value="#{partita.id}" />
						</h:commandLink></td>
					 
					<td><h:commandLink action="#{partitaController.findPartita}"
							value="#{Partita.squadraB}">
							<f:param name="id" value="#{partita.id}" />
						</h:commandLink></td>
						
					<td></td>
					<td></td>
					
				</tr>
			</c:forEach>
		</table>
	</h:form>
</body>
</html>