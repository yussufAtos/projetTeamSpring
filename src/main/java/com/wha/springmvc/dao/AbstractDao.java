package com.wha.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Operation;
import com.wha.springmvc.model.User;


public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public AbstractDao(){
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	protected T getByKey(PK key){
		return (T) entityManager.find(persistentClass,  key);
	}
	
	protected void persist(User client){
		entityManager.persist(client);
	}
	
	protected void persist(Compte compte){
		entityManager.persist(compte);
	}
	protected void persist(CompteRemunerateur cr){
		entityManager.persist(cr);
	}
	
	protected void persist(CompteCourant cc){
		entityManager.persist(cc);
	}
	
	protected void persist(Debit  debit){
		entityManager.persist(debit);
	}
	
	protected void persist(Credit  credit){
		entityManager.persist(credit);
	}
	protected void persist(Operation op){
		entityManager.persist(op);
	}
	
	protected void update(T entity){
		entityManager.merge(entity);
	}
	
	protected void delete(T entity){
		entityManager.remove(entity);
	}

		
	
}
