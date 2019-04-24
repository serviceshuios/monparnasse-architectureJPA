package com.infotel.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CLI")
public class Client extends Personne {
	private int numAdherent;

	public int getNumAdherent() {
		return numAdherent;
	}

	public void setNumAdherent(int numAdherent) {
		this.numAdherent = numAdherent;
	}

	@Override
	public String toString() {
		return "Client [numAdherent=" + numAdherent + ", toString()=" + super.toString() + "]";
	}
}
