package it.alfasoft.gheorghe.service;

import it.alfasoft.gheorghe.model.Rubrica;
import it.alfasoft.gheorghe.model.Voce;

public class MainTest {

	public static void main(String[] args) {
		
		Gestione g = new Gestione();
		Rubrica r = new Rubrica();
		r.setNome("Gheorghe");
		
		g.createRubrica(r);
		
//		Voce v = new Voce();
//		v.setNome("Tizio");
//		v.setCognome("Caio");
//		v.setTelefono("111111");
//		v.setRubrica(r);
//		
//		g.createVoce(r, v);
		

	}

}
