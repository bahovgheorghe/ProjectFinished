package it.alfasoft.gheorghe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
public class Rubrica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_rubrica;
	private String nome;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="rubrica", cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Voce> voci = new ArrayList<Voce>();
	
	public Rubrica(){}

	public Rubrica(long id_rubrica, String nome, List<Voce> voci) {
		super();
		this.id_rubrica = id_rubrica;
		this.nome = nome;
		this.voci = voci;
	}

	public long getId_rubrica() {
		return id_rubrica;
	}
	public void setId_rubrica(long id_rubrica) {
		this.id_rubrica = id_rubrica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Voce> getVoci() {
		return voci;
	}
	public void setVoci(List<Voce> voci) {
		this.voci = voci;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void addVoce(Voce v){
		this.voci.add(v);
	}

}
