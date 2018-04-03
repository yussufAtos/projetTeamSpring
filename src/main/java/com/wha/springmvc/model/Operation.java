package com.wha.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "OPERATIONS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation", discriminatorType = DiscriminatorType.STRING, length = 7)
public  class Operation implements Serializable {
	@Id
	@GeneratedValue
	private int numOperation;
	private Date dateEffet ;
	
	private double montant;
	private String libelle;
	@ManyToOne
	@JoinColumn(name = "Id_Compte")
	private Compte compte ;
	
	
	
	public int getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(int numOperation) {
		this.numOperation = numOperation;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	
	public Operation() {
		}

	public Operation(Date dateEffet, double montant, String libelle, Compte compte) {
		super();
		this.dateEffet = dateEffet;
		this.montant = montant;
		this.libelle = libelle;
		this.compte = compte;
	}



	
	
	
}	
	
	
	