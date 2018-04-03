package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

public interface UserService {

	List<User> findAllUsers();

//	List<Client> findAllClients();

	User findUserById(int id);

	Client findClientById(int id);

	Client saveClient(Client client);

	//
	// User findById(long id);
	//
	// User findByName(String name);
	//
	// User saveUser(User user);
	//
	// void updateUser(User user);
	//
	// void deleteUserById(long id);
	//
	// List<User> findAllUsers();
	//
	// void deleteAllUsers();
	//
	// public boolean isUserExist(User user);
	//
	// List<Compte> findAllComptesRemunateurs();
	//
	// //*******************************
	// void creerCompte(User user , Compte compte ) ;
	// void saveClient(Client client);
	// Compte saveCompte(Compte compte);
	// CompteAvecDecouvert saveCompteAvecDecouvert(CompteAvecDecouvert compte);
	// List<Compte> findAllComptes();
	// Compte findCompteById(int id);
	// Client findClientById(int id);

	// *********************************

}
