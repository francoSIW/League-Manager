<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				</tr>
				<c:forEach var="partitaDisputata" items="#{partitaController.partiteDisputate}">
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
						</h:commandLink>
					</td>
					</tr>
				</c:forEach>
			</table>
			
			<h1>Partite da disputare:</h1>
			<table>
				<tr>
					<th>Squadra casa</th>
					<th>Risultato</th>
					<th>Squadra Fuori-casa</th>
				</tr>
				<c:forEach var="partita" items="#{partitaController.partiteDaDisputare}">
					<tr>
						<td><h:commandLink
								action="#{squadraController.findSquadra(partita.squadraCasa.id)}"
								value="#{partita.squadraCasa.nome}">
							</h:commandLink></td>
						<td><h:commandLink
							action="#{partitaController.findPartita(partita.id)}"
							value="#{partita.puntiCasa} - #{partita.puntiOspiti}">
						</h:commandLink></td>
						<td><h:commandLink
							action="#{squadraController.findSquadra(partita.squadraOspiti.id)}"
							value="#{partita.squadraOspiti.nome}">
						</h:commandLink>
					</td>
					</tr>
				</c:forEach>
			</table>
		</h:form>

	</f:view>
</body>
</html>