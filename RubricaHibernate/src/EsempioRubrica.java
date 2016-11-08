import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import servizi.ServizioRubrica;

public class EsempioRubrica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServizioRubrica servizioRubrica= new ServizioRubrica();
		
		System.out.println("Rubrica Creata "+servizioRubrica.registraRubrica("Gheorghe"));

		RubricaDao rubricaDao = new RubricaDao();

		Rubrica rubrica = rubricaDao.readRubrica(1);
//qui stampo il nome della Rubrica per poter prendere l'ID della rubrica
		System.out.println(rubrica.getNome() + " " + rubrica.getId_Rubrica());

//tramite il servizioRubrica aggiungo dei contatti alla mia Rubrica		
		servizioRubrica.aggiungiVoce(rubrica, "Mario", "Rossi", "0112358456");
		servizioRubrica.aggiungiVoce(rubrica, "Niccolo", "Mariotide", "3258965486");
		servizioRubrica.aggiungiVoce(rubrica, "Pinco", "Pallo", "3986547256");
		
//di seguito prendo 1 contatto per nome e cognome e stampero tutti i datti a lui associati incluso l'id della Rubrica				
		Voce contatto1 = servizioRubrica.getVoce(rubrica, "Niccolo", "Mariotide");
		System.out.println(contatto1.getId_voce()+" "+contatto1.getNome() + " " + contatto1.getCognome()+" "+contatto1.getTel()+" "+contatto1.getRubrica().getId_Rubrica());
		
//qui di seguito stampo tutte le coci presenti nella Rubrica		
		for(Voce contatti: servizioRubrica.getAll(rubrica)){
			System.out.println(contatti.getId_voce()+" "+contatti.getNome() + " " + contatti.getCognome()+" "+contatti.getTel());
		}
//di seguito prendo un contatto tramite nome e cognome dalla Rubrica 		
		Voce contatto2 = servizioRubrica.getVoce(rubrica, "Pinco", "Pallo");

//aggiorno la voce che ho preso prima dalla Rubrica tramite il nome e cognome e aggiorno tutti i suoi campi 		
		System.out.println("Contatto aggiornato  "+servizioRubrica.aggiornaVoce(rubrica, contatto2, "Mario", "Verdi", "3335426865"));

//cancello 1 contatto dala mia Rubrica 		
		servizioRubrica.rimuoviVoce(contatto1);	
		
		System.out.println("MVC Completo!");		
	}

}
