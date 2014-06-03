package it.uniroma3.model;



import java.io.PrintWriter;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless(name="sFacade")
public class SquadraFacade {

    @PersistenceContext(unitName = "league-unit")
    private EntityManager em;
    
	   public Squadra createSquadra(String nome, String colori, String via, ResponsabileSquadra responsabile) {
		Squadra squadra = new Squadra(nome, colori, via, responsabile);
		responsabile.setSquadra(squadra);
		em.merge(responsabile);

		return squadra;
	   }

	   public Squadra getSquadra(Long id) {
		   
	          Squadra squadra;
	        	  squadra = em.find(Squadra.class, id);
	          return squadra;
	  }
	   
		public List<Squadra> getAllSquadre() {
	        List<Squadra> squadre = em.createNamedQuery("trovaSquadre", Squadra.class).getResultList();
			return squadre;
			
		}


	   
}