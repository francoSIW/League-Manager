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
		//chiedere al professore
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
	
	public void resetAllSquadre() {
		for(Squadra squadra : this.getAllSquadre()) {
			squadra.setGiocate(0);
			squadra.setVinte(0);
			squadra.setNulle(0);
			squadra.setPerse(0);
			squadra.setFatti(0);
			squadra.setSubiti(0);
			squadra.setPunti(0);
			em.merge(squadra);
		}
	}

}