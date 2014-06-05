package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.openjpa.persistence.jdbc.Unique;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAll", query = "SELECT a FROM Amministratore a"),
	@NamedQuery(name = "findAdminByPin", query = "SELECT a FROM Amministratore a WHERE a.pin = :pin"),
})
@Table (name = "Amministratore" ,uniqueConstraints= @UniqueConstraint(columnNames={"pin"}))
public class Amministratore {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false)
	@Unique
	private String pin;
	@Column(nullable=false)
	private String password;

	public Amministratore(String nome, String cognome, String pin, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.pin = pin;
		this.password = password;
	}

	public Amministratore(){}

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
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
