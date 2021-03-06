package it.uniroma3.model;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
//commento
@Entity
@NamedQueries({
@NamedQuery(name = "trovaSquadraInPartita", query = "SELECT p FROM Partita p WHERE p.data = :data AND (p.squadraCasa = :squadraCasa OR p.squadraOspiti = :squadraOspiti)"),
@NamedQuery(name = "deleteAllPartite", query = "DELETE FROM Partita p"),
@NamedQuery(name = "getAllPartite", query = "SELECT p FROM Partita p")
})
public class Partita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal (TemporalType.TIMESTAMP)
	private Date data;

	@Column
	private String luogo;

	@Column
	private Integer puntiCasa;

	@Column
	private Integer puntiOspiti;

	@Column
	private Boolean disputata;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Squadra squadraCasa;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Squadra squadraOspiti;

	public Partita(){}

	public Partita(String luogo, Squadra s1, Squadra s2, Date data) {
		this.luogo = luogo;
		this.disputata = false;
		this.squadraCasa = s1;
		this.squadraOspiti = s2;
		this.data = data;
		this.puntiCasa = 0;
		this.puntiOspiti = 0;

	}

	public boolean isDisputata() {
		return disputata;
	}

	public void setDisputata(boolean disputata) {
		this.disputata = disputata;
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

	public Integer getPuntiCasa() {
		return puntiCasa;
	}

	public void setPuntiCasa(Integer puntiCasa) {
		this.puntiCasa = puntiCasa;
	}

	public Integer getPuntiOspiti() {
		return puntiOspiti;
	}

	public void setPuntiOspiti(Integer puntiOspiti) {
		this.puntiOspiti = puntiOspiti;
	}

	public Squadra getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(Squadra squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public Squadra getSquadraOspiti() {
		return squadraOspiti;
	}

	public void setSquadraOspiti(Squadra squadraOspiti) {
		this.squadraOspiti = squadraOspiti;
	}



}