package it.uniroma3.controller;


import it.uniroma3.model.ResponsabileFacade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import it.uniroma3.model.ResponsabileSquadra;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ResponsabileController {
	@ManagedProperty(value="#{param.id}")

	private Long id;
	private String email;
	private String password;
	private String nome;
	private String cognome;

	private ResponsabileSquadra responsabile;
	private List<ResponsabileSquadra> responsabili;

	@EJB(beanName="rFacade")
	private ResponsabileFacade responsabileFacade;

	public String login(){
		this.responsabile = responsabileFacade.autentica(this.email, this.password);
		if(this.responsabile!=null) {
			return "logged";
		}
		else {

			return "errore";
		}
	}

	public String logout() {

		this.responsabile = null;

		return "logout";
	}




	public String registraResponsabile(){

		this.responsabile = responsabileFacade.createResponsabile(nome, cognome, email, password);

		return "registrato";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ResponsabileSquadra> getResponsabili() {
		return responsabili;
	}

	public void setResponsabili(List<ResponsabileSquadra> responsabili) {
		this.responsabili = responsabili;
	}

	public ResponsabileFacade getResponsabileFacade() {
		return responsabileFacade;
	}

	public void setResponsabileFacade(ResponsabileFacade responsabileFacade) {
		this.responsabileFacade = responsabileFacade;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ResponsabileSquadra getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(ResponsabileSquadra responsabile) {
		this.responsabile = responsabile;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}


