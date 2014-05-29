<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>LEAGUE MANAGER - RIEPILOGO SQUADRA</title>
</head>
<body style="background-color:#a8f7ff;">
<f:view>
<h1><font style="text-transform: uppercase;">${squadraController.squadra.nome}</font></h1>
<h3>DETTAGLI SQUADRA</h3>
<div>Colori: ${squadraController.squadra.coloriSociali}</div>

	<div> 
	<div>Responsabile: ${squadraController.squadra.responsabile.nome} ${squadraController.squadra.responsabile.cognome}
</div>
<div>Contatto mail responsabile: ${squadraController.squadra.responsabile.email}
</div>

	</div>
	<h3>ELENCO GIOCATORI</h3>
	<table>
	<tr>
		<th>Nome</th><th>Cognome</th><th>No. maglia</th>
	</tr>
	<c:forEach var="giocatore" items="#{squadraController.giocatori}">
		<tr><td>${giocatore.nome}
		</td><td>${giocatore.cognome}</td><td>${giocatore.numeroMaglia}</td></tr>
	</c:forEach>
</table>

		<c:choose>
		<c:when test="${responsabileController.responsabile != null}">  
				<ul>
         <li> <a href='<c:url value="/faces/aggiungiGiocatore.jsp" />'>Aggiungi giocatori</a></li>
          <li><a href='<c:url value="/faces/index.jsp" />'>Torna alla Home</a></li>
         </ul>
        </c:when>
       <c:otherwise>
       </br>
       		<a href='<c:url value="/faces/index.jsp" />'>Torna all' indice</a>
       
       </c:otherwise>
	</c:choose>
		


</f:view>
</body>
</html>