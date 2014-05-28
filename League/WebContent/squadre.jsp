<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>League Manager - Classifica</title>
</head>
<body>
<f:view>
<h1>Classifica:</h1>
<h:form>
<table>
	<tr>
		<th>Nome</th><th>Punti</th>
	</tr>
	<c:forEach var="squadra" items="#{squadraController.squadre}">
		<tr><td>
		<h:commandLink action="#{squadraController.findSquadra}" value="#{squadra.nome}">
			<f:param name="id" value="#{squadra.id}" />
		</h:commandLink>
		</td><td>${squadra.punti}</td></tr>
	</c:forEach>
</table>
</h:form>

</f:view>
</body>
</html>