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

@ManagedBean(name="AmministratoreController")
@SessionScoped
public class AmministratoreController implements Serializable {

	public AmministratoreController() {	}
	/**
	 * 
	 */
	@ManagedProperty(value="#{param.id}")

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cognome;
	private Integer pin;
	private String password;

	private Amministratore admin ;
	private List<Amministratore>admins ;
	
	private AmministratoreFacade adminFacade;
	private boolean loggedIn;

	@EJB(beanName="aFacade")
	
    private static final Integer predefinitoPin = 123456; //che fantasia
	private static final String predefinitaPass = "league";
	private static final Amministratore pre = new Amministratore("nomePredefinito", "cognomepredefinito",predefinitoPin,predefinitaPass);
	
	
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
	
	
    public String Login(Amministratore a) {

    	if (predefinitoPin == a.getPin() && (predefinitaPass.equals(a.getPassword()))){
    		 this.loggedIn = true;
    		return this.toWelcome();}
    	else
    	try{
    		boolean inDB = 	this.adminFacade.findAdminByPin(a.getPin()).getPassword().equals(a.getPassword());
    		if(inDB) {
    			this.loggedIn = true ;
    			return this.toWelcome();
    		}
    		else return this.toLogin() ;
    	}
    	catch(NoResultException e){
    		return this.toLogin() ;}
    	
    }
    
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        this.loggedIn = false;
         
         
        return this.toLogin();
    }

	public Amministratore getAdmin() {
		return admin;
	}
	public void setAdmin(Amministratore admin) {
		this.admin = admin;
	}
	public List<Amministratore> getAdmins() {
		return admins;
	}
	public void setAdmins(List<Amministratore> admins) {
		this.admins = admins;
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
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AmministratoreFacade getAdminFacade() {
		return adminFacade;
	}

	public void setAdminFacade(AmministratoreFacade adminFacade) {
		this.adminFacade = adminFacade;
	}

	public boolean isLoggedIn() {
		
		return this.loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	} 


}

