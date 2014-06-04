<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>LEAGUE MANAGER - CALENDARIO</title>
</head>
<body style="background-color: #a8f7ff;">
	<f:view>


		<h1>Partite</h1>

		<h:form>

			<h1>Partite disputate:</h1>
			<table>
				<tr>
					<th>Squadra casa</th>
					<th>Risultato</th>
					<th>Squadra Fuori-casa</th>
					<th>Data</th>
				</tr>
				<c:forEach var="partitaDisputata"
					items="#{partitaController.partiteDisputate}">
					<tr>
						<td><h:commandLink
								action="#{squadraController.findSquadra(partitaDisputata.squadraCasa.id)}"
								value="#{partitaDisputata.squadraCasa.nome}">
							</h:commandLink></td>
						<td><h:commandLink
								action="#{partitaController.findPartita(partitaDisputata.id)}"
								value="#{partitaDisputata.puntiCasa} - #{partitaDisputata.puntiOspiti}">
							</h:commandLink></td>
						<td><h:commandLink
								action="#{squadraController.findSquadra(partitaDisputata.squadraOspiti.id)}"
								value="#{partitaDisputata.squadraOspiti.nome}">
							</h:commandLink></td>
						<td>
						
						<h:outputText value="#{partitaDisputata.data}">
      <f:convertDateTime pattern="dd-MM-yyyy 'h' HH:mm" locale="it" type="both" />
</h:outputText></td>
					</tr>
					<tr></tr>
				</c:forEach>
			</table>

			<h1>Partite da disputare:</h1>
			<table>
				<tr>
					<th>Squadra casa</th>
					<th>Risultato</th>
					<th>Squadra Fuori-casa</th>
					<th>Data</th>
				</tr>
				<c:forEach var="partitaDaDisputare"
					items="#{partitaController.partiteDaDisputare}">
					<tr>
						<td><h:commandLink
								action="#{squadraController.findSquadra(partitaDaDisputare.squadraCasa.id)}"
								value="#{partitaDaDisputare.squadraCasa.nome}">
							</h:commandLink></td>
						<td><h:commandLink
								action="#{partitaController.findPartita(partitaDaDisputare.id)}"
								value="#{partitaDaDisputare.puntiCasa} - #{partitaDaDisputare.puntiOspiti}">
							</h:commandLink></td>
						<td><h:commandLink
								action="#{squadraController.findSquadra(partitaDaDisputare.squadraOspiti.id)}"
								value="#{partitaDaDisputare.squadraOspiti.nome}">
							</h:commandLink></td>
						<td>

						<h:outputText value="#{partitaDaDisputare.data}">
      <f:convertDateTime pattern="dd-MM-yyyy 'h' HH:mm" locale="it" type="both" />
</h:outputText>
</td>
					</tr>
					<tr></tr>
				</c:forEach>
			</table>
			</br>
			<a href='<c:url value="/faces/index.jsp" />'>Torna alla Home</a>
		</h:form>

	</f:view>
</body>
</html>