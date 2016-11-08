package it.alfasoft.gheorghe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voce implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_voce;
	private String nome;
	private String cognome;
	private String telefono;
	@ManyToOne
	private Rubrica rubrica;
	
	public Voce(){}

	public Voce(long id_voce, String nome, String cognome, String telefono,
			Rubrica rubrica) {
		super();
		this.id_voce = id_voce;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.rubrica = rubrica;
	}

	public long getId_voce() {
		return id_voce;
	}

	public void setId_voce(long id_voce) {
		this.id_voce = id_voce;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
