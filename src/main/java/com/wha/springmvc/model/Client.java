package com.wha.springmvc.model;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CL")
@Table(name = "CLIENT")

public class Client extends User {

	@OneToMany(mappedBy = "client")
	private Collection<Compte> comptes;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String email, String identifiant, String pwd, String address,
			String numTel) {
		super(nom, prenom, email, identifiant, pwd, address, numTel);
		// TODO Auto-generated constructor stub
	}

}
