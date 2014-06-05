package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
@NamedQuery(name = "trovaSquadre", query = "SELECT s FROM Squadra s ORDER BY s.punti DESC, s.diff DESC, s.fatti DESC, s.subiti ASC, s.vinte DESC, s.nome ASC")
@Table(name="squadre")
public class Squadra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="squadra_id")
	private Long id;

	@Column(name="nome", nullable=false)
	private String nome;

	@Column(nullable=false)
	private String coloriSociali;

	@Column(nullable=false)
	private String via;
	
	@Column
	private Integer giocate;
	
	@Column
	private Integer vinte;
	
	@Column
	private Integer nulle;
	
	@Column
	private Integer perse;
	
	@Column
	private Integer fatti;
	
	@Column
	private Integer subiti;
	
	@Column
	private Integer diff;
	
	@Column
	private Integer punti;


	@OneToMany(mappedBy="squadra", cascade = {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Giocatore> giocatori;

	@OneToOne(cascade ={CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER)
	private ResponsabileSquadra responsabile;


	@OneToMany(mappedBy="squadraCasa", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Partita> partiteInCasa;

	@OneToMany(mappedBy="squadraOspiti", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Partita> partiteFuori;

	public Squadra() {}

	public Squadra(String nome, String coloriSociali, String via, ResponsabileSquadra responsabile) {
		this.nome = nome;
		this.coloriSociali = coloriSociali;
		this.via = via;
		this.punti = 0;
		this.giocate = 0;
		this.vinte = 0;
		this.nulle = 0;
		this.perse = 0;
		this.fatti = 0;
		this.subiti = 0;
		this.subiti = 0;
		this.diff = 0;
		this.responsabile = responsabile;
		this.giocatori = new ArrayList<Giocatore>();
	}

	public Integer getDiff() {
		return diff;
	}

	public void setDiff(Integer diff) {
		this.diff = diff;
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


	public ResponsabileSquadra getResponsabile() {
		return responsabile;
	}


	public void setResponsabile(ResponsabileSquadra responsabile) {
		this.responsabile = responsabile;
	}

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
	
	public Integer getGiocate() {
		return giocate;
	}

	public void setGiocate(Integer giocate) {
		this.giocate = giocate;
	}

	public Integer getVinte() {
		return vinte;
	}

	public void setVinte(Integer vinte) {
		this.vinte = vinte;
	}

	public Integer getNulle() {
		return nulle;
	}

	public void setNulle(Integer nulle) {
		this.nulle = nulle;
	}

	public Integer getPerse() {
		return perse;
	}

	public void setPerse(Integer perse) {
		this.perse = perse;
	}

	public Integer getFatti() {
		return fatti;
	}

	public void setFatti(Integer fatti) {
		this.fatti = fatti;
	}

	public Integer getSubiti() {
		return subiti;
	}

	public void setSubiti(Integer subiti) {
		this.subiti = subiti;
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
