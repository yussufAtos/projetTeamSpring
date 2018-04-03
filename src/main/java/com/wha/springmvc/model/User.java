package com.wha.springmvc.model;



import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType; 
import javax.persistence.Table;

@Entity
@Table(name="userEntity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Role", discriminatorType = DiscriminatorType.STRING, length = 2)


public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;



	private String prenom;
	private String email;
	private String identifiant;
	private String pwd;
	private String address;
	private String numTel;

	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getIdentifiant() {
		return identifiant;
	}



	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}



	public User(){
	
	}
	






	public User(String username, String prenom, String email, String identifiant, String pwd, String address,
			String numTel) {
		super();
		this.username = username;
		this.prenom = prenom;
		this.email = email;
		this.identifiant = identifiant;
		this.pwd = pwd;
		this.address = address;
		this.numTel = numTel;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", prenom=" + prenom + ", email=" + email
				+ ", identifiant=" + identifiant + ", pwd=" + pwd + ", address=" + address + ", numTel=" + numTel + "]";
	}




		

	
}