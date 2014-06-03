package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="giocatori", uniqueConstraints= @UniqueConstraint(columnNames={"squadra_id", "numeroMaglia"}))

public class Giocatore {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="giocatore_id")
    private Long id;

	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;

	@Column(nullable=false)
	private Integer eta;

	@Column
	private Integer punti;

	@Column
	private Float mediaVoto;


	@Column(name = "numeroMaglia", nullable=false)
	private Integer numeroMaglia;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="squadra_id")
	private Squadra squadra;

	public Giocatore(){}

	public Giocatore(String nome, String cognome, Integer eta, Integer numeroMaglia, Squadra squadra) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.numeroMaglia = numeroMaglia;
		this.mediaVoto = (float)0;
		this.punti = 0;
		this.squadra = squadra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}


	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Integer getPunti() {
		return punti;
	}

	public void setPunti(Integer punti) {
		this.punti = punti;
	}

	public Float getMediaVoto() {
		return mediaVoto;
	}

	public void setMediaVoto(Float mediaVoto) {
		this.mediaVoto = mediaVoto;
	}

	public Integer getNumeroMaglia() {
		return numeroMaglia;
	}

	public void setNumeroMaglia(Integer numeroMaglia) {
		this.numeroMaglia = numeroMaglia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giocatore other = (Giocatore) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}



}