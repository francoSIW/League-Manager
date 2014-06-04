package it.uniroma3.controller;   
import java.util.List;
import java.util.Map;

import it.uniroma3.model.*;   

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SquadraController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nomeSquadra;
	private String colori;
	private String via;
	private Squadra squadra;
	private ResponsabileSquadra responsabile;
	private List<Squadra> squadre;
	private List<Giocatore> giocatori;



	@EJB(beanName="sFacade")
	private SquadraFacade squadraFacade;

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}


	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}


	public List<Squadra> getAllSquadre() {
		this.squadre = squadraFacade.getAllSquadre();
		return this.squadre;
	}




	public List<Squadra> getSquadre() {
		return squadre;
	}


	public SquadraFacade getSquadraFacade() {
		return squadraFacade;
	}


	public void setSquadraFacade(SquadraFacade squadraFacade) {
		this.squadraFacade = squadraFacade;
	}

	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public SquadraController() { }   


	public void setSquadre(List<Squadra> squadre) {
		this.squadre = squadre;
	}


	public String createSquadra(ResponsabileSquadra responsabile) { 
		this.responsabile = responsabile;
		this.squadra = squadraFacade.createSquadra(this.nomeSquadra, this.colori, this.via, responsabile);
		return "squadraIscritta"; 
	}


	public String listaSquadre() {
		this.squadre = squadraFacade.getAllSquadre();
		return "squadre"; 
	}

	public String findSquadra(Long id) {
		this.squadra = squadraFacade.getSquadra(id);
		this.giocatori = this.squadra.getGiocatori();	
		return "squadra";
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeSquadra() {
		return nomeSquadra;
	}


	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}


	public String getColori() {
		return colori;
	}


	public void setColori(String colori) {
		this.colori = colori;
	}


	public Squadra getSquadra() {
		return squadra;
	}


	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}


	public ResponsabileSquadra getResponsabile() {
		return responsabile;
	}


	public void setResponsabile(ResponsabileSquadra responsabile) {
		this.responsabile = responsabile;
	}




}