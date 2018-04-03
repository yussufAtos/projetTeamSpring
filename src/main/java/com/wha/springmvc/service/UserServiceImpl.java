package com.wha.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	

//	@Override
//	public List<User> findAllClients() {
//		return userDao.findAllClients();
//	}

	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	public Client saveClient(Client client) {
		return userDao.save(client);
	
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public Client findClientById(int id) {
		return userDao.findClientById(id);
	}

	

	





//	public User findByName(String name) {
//		/*
//		 * for(User user : users){ if(user.getUsername().equalsIgnoreCase(name)){ return
//		 * user; } }
//		 */
//		return dao.findByName((String) name);
//	}

//	public void updateUser(User user) {
//		/*
//		 * int index = users.indexOf(user); users.set(index, user);
//		 */
//
//		User entity = dao.findById((int) user.getId());
//		if (entity != null) {
//			entity.setUsername(user.getUsername());
//			entity.setAddress(user.getAddress());
//			entity.setEmail(user.getEmail());
//
//		}
//		dao.save(entity);
//	}

//	public void deleteUserById(long id) {
//
//		/*
//		 * for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) { User
//		 * user = iterator.next(); if (user.getId() == id) { iterator.remove(); } }
//		 */
//
//		dao.deleteUserById((int) id);
//
//	}

//	public boolean isUserExist(User user) {
//		return dao.findByName((String) user.getUsername()) != null;
//	}
//
//	public void deleteAllUsers() {
//		dao.deleteAllUsers();
//
//	}

	/*
	 * private static List<User> populateDummyUsers(){ List<User> users = new
	 * ArrayList<User>(); users.add(new User(counter.incrementAndGet(),"Sam",
	 * "PARIS", "sam@abc.com")); users.add(new
	 * User(counter.incrementAndGet(),"wajih", "rue albert 1er COLOMBES",
	 * "wajih@formation.com")); users.add(new User(counter.incrementAndGet(),"Tomy",
	 * "ALBAMA", "tomy@abc.com")); return users; }
	 */

}
