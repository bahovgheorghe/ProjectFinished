package dao;

import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Rubrica;

public class RubricaDao {

	// 1- Create Rubrica

	public boolean creaRubrica(Rubrica r) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(r);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	// 2- Leggi Rubrica per id 
	public Rubrica readRubrica(long r_id) {
		Rubrica rubrica = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			rubrica = session.get(Rubrica.class, r_id);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return rubrica;
	}

//Leggi Rubrica per nome	
	public Rubrica readRubrica(String nome) {
		Rubrica rubrica = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Rubrica where nome=:nomeInserito ");
			query.setString("nomeInserito", nome);
			rubrica = (Rubrica) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return rubrica;
	}
	
	// 3- Aggiorna Rubrica 
	public boolean aggiornaRubrica(Rubrica r) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(r);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
