package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

public interface UserDao {

	List<User> findAllUsers();

	User findUserById(int id);

	Client findClientById(int id);

	Client save(Client client);

	// List<User> findAllClients();
	// User findByName(String name);
	// void deleteUserById(int id);
	// void deleteAllUsers();

}
