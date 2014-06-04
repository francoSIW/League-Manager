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

@Stateless(name="rFacade")
public class ResponsabileFacade {

	@PersistenceContext(unitName = "league-unit")
	private EntityManager em;

	public ResponsabileSquadra createResponsabile(String nome, String cognome, String email, String password) {
		ResponsabileSquadra responsabile = new ResponsabileSquadra(nome, cognome, email, password);
		em.persist(responsabile);
		return responsabile;
	}

	public ResponsabileSquadra getResponsabile(String email)
	{
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<ResponsabileSquadra> criteriaQuery = criteriaBuilder.createQuery(ResponsabileSquadra.class);
		Root<ResponsabileSquadra> root = criteriaQuery.from(ResponsabileSquadra.class);
		criteriaQuery.select(root);

		ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("email"), params));

		TypedQuery<ResponsabileSquadra> query = em.createQuery(criteriaQuery);

		query.setParameter(params, email);

		List<ResponsabileSquadra> queryResult = query.getResultList();

		ResponsabileSquadra responsabile = null;

		if (!(queryResult.isEmpty()))
		{
			responsabile = queryResult.get(0);
		}
		return responsabile;
	}

	public ResponsabileSquadra autentica(String email, String password){
		ResponsabileSquadra responsabile = this.getResponsabile(email);
		if(responsabile==null)
			return null;
		else if(responsabile.getPassword().equals(password))
			return responsabile;
		else
			return null;
	}


}