package com.wha.springmvc.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {


//	@Override
//	public List<User> findAllClients() {
//		List<User> cl =  (List<User>) getEntityManager().createQuery("SELECT c FROM User c where role='CL' ");
//		return cl;
//	}

	@Override
	public User findUserById(int id) {
		User user = getByKey(id);
		return user;
	}

	@Override
	public Client findClientById(int id) {
		Client  client = (Client) getByKey(id);
		return client;
	}

	@Override
	public Client save(Client client) {
		persist(client);
		return client;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.username ASC").getResultList();				
		return users;
	}
	

//	@Override
//	public User findByName(String name) {
//		System.out.println("name: "+ name);
//		try {
//			User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name", name).getSingleResult();
//			return user;
//			
//		} catch (NoResultException ex) {
//			return null;
//		}
//	}



//	@Override
//	public void deleteUserById(int id) {
//		User user = getByKey(id);
//		delete(user);
//
//	}



	
//	public void deleteBySSO(String sso){
//		User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
//		delete(user);
//	}

//	@Override
//	public void deleteAllUsers() {
//		// TODO Auto-generated method stub
//
//	}
	
	//An alternative to Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection){
		if (collection==null) {
			return;
		}
		collection.iterator().hasNext();
	}

	
	
}
