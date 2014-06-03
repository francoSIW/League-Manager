package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



@Stateless(name="gFacade")

public class AmministratoreFacade {

	  @PersistenceContext(unitName = "league-unit")
	    private EntityManager em;
	
	  public Amministratore createAmministratore(String nome, String cognome, Integer pin,
				String password){
		  
		  Amministratore a = new Amministratore(nome, cognome, pin, password);
		  em.persist(a);
		  return a ;
	  }
//	  public boolean contain(Amministratore admin){
//		  return this.predefiniti.containsKey(admin.getPin()) ;//&& getAllAmministratori
//	  }
	  public List<Amministratore> getAllAmministratori(){

	
			  Query q=em.createNamedQuery("findAll");
			  
			  List<Amministratore> l =q.getResultList();
			  return l;
	  }
	  
	  public Amministratore findAdminByPin(Integer pin) throws NoResultException{
		  TypedQuery<Amministratore> q = em.createNamedQuery("findAdminByPin",Amministratore.class);
		  q.setParameter("pin",pin);
		 return q.getSingleResult();
		  
	  }

}
