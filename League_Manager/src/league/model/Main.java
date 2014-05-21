package league.model;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//XGVHJBKNLM
public class Main {
	
	public static void main(String[] args){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("league-unit");
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction tx = em.getTransaction();	
	Squadra gianni = new Squadra("nome","girio");
	tx.begin();
	em.persist(gianni);
	
	tx.commit();
	em.close();
	emf.close();
	}
	
	
}
