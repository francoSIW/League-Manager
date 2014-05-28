package it.uniroma3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class PrestazioneGiocatore {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private int voto;
	@Column(nullable=false)
	private int puntiSegnati;

	/*@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
	private Giocatore giocatore;
*/

}