package dao;

import hibernateUtil.HibernateUtil;
import model.Rubrica;
import model.Voce;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {

	// 1- Create
	public boolean creaVoce(Voce contatto) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(contatto);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	//2- Leggi contatto per Id
	public Voce readVoce(long contatto_id){
		Voce contatto = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			contatto = session.get(Voce.class, contatto_id);
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}	
		return contatto;	
	} 

//Leggi contatto tramite il nome e cognome	
	public Voce readVoce(Rubrica rubrica, String nome, String cognome){
		Voce contatto = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Voce where rubrica_id_rubrica=:rubricaScelta and nome=:nomeInserito and cognome=:cognomeInserito");
			query.setLong("rubricaScelta", rubrica.getId_Rubrica());
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			contatto = (Voce) query.uniqueResult();
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}	
		return contatto;	
	}
	
	//3- Aggiorna Contatto 
	public boolean updateVoce(Voce contatto) {
		boolean token = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			session.update(contatto);
			tx.commit();
			token = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return token;	
	}
	
	//4-Cancella Contatto 
	public boolean deleteVoce(Voce contatto){
		boolean token = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			session.delete(contatto);
			tx.commit();
			token = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return token;
	}
}
