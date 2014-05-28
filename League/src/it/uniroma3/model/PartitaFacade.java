package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


	@Stateless(name="pFacade")
	public class PartitaFacade {
		
		@PersistenceContext(unitName = "league-unit")
		private EntityManager em;

		public Partita getPartita(Long id) {
			Partita partita = em.find(Partita.class, id);
			return partita;
		}
		
		public List<Partita> getAllPartite() {
			CriteriaQuery<Partita> cq = em.getCriteriaBuilder().createQuery(Partita.class);
			cq.select(cq.from(Partita.class));
			List<Partita> partite = em.createQuery(cq).getResultList();
			return partite;
		}
		 
		
		public List<Partita> generaPartite(){
			     SquadraFacade sf = new SquadraFacade();
			     List<Squadra> squadre = sf.getAllSquadre();
			    for(Squadra s1 :  squadre)
			     for(Squadra s2 :  squadre)
			      if(!s1.equals(s2))
			      {createPartita( s1.getVia(), s1, s2);}
			   return getAllPartite();      
		}
			 
			
			
	
	public  void createPartita(String luogo, Squadra squadraA,	Squadra squadraB) {
			Partita partita = new Partita(luogo, squadraA , squadraB);
			em.persist(partita);
			
		}

}
