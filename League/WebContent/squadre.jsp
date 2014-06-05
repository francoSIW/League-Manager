<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - CLASSIFICA</title>
</head>
<body style="background-color: #a8f7ff;">
	<f:view>
		<h1>Classifica:</h1>
		<h:form>
			<table>
				<tr>
					<th>Squadra</th>
					<th>G</th>
					<th>V</th>
					<th>N</th>
					<th>P</th>
					<th>GF</th>
					<th>GS</th>
					<th>DR</th>
					<th>Punti</th>
				</tr>
				<c:forEach var="squadra" items="#{squadraController.squadre}">
					<tr>
						<td><h:commandLink
								action="#{squadraController.findSquadra(squadra.id)}"
								value="#{squadra.nome}">
							</h:commandLink></td>
						<td align=center>${squadra.giocate}</td>
						<td align=center>${squadra.vinte}</td>
						<td align=center>${squadra.nulle}</td>
						<td align=center>${squadra.perse}</td>
						<td align=center>${squadra.fatti}</td>
						<td align=center>${squadra.subiti}</td>
						<td align=center>${squadra.diff}</td>
						<td align=center>${squadra.punti}</td>
					</tr>
				</c:forEach>
			</table>
			</br>
			<a href='<c:url value="/faces/index.jsp" />'>Torna alla Home</a>
		</h:form>

	</f:view>
</body>
</html>