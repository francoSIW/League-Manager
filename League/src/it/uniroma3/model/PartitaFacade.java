package it.uniroma3.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.time.DateUtils;


@Stateless(name="pFacade")
public class PartitaFacade {

	@PersistenceContext(unitName = "league-unit")
	private EntityManager em;

	public Partita getPartita(Long id) {
		Partita partita = em.find(Partita.class, id);
		return partita;
	}

	public List<Partita> getAllPartiteDaDisputare() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Partita> cq = criteriaBuilder.createQuery(Partita.class);
		Root<Partita> root = cq.from(Partita.class);
		cq.select(root);
		ParameterExpression<Boolean> params = criteriaBuilder.parameter(Boolean.class);
		cq.orderBy(criteriaBuilder.asc(root.get("data")));
		cq.where(criteriaBuilder.equal(root.get("disputata"), params));
		TypedQuery<Partita> query = em.createQuery(cq);
		query.setParameter(params, false);




		List<Partita> partite = query.getResultList();

		return partite;
	}

	public Partita updatePartita(Partita partita, Integer puntiCasa, Integer puntiOspiti){
		partita.setPuntiCasa(puntiCasa);
		partita.setPuntiOspiti(puntiOspiti);
		partita.setDisputata(true);
		if(puntiCasa > puntiOspiti)
			partita.getSquadraCasa().setPunti(partita.getSquadraCasa().getPunti() + 3);
		else if (puntiCasa < puntiOspiti)
			partita.getSquadraOspiti().setPunti(partita.getSquadraOspiti().getPunti() + 3);
		else {
			partita.getSquadraCasa().setPunti(partita.getSquadraCasa().getPunti() + 1);
			partita.getSquadraOspiti().setPunti(partita.getSquadraOspiti().getPunti() + 1);
		}

		em.merge(partita);
		return partita;
	}

	public List<Partita> getAllPartiteDisputate() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Partita> cq = criteriaBuilder.createQuery(Partita.class);
		Root<Partita> root = cq.from(Partita.class);
		cq.select(root);

		cq.orderBy(criteriaBuilder.asc(root.get("data")));
		cq.where(criteriaBuilder.equal(root.get("disputata"), true));

		TypedQuery<Partita> query = em.createQuery(cq);


		List<Partita> partite = query.getResultList();

		return partite;
	}


	public List<Partita> generaPartite(List<Squadra> squadre){
		/*Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 1999);
		date.set(Calendar.MONTH, 7);
		date.set(Calendar.DAY_OF_MONTH, 26);
		date.set(Calendar.HOUR, 21);
		date.set(Calendar.MINUTE, 00);
		 */


		Date date = new Date(114, 06, 02, 21, 00);
		Date incremento = new Date(0, 0, 15, 0, 0);

		for(Squadra s1 :  squadre) {
			Date tempDate = date;
			for(Squadra s2 :  squadre.subList(squadre.indexOf(s1), squadre.size())) {
				if(!s1.equals(s2))
				{
					createPartita( s1.getVia(), s1, s2, tempDate);
					createPartita( s2.getVia(), s2, s1, tempDate);
				Long sum = tempDate.getTime() + incremento.getTime();
				tempDate = new Date(sum);
				}
			}
		Long sum = date.getTime() + incremento.getTime();
		date = new Date(sum);
		}
		return getAllPartiteDaDisputare();      
	}



	public  void createPartita(String luogo, Squadra squadraA,	Squadra squadraB, Date data) {
		Partita partita = new Partita(luogo, squadraA , squadraB, data);
		em.persist(partita);

	}

}
