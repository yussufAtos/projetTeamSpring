package com.wha.springmvc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wha.springmvc.model.User;

public class service {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public void sauver(User user) {
		entityManager.persist(user);
	}


	public service() {
	
	}
	
	

}
