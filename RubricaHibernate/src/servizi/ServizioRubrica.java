package servizi;

import java.util.Set;

import dao.RubricaDao;
import dao.VoceDao;
import model.Rubrica;
import model.Voce;

public class ServizioRubrica {

	private VoceDao contattoDao = new VoceDao();
	private RubricaDao rubricaDao = new RubricaDao();

	public boolean registraRubrica(String nome) {
		boolean res = false;
		
	//registro la mia Rubrica	
		Rubrica rubrica = new Rubrica(nome);
		res = rubricaDao.creaRubrica(rubrica);
		return res;
	}

// Aggiungo un nuovo conatatto alla mia Rubrica
	public boolean aggiungiVoce(Rubrica rubrica, String nome, String cognome,String tel) {
		boolean res = false;
		Voce contatto = new Voce(nome, cognome, tel);
		contatto.setRubrica(rubrica);
		rubrica.aggiungiVoce(contatto);
		contattoDao.creaVoce(contatto);
		rubricaDao.aggiornaRubrica(rubrica);
		return res;
	}
	
	public boolean aggiornaVoce(Rubrica rubrica, Voce contatto, String nome, String cognome, String tel){
	
	//qui leggo il mio conattodalla Rubrica tramite l'ID poi aggiorno agni campo dela voce	
		Voce contatto1 = contattoDao.readVoce(contatto.getId_voce());
		contatto1.setNome(nome);
		contatto1.setCognome(cognome);
		contatto1.setTel(tel);
		return contattoDao.updateVoce(contatto1);
	}
//visualizo il contatto tramite il nome e il cognome	
	public Voce getVoce(Rubrica rubrica, String nome, String cognome){
		return contattoDao.readVoce(rubrica, nome, cognome);
	}

	//qui setto in una lista tutti i contatti prezenti nella Rubrica
	public Set<Voce> getAll(Rubrica rubrica){
		return rubrica.getVoci();
	}
	
	public boolean rimuoviVoce(Voce contatto){
		return contattoDao.deleteVoce(contatto);
	}

}
