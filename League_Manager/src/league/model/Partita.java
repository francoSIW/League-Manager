package league.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//dfgh
@Entity
public class Partita {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Date data;
	
	@Column
	private String luogo;
	
	@Column
	private int puntiCasa;
	
	@Column
	private int puntiOspiti;
	
	@ManyToOne
	private Squadra squadraA;
	
	@ManyToOne
	private Squadra squadraB;
	
	public Partita(){}

	public Partita(Long id, Date data, String luogo, int puntiCasa,
			int puntiOspiti, Squadra squadraA, Squadra squadraB) {
		this.id = id;
		this.data = data;
		this.luogo = luogo;
		this.puntiCasa = puntiCasa;
		this.puntiOspiti = puntiOspiti;
		this.squadraA = squadraA;
		this.squadraB = squadraB;
	}
	
	
	
	
}