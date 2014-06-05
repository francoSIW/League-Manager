package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



@Stateless(name="amministratoreFacade")

public class AmministratoreFacade {

	@PersistenceContext(unitName = "league-unit")
	private EntityManager em;

	
	public Amministratore autentica(String pin, String password){
		Amministratore amministratore = this.findAdminByPin(pin);
		if(amministratore==null)
			return null;
		else if(amministratore.getPassword().equals(password))
			return amministratore;
		else
			return null;
	}
	
	public Amministratore createAmministratore(String nome, String cognome, String pin,
			String password){

		Amministratore amministratore = new Amministratore(nome, cognome, pin, password);
		em.persist(amministratore);
		return amministratore;
	}
	//	  public boolean contain(Amministratore admin){
	//		  return this.predefiniti.containsKey(admin.getPin()) ;//&& getAllAmministratori
	//	  }
	public List<Amministratore> getAllAmministratori(){


		Query q=em.createNamedQuery("findAll");

		List<Amministratore> l =q.getResultList();
		return l;
	}

	public Amministratore findAdminByPin(String pin)  {
		Query trovaAmministratore = em.createNamedQuery("findAdminByPin");
		trovaAmministratore.setParameter("pin", pin);
		Amministratore amministratore;
		try {

		amministratore = (Amministratore)trovaAmministratore.getSingleResult();
		}
		catch (Exception e) {
			amministratore = null;
		}
		return amministratore;
	}

}
