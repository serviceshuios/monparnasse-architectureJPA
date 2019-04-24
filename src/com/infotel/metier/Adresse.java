package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdresse;
	private String numRue;
	private String nomRue;
	private String ville;
	private String cp;
	@OneToMany(mappedBy = "adresse")
	private List<Personne> personnes = new ArrayList<Personne>();
	
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", numRue=" + numRue + ", nomRue=" + nomRue + ", ville=" + ville
				+ ", cp=" + cp + ", getIdAdresse()=" + getIdAdresse() + ", getNumRue()=" + getNumRue()
				+ ", getNomRue()=" + getNomRue() + ", getVille()=" + getVille() + ", getCp()=" + getCp()
				+ "]";
	}
	
	@PreRemove
	public void deleteSetNull() {
		for(Personne p : personnes)
		{
			p.setAdresse(null);	
		}
	}
}

