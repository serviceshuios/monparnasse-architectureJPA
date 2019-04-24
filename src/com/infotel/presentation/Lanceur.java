package com.infotel.presentation;

import com.infotel.metier.Adresse;
import com.infotel.metier.Client;
import com.infotel.metier.Employe;
import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iservice service = new ServiceImpl();
		Personne p = new Personne();
		p.setNom("ZEC");
		p.setPrenom("UNION");
		p.setAge(20);
		
		service.ajouterPersonne(p);
		
		Employe e = new Employe();
		e.setNom("toto");
		e.setPrenom("tata");
		e.setAge(25);
		e.setSalaire(2000);
		service.ajouterPersonne(e);
		
		Client c = new Client();
		c.setNom("dupont");
		c.setPrenom("pierre");
		c.setAge(35);
		c.setNumAdherent(12);
		service.ajouterPersonne(c);
		/*Personne p = new Personne();*/
	    Adresse a = new Adresse();
	    a.setCp("75000");
	    a.setNomRue("rue des lilas");
	    a.setNumRue("15");
	    a.setVille("Paris");
	    
	    p.setNom("Dupont");
	    p.setPrenom("jean");
	    p.setAge(25);
		//p.setAdresse(a);
		
		service.ajouterPersonne(p);
		// appel à la methode adresse connexion
		for (Personne pers : service.findAllPersonnesConnexion()) {
			System.out.println(pers + " "+pers.getConnexion());
		}
		
		// appel à la methode adresse connexion
				for (Personne pers : service.findAllPersonnesAdresse()) {
					System.out.println(pers + " "+pers.getAdresse());
				}
	}

}
