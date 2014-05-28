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
	private int puntiCasa;
	private int puntiOspiti;
	private Squadra squadraA;
	private Squadra squadraB;

	private List<Partita>partite ;
	
	@EJB(beanName="pFacade")
	private PartitaFacade partitaFacade;
	

	public String listaPartite(){
		this.partite = partitaFacade.getAllPartite();
		return "partite";
	}
	
	public String generaPartite() {
		partitaFacade.generaPartite();
		return "partite";
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
	public int getPuntiCasa() {
		return puntiCasa;
	}
	public void setPuntiCasa(int puntiCasa) {
		this.puntiCasa = puntiCasa;
	}
	public int getPuntiOspiti() {
		return puntiOspiti;
	}
	public void setPuntiOspiti(int puntiOspiti) {
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
	public List<Partita> getPartite() {
		return partite;
	}
	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}
	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	
}
