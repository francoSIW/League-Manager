package it.uniroma3.controller;

import it.uniroma3.model.Amministratore;
import it.uniroma3.model.AmministratoreFacade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;

@ManagedBean
@SessionScoped
public class AmministratoreController {

	private static String predefinitoPin = "admin";
	private static String predefinitaPass = "admin";

	@ManagedProperty(value="#{param.id}")

	private Long id;
	private String nome;
	private String cognome;
	private String pin;
	private String password;
	private Amministratore amministratore;
	private List<Amministratore> amministratori;


	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}
	@EJB(beanName="amministratoreFacade")
	private AmministratoreFacade amministratoreFacade;



	public String redirectToLogin() {
		return "/loginAmministratore.jsp?faces-redirect=true";
	}

	public String toLogin() {
		return "/loginAmministratore.jsp";
	}

	public String redirectToWelcome() {
		return "/paginefiltrate/welcome.jsp?faces-redirect=true";
	}


	public String toWelcome() {
		return "/paginefiltrate/welcome.jsp";
	}


	public String login() {
		this.amministratore = amministratoreFacade.findAdminByPin(this.pin);

		if (predefinitoPin.equals(this.pin)) {

			if (this.amministratore != null) {

				if(this.password.equals(this.amministratore.getPassword()))
					return "amministratoreHome";
				else
					return "riprovaLoginAdmin";
			}

			else {

				if(this.password.equals(predefinitaPass)) {
					this.amministratoreFacade.createAmministratore("nomeDefault", "cognomeDefault", this.pin, this.password);
					return "amministratoreHome";
				}
				else 
					return "riprovaLoginAdmin";
			}
		}


		else { 

			if(this.amministratore != null) {
				if(this.password.equals(this.amministratore.getPassword()))
					return "amministratoreHome";
				else
					return "riprovaLoginAdmin";

			}
			else {
				return "riprovaLoginAdmin";
			}
		}

	}
	
	public String registraAmministratore() {
		
		amministratoreFacade.createAmministratore(this.nome, this.cognome, this.pin, this.password);
		return "amministratoreCreato";
		
	}
	
	public String logout() {
		this.amministratore = null;
		return "logout";
	}
	

	public List<Amministratore> getAmministratori() {
		return amministratori;
	}
	public void setAmministratori(List<Amministratore> amministratori) {
		this.amministratori = amministratori;
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
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public AmministratoreFacade getAmministratoreFacade() {
		return amministratoreFacade;
	}

	public void setAmministratoreFacade(AmministratoreFacade amministratoreFacade) {
		this.amministratoreFacade = amministratoreFacade;
	}



}
