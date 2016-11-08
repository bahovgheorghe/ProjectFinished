package it.alfasoft.gheorghe.service;

import java.util.List;

import it.alfasoft.gheorghe.dao.RubricaDAO;
import it.alfasoft.gheorghe.dao.VoceDAO;
import it.alfasoft.gheorghe.model.Rubrica;
import it.alfasoft.gheorghe.model.Voce;

public class Gestione {
	
	RubricaDAO rDAO = new RubricaDAO();
	VoceDAO vDAO = new VoceDAO();

	public void createRubrica(Rubrica r) {
		rDAO.creaRubrica(r);		
	}

	public void createVoce(Rubrica r, Voce v) {
		v.setRubrica(r);
		vDAO.creaVoce(v);
		r.addVoce(v);
		rDAO.aggiornaRubrica(r);
		
	}
	public Rubrica cercaRubrica(long id){
		return rDAO.readRubrica(id);
	}

	public List<Voce> getAll(Rubrica r) {
		return vDAO.getAll(r);
	}


	
	

}
