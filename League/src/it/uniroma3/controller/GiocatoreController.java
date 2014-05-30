package it.uniroma3.controller;   
import java.util.List;
import java.util.Map;

import it.uniroma3.model.*;   

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

@ManagedBean
@SessionScoped
public class GiocatoreController {


	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	private Integer numeroMaglia;
	private Giocatore giocatore;
	private Squadra squadra;
	private String test;
	
	


	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}


	private List<Giocatore> giocatori;

	@EJB(beanName="gFacade")
	private GiocatoreFacade giocatoreFacade;
	


	
	public String createGiocatore(Squadra squadra) { 
		try{
		this.giocatore = giocatoreFacade.createGiocatore(this.nome, this.cognome, this.eta, this.numeroMaglia, squadra);
		squadra.getGiocatori().add(this.giocatore);
		return "giocatore"; 
		}
		catch(Exception e){
			return "magliaInUso";
		}
		}
	
	public String findGiocatore(Long id) {
		//FacesContext fc = FacesContext.getCurrentInstance();
		//if(getIdParam(fc) == null) 
			//return "erroreMaglia";
		//this.id = Long.valueOf(getIdParam(fc)).longValue();
		this.giocatore = giocatoreFacade.getGiocatore(id);
		return "giocatore";
		
	}
	
	//get value from "f:param"
	/*	public String getIdParam(FacesContext fc){
	 
			Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
			return params.get("id");
		}
		*/
		
	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}



	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public Integer getEta() {
		return eta;
	}


	public void setEta(Integer eta) {
		this.eta = eta;
	}


	public Integer getNumeroMaglia() {
		return numeroMaglia;
	}


	public void setNumeroMaglia(Integer numeroMaglia) {
		this.numeroMaglia = numeroMaglia;
	}


	public Giocatore getGiocatore() {
		return giocatore;
	}


	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}


	public GiocatoreFacade getGiocatoreFacade() {
		return giocatoreFacade;
	}


	public void setGiocatoreFacade(GiocatoreFacade giocatoreFacade) {
		this.giocatoreFacade = giocatoreFacade;
	}


	

	

}
