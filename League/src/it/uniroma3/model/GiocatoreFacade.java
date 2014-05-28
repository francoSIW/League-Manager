package it.uniroma3.model;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;

@Stateless(name="gFacade")
public class GiocatoreFacade {

    @PersistenceContext(unitName = "league-unit")
    private EntityManager em;
    
	   public Giocatore createGiocatore(String nome, String cognome, Integer eta, Integer numeroMaglia, Squadra squadra) throws Exception {
		Giocatore giocatore = new Giocatore(nome, cognome, eta, numeroMaglia, squadra);

		      em.persist(giocatore);

		return giocatore;
	   }
		   
	   
	   
	   public Giocatore getGiocatore(Long id) {
	          Giocatore giocatore = em.find(Giocatore.class, id);
	          return giocatore;
	  }
	   
	   public Squadra getSquadra(Long id) {
	          Squadra squadra = em.find(Squadra.class, id);
	          return squadra;
	  }
}