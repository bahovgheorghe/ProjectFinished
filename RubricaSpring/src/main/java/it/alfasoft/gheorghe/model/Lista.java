package it.alfasoft.gheorghe.model;

import java.util.ArrayList;
import java.util.List;

public class Lista {

	private List<Voce> lista = new ArrayList<Voce>();

	public Lista() {
	}

	public Lista(List<Voce> lista) {
		super();
		this.lista = lista;
	}

	public List<Voce> getLista() {
		return lista;
	}

	public void setLista(List<Voce> lista) {
		this.lista = lista;
	}
	
	
}
