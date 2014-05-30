package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class ResponsabileSquadra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;

	

	@OneToOne(cascade ={CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name="squadra_id")
	private Squadra squadra;
	
	public ResponsabileSquadra(){}

	public ResponsabileSquadra(String nome, String cognome,
			String email, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}




}