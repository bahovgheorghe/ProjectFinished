package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity   //questa annotazione dico che questa classe e un entita
public class Rubrica {

	@Id //gli dico che deve avere un id
	@GeneratedValue(strategy = GenerationType.AUTO)  //
	private long id_Rubrica;
	private String nome;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rubrica", cascade = CascadeType.ALL)// do la relazione dicendo che e 1 a molti cioe una rubrica puo avere piu contatti
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Voce> contatti = new HashSet<Voce>();

//costruttore vuoto che di default esiste gia ma e meglio se lo faccio pure io	
	public Rubrica() {
		this.nome = "";
	}

//costruttore	
	public Rubrica(String nome) {
		this.nome = nome;
	}

	public long getId_Rubrica() {
		return id_Rubrica;
	}
	public void setId_Rubrica(long id_Rubrica) {
		this.id_Rubrica = id_Rubrica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Voce> getVoci() {
		return contatti;
	}
	public void setVoci(Set<Voce> voci) {
		this.contatti = voci;
	}
	public void aggiungiVoce(Voce contatto) {
		this.contatti.add(contatto);
	}
}
