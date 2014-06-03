<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>LEAGUE MANAGER - GESTIONE SQUADRA</title>
</head>
<body style="background-color:#a8f7ff;">
<f:view>
<h:form>
<h1><font style="text-transform: uppercase;">${giocatoreController.squadra.nome}</font></h1>
<h3>LA TUA SQUADRA</h3>

	<table>
	<tr>
		<th>Giocatore</th><th>No. maglia</th><th>Azione</th>
	</tr>
	<c:forEach var="giocatore" items="#{giocatoreController.giocatori}">
		<tr><td>
		<h:commandLink action="#{giocatoreController.findGiocatore(giocatore.id)}" value="#{giocatore.nome} #{giocatore.cognome }">
		</h:commandLink>
		</td><td align = right>${giocatore.numeroMaglia}</td>
		<td><h:commandLink action="#{giocatoreController.deleteGiocatore(giocatore.id, giocatoreController.squadra)}" value="rimuovi">
		</h:commandLink>
		</td>
		</tr>
	</c:forEach>
</table>		 
		<ul>
         <li> <a href='<c:url value="/faces/aggiungiGiocatore.jsp" />'>Aggiungi un giocatore</a></li>
          <li><a href='<c:url value="/faces/index.jsp" />'>Torna alla Home</a></li>
         </ul>
</h:form>
</f:view>
</body>
</html>