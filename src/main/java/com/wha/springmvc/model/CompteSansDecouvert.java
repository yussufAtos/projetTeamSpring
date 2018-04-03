package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CSD")
public class CompteSansDecouvert extends Compte {
	
	private static final double decouvert =0;

	public CompteSansDecouvert() {
		
	}

	
	public CompteSansDecouvert(Client client) {
		super(client);
		
		}
	public CompteSansDecouvert(double solde, Date dateCreation, Client client) {
		super(solde, dateCreation, client);
	
	}

	public static double getDecouvert() {
		return decouvert;
	}



	
	
	
	

}