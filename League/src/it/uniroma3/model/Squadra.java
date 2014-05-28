package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
@NamedQuery(name = "trovaSquadre", query = "SELECT s FROM Squadra s")
@Table(name="squadre")
public class Squadra {

    @Id
    @GeneratedValue
    @Column(name="squadra_id")
    private Long id;

	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String coloriSociali;
	
	@Column(nullable=false)
	private String via;
	
	@Column
	private Integer punti;

	@OneToMany(mappedBy="squadra", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Giocatore> giocatori;
	
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private ResponsabileSquadra responsabile;

	
	@OneToMany(mappedBy="squadraA", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Partita> partiteInCasa;

	@OneToMany(mappedBy="squadraB", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Partita> partiteFuori;

	public Squadra() {}

	public Squadra(String nome, String coloriSociali, String via, ResponsabileSquadra responsabile) {
		this.nome = nome;
		this.coloriSociali = coloriSociali;
		this.via = via;
		this.punti = 0;
		this.responsabile = responsabile;
		this.giocatori = new ArrayList<Giocatore>();
	}

	public String getNome() {
		return this.nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}





	public List<Giocatore> getGiocatori() {
		return this.giocatori;
	}


	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}


	public List<Partita> getPartiteInCasa() {
		return partiteInCasa;
	}


	public void setPartiteInCasa(List<Partita> partiteInCasa) {
		this.partiteInCasa = partiteInCasa;
	}

/*
	public ResponsabileSquadra getResponsabile() {
		return responsabile;
	}


	public void setResponsabile(ResponsabileSquadra responsabile) {
		this.responsabile = responsabile;
	}
*/
	public List<Partita> getPartiteFuori() {
		return partiteFuori;
	}


	public void setPartiteFuori(List<Partita> partiteFuori) {
		this.partiteFuori = partiteFuori;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColoriSociali() {
		return coloriSociali;
	}

	public void setColoriSociali(String coloriSociali) {
		this.coloriSociali = coloriSociali;
	}
	
	public Integer getPunti() {
		return punti;
	}

	public void setPunti(Integer punti) {
		this.punti = punti;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}






}