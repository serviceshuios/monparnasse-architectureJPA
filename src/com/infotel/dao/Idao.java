package com.infotel.dao;

import java.util.List;

import com.infotel.metier.Personne;

public interface Idao {

	public int ajouterPersonne(Personne p);
	public Personne getPersonne(int idPersonne);
	public Personne affichagePersonne(int idPersonne);
	public int supprimerPersonne(Personne p);
	public int modifierPersonne(Personne p);
	public List<Personne> findAllPersonnes();
	public List<Personne> rechercherParMC(String mc);
	
	public List<Personne> findAllPersonnesConnexion();
	
	public List<Personne> findAllPersonnesAdresse();
}
