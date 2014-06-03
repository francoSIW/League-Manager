package it.uniroma3.controller;

import it.uniroma3.model.GiocatoreFacade;
import it.uniroma3.model.PartitaFacade;
import it.uniroma3.model.Squadra;

import java.util.Date;
import java.util.List;

import it.uniroma3.model.Partita;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@ManagedBean
@SessionScoped
public class PartitaController {
	@ManagedProperty(value="#{param.id}")
	
	private Long id;
	private Date data;
	private String luogo;
	private String arbitro;
	private Partita partita ;
	private Integer puntiCasa;
	private Integer puntiOspiti;
	private Squadra squadraA;
	private Squadra squadraB;

	private List<Partita>partiteDisputate;
	private List<Partita>partiteDaDisputare;
	
	@EJB(beanName="pFacade")
	private PartitaFacade partitaFacade;
	

	
	public String listaPartite(){
		this.partiteDaDisputare = partitaFacade.getAllPartiteDaDisputare();
		this.partiteDisputate = partitaFacade.getAllPartiteDisputate();
		return "partite";
	}

	public String updatePartita() {
		this.partita = partitaFacade.updatePartita(this.partita, this.puntiCasa, this.puntiOspiti);
		return "partita";
	}
	public List<Partita> getPartiteDisputate() {
		return partiteDisputate;
	}

	public void setPartiteDisputate(List<Partita> partiteDisputate) {
		this.partiteDisputate = partiteDisputate;
	}

	public List<Partita> getPartiteDaDisputare() {
		return partiteDaDisputare;
	}

	public void setPartiteDaDisputare(List<Partita> partiteDaDisputare) {
		this.partiteDaDisputare = partiteDaDisputare;
	}

	public String generaPartite(List<Squadra> squadre) {
		partitaFacade.generaPartite(squadre);
		return "confermaCalendario";
	}
	
	public String findPartita(long id){
		this.partita = this.partitaFacade.getPartita(id);
		return "partita";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public String getArbitro() {
		return arbitro;
	}
	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}
	
	public Integer getPuntiCasa() {
		return puntiCasa;
	}
	
	public void setPuntiCasa(Integer puntiCasa) {
		this.puntiCasa = puntiCasa;
	}
	public Integer getPuntiOspiti() {
		return puntiOspiti;
	}
	public void setPuntiOspiti(Integer puntiOspiti) {
		this.puntiOspiti = puntiOspiti;
	}
	public Squadra getSquadraA() {
		return squadraA;
	}
	public void setSquadraA(Squadra squadraA) {
		this.squadraA = squadraA;
	}
	public Squadra getSquadraB() {
		return squadraB;
	}
	public void setSquadraB(Squadra squadraB) {
		this.squadraB = squadraB;
	}


	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	
}
