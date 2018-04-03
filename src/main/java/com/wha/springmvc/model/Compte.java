package com.wha.springmvc.model;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", discriminatorType = DiscriminatorType.STRING, length = 3)

public class Compte implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numeroCompte;
	 private double solde;
     private Date dateCreation;
   
     @ManyToOne
     @JoinColumn(name = "id_Client")
   	private Client client;
   	
   	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;
   	
   
   
   
     public Compte(Client client) {
    	 this.client=client ;

 	}
   
public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

public Compte() {

	}


public Compte(double solde, Date dateCreation, Client client) {
	super();
	this.solde = solde;
	this.dateCreation = dateCreation;
	this.client = client;
}










public int getNumeroCompte() {
	return numeroCompte;
}





public void setNumeroCompte(int numeroCompte) {
	this.numeroCompte = numeroCompte;
}





public double getSolde() {
	return solde;
}





public void setSolde(double solde) {
	this.solde = solde;
}





public Date getDateCreation() {
	return dateCreation;
}





public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
   
   
   
   

}
