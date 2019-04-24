package com.infotel.service;

import java.util.List;

import com.infotel.metier.Personne;

public interface Iservice {
	public int ajouterPersonne(Personne p);
	public List<Personne> findAllPersonnesConnexion();
	public List<Personne> findAllPersonnesAdresse();

}
