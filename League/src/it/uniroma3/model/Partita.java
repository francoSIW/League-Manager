package it.uniroma3.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//dfgh
@Entity

public class Partita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Date data;

	@Column
	private String luogo;
	
	@Column
	private int puntiCasa;

	@Column
	private int puntiOspiti;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Squadra squadraA;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Squadra squadraB;

	public Partita(){}

	public Partita(String luogo, Squadra s1, Squadra s2) {
		this.luogo = luogo;
		this.squadraA = s1;
		this.squadraB = s2;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public int getPuntiCasa() {
		return puntiCasa;
	}

	public void setPuntiCasa(int puntiCasa) {
		this.puntiCasa = puntiCasa;
	}

	public int getPuntiOspiti() {
		return puntiOspiti;
	}

	public void setPuntiOspiti(int puntiOspiti) {
		this.puntiOspiti = puntiOspiti;
	}

	public Squadra getSquadraA() {
		return squadraA;
	}

	public void setSquadraA(Squadra squadraA) {
		this.squadraA = squadraA;
	}

	public Squadra getSquadraB() {
		return squadraB;
	}

	public void setSquadraB(Squadra squadraB) {
		this.squadraB = squadraB;
	}



}