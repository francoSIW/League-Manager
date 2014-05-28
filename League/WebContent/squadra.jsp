<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Squadra</title>
</head>
<body>
<f:view>
<h1>Nome: ${squadraController.squadra.nome}</h1>
<h2>Details</h2>
<div>Code: ${squadraController.squadra.coloriSociali}</div>
<div>Contatta il responsabile: 
<ul><li>${squadraController.squadra.responsabile.nome} ${squadraController.squadra.responsabile.cognome}</li>
<li>all'indirizzo: ${squadraController.squadra.responsabile.email}</li></ul>
</div>
	<div>
		<c:choose>
		<c:when test="${responsabileController.responsabile != null}">  
		<ul>
         <li> <a href='<c:url value="/faces/aggiungiGiocatore.jsp" />'>Aggiungi giocatori</a></li>
          <li><a href='<c:url value="/faces/responsabileHome.jsp" />'>Torna alla Home</a></li>
         </ul>
        </c:when>
       <c:otherwise>
       		<a href='<c:url value="/faces/index.jsp" />'>Torna all' indice</a>
       
       </c:otherwise>
	</c:choose>
	</div>
	<table>
	<tr>
		<th>Nome giocatore</th><th>Cognome</th><th>Numero maglia</th>
	</tr>
	<c:forEach var="giocatore" items="#{squadraController.giocatori}">
		<tr><td>${giocatore.nome}
		</td><td>${giocatore.cognome}</td><td>${giocatore.numeroMaglia}</td></tr>
	</c:forEach>
</table>
</f:view>
</body>
</html>