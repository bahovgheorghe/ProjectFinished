package biblioteca;

import java.util.*;

import static utility.DataUtility.*;

public class Gestione {

	//qui registro il libro nella Biblioteca
	public Libro registraLibro(Biblioteca biblioteca, String titolo, String autore,String sn, int copie) {
		//qui guardo il numero di serie se nella lista dei libri che sono presenti nella biblioteca esiste il mio
		Libro libro = biblioteca.getLibri().get(sn);
		
		if (libro != null) {//se il libro è presente nella lista lo aggiorno
			libro.setCopieTotali(libro.getCopieTotali() + copie);
			libro.setCopieDisp(libro.getCopieDisp() + copie);
		} else {//se il libro non è presente nella lista lo creo e lo aggiungo
			libro = new Libro(titolo, autore, sn);
			libro.setCopieTotali(copie);
			libro.setCopieDisp(copie);
			biblioteca.aggiungiLibro(libro);
		}
		return libro;
	}

	//registro un nuovo utente metodo di registrazione quasi uguale al quello del libro	
	public Utente registraUtente(Biblioteca biblioteca, String nome, String cognome, String cf)
			throws UtenteGiaEsiste{
		if(biblioteca.getUtenti().containsKey(cf)){//se l'utente esiste gia lo segnalo e non lo registriamo 
			throw new UtenteGiaEsiste("L'utente è gia registrato!");
		}else{//se l'utente esiste non esiste lo registriamo 
			Utente utente = new Utente(nome, cognome, cf);
			biblioteca.getUtenti().put(cf, utente);
			return utente;
		}	
	}
	
//metodo per prestare il libro
	public boolean prestaLibro(Biblioteca biblioteca, String serialNum, String cf){
		boolean risp=false;
		
		Libro libro = biblioteca.getLibri().get(serialNum);
		Utente utente = biblioteca.getUtenti().get(cf);
	
	//qui controllo che se il libro esiste e l'utente non abbia gia fatto 3 prestiti che il numero di copie non sia inferiore a tre,
	//le copie disponibili del libro siano maggiori di 3 e l'utente non sia nullo 	
		if(libro!=null && utente!=null 
				&& utente.getNumeroLibri() < 3 
				&& libro.getCopieDisp() > 0){
			
			Date today = new Date();
			Calendar cal = utilDateToCalendar(today);
			cal.add(Calendar.DATE, 14);
			Date dataScadenza = cal.getTime();
			Prestito prestito = new Prestito(utente, libro, today, dataScadenza);
			biblioteca.getPrestiti().put(utente.getCf()+"-"+libro.getSerialNum(), prestito);
			utente.aggiungiLibro(libro);
			libro.setCopieDisp(libro.getCopieDisp()-1);
			risp = true;
		}		
		return risp;
	}
	
	
//metodo per restituzione di un libro	
	public boolean restituisciLibro(Biblioteca biblioteca, String serialNum, String cf){
		boolean risp=false;
		
		Libro libro = biblioteca.getLibri().get(serialNum);
		Utente utente = biblioteca.getUtenti().get(cf);
		
		if(libro!=null && utente!=null && biblioteca.getPrestiti().containsKey(cf+" "+serialNum)){
			for(Map.Entry<String, Prestito> p : biblioteca.getPrestiti().entrySet()){
				if(p.getValue().getL().equals(libro)
						&& p.getValue().getU().equals(utente)
						&& p.getValue().getRestituzione()==null){
					//mi serve per vedere il giorno in cui viene restituito il libro
					Date oggi = new Date();
					Prestito prestito = biblioteca.getPrestiti().get(cf+" "+serialNum);
					prestito.setRestituzione(oggi);
					risp = true;
					break;
				}
			}
		}		
		return risp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}