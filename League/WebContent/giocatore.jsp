<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>League Manager - scheda giocatore</title>
</head>
<body>
<h3>DETTAGLI GIOCATORE</h3>
<div>Nome: ${giocatoreController.giocatore.nome}</div>
<div>Cognome: ${giocatoreController.giocatore.cognome} 
</div>
<div>Eta': ${giocatoreController.giocatore.eta}
</div>
<div>Numero: ${giocatoreController.giocatore.numeroMaglia}
</div>
<div>Punti all'attivo: ${giocatoreController.giocatore.punti}
</div>
<div>Media-voto: ${giocatoreController.giocatore.mediaVoto}
</div>
<div>
</br><a href='<c:url value="/faces/squadra.jsp" />'>torna alla squadra</a></div>
</body>
</html>