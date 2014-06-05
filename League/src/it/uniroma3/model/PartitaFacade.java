package it.uniroma3.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		partita.getSquadraCasa().setGiocate(partita.getSquadraCasa().getGiocate()+1);
		partita.getSquadraOspiti().setGiocate(partita.getSquadraOspiti().getGiocate()+1);

		if(puntiCasa > puntiOspiti) {
			//set punti
			partita.getSquadraCasa().setPunti(partita.getSquadraCasa().getPunti() + 3);
			//set partite
			partita.getSquadraCasa().setVinte(partita.getSquadraCasa().getVinte() + 1);
			partita.getSquadraOspiti().setPerse(partita.getSquadraOspiti().getPerse() + 1);

		}
		else if (puntiCasa < puntiOspiti) {
			//set punti
			partita.getSquadraOspiti().setPunti(partita.getSquadraOspiti().getPunti() + 3);
			//set partite
			partita.getSquadraOspiti().setVinte(partita.getSquadraOspiti().getVinte() + 1);
			partita.getSquadraCasa().setPerse(partita.getSquadraCasa().getPerse() + 1);

		}
		else {
			//set punti
			partita.getSquadraCasa().setPunti(partita.getSquadraCasa().getPunti() + 1);
			partita.getSquadraOspiti().setPunti(partita.getSquadraOspiti().getPunti() + 1);
			//set partite
			partita.getSquadraCasa().setNulle(partita.getSquadraCasa().getNulle() + 1);
			partita.getSquadraOspiti().setNulle(partita.getSquadraOspiti().getNulle() + 1);

		}

		//set gol
		partita.getSquadraCasa().setFatti(partita.getSquadraCasa().getFatti()+partita.getPuntiCasa());
		partita.getSquadraCasa().setSubiti(partita.getSquadraCasa().getSubiti()+partita.getPuntiOspiti());
		partita.getSquadraCasa().setDiff(partita.getSquadraCasa().getFatti() - partita.getSquadraCasa().getSubiti());
		partita.getSquadraOspiti().setFatti(partita.getSquadraOspiti().getFatti()+partita.getPuntiOspiti());
		partita.getSquadraOspiti().setSubiti(partita.getSquadraOspiti().getSubiti()+partita.getPuntiCasa());
		partita.getSquadraOspiti().setDiff(partita.getSquadraOspiti().getFatti() - partita.getSquadraOspiti().getSubiti());
		
		
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


	public List<Partita> generaPartite(List<Squadra> squadre, Date date){

		Date inizio = date;
		Date fineCampionato = DateUtils.addDays(date, 7*((squadre.size()-2)));


		for(Squadra s1 :  squadre) {
			boolean inCasa = true;
			for(Squadra s2 :  squadre.subList(squadre.indexOf(s1), squadre.size())) {

				if(!s1.equals(s2)) {

					while(!date.after(fineCampionato)) {
						Query trovaSquadraInPartita = em.createNamedQuery("trovaSquadraInPartita");
						trovaSquadraInPartita.setParameter("data", date);
						trovaSquadraInPartita.setParameter("squadraCasa", s1);
						trovaSquadraInPartita.setParameter("squadraOspiti", s2);
						Collection partita1 = trovaSquadraInPartita.getResultList();
						trovaSquadraInPartita.setParameter("squadraCasa", s2);
						trovaSquadraInPartita.setParameter("squadraOspiti", s1);
						Collection partita2 = trovaSquadraInPartita.getResultList();

						if(partita1.isEmpty() && partita2.isEmpty()) {

							if(inCasa) {
								createPartita( s1.getVia(), s1, s2, date);
								createPartita( s2.getVia(), s2, s1, DateUtils.addDays(date, 7*(squadre.size()-1)));
								inCasa = false;
								break;
							} else {
								createPartita( s2.getVia(), s2, s1, date);
								createPartita( s1.getVia(), s1, s2, DateUtils.addDays(date, 7*(squadre.size()-1)));
								inCasa = true;
								break;
							}
						}

						else
							date = DateUtils.addDays(date, 7);

					}
					date = inizio;

				}
			}
			date = inizio;
		}
		return getAllPartiteDaDisputare();      
	}


	public void svuotaCalendario() {
		em.createNamedQuery("deleteAllPartite").executeUpdate();
		
	}

	public boolean calendarioGiaGenerato() {
		Query trovaPartite = em.createNamedQuery("getAllPartite");
		return !trovaPartite.getResultList().isEmpty();

		
		
	}

	public  void createPartita(String luogo, Squadra squadraA,	Squadra squadraB, Date data) {
		Partita partita = new Partita(luogo, squadraA , squadraB, data);
		em.persist(partita);

	}

}
