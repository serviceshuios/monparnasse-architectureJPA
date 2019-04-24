package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Personne;

public class DaoImpl implements Idao {
	// unité de persistence
	EntityManagerFactory emf;
	// porteur de requête
	EntityManager em;

	@Override
	public int ajouterPersonne(Personne p) {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// 1- débuter la transaction
			tx.begin();
			// 2- effectuer la requête
			em.persist(p);
			// 3- valider la transaction
			tx.commit();
			// 4- fermer l'unité de persistence
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return p.getId();
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Personne p = new Personne();
		try {
			// p=em.find(Personne.class, idPersonne);
			p = em.getReference(Personne.class, idPersonne);
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// 1- débuter la transaction
			tx.begin();
			// 2- effectuer la requête
			em.remove(p);
			// 3- valider la transaction
			tx.commit();
			// 4- fermer l'unité de persistence
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return p.getId();
	}

	@Override
	public int modifierPersonne(Personne p) {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// 1- débuter la transaction
			tx.begin();
			// 2- effectuer la requête
			em.merge(p);
			// 3- valider la transaction
			tx.commit();
			// 4- fermer l'unité de persistence
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		return p.getId();
	}

	@Override
	public Personne affichagePersonne(int idPersonne) {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Personne p = new Personne();
		try {
			// p=em.find(Personne.class, idPersonne);
			p = em.find(Personne.class, idPersonne);
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Personne> findAllPersonnes() {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne p");
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Personne> rechercherParMC(String mc) {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne p where nom like :lenom");
			q.setParameter("lenom", "%"+mc+"%");	
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Personne> findAllPersonnesConnexion() {
		// ouverture unité de persistence et transaction
				emf = Persistence.createEntityManagerFactory("demojpa-pu");
				em = emf.createEntityManager();
				Query q = null;
				List<Personne> l = new ArrayList<Personne>();
				try {
					q = em.createQuery("SELECT p FROM Personne p join p.connexion");
					l = q.getResultList();
					em.close();
					emf.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return l;
	}

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		// ouverture unité de persistence et transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne p left join p.adresse");
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

}
