package com.wha.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Operation;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.CompteService;
import com.wha.springmvc.service.OperationService;
import com.wha.springmvc.service.UserService;

@RestController
@Controller
public class HelloWorldRestController {

	@Autowired
	UserService userService; // Service which will do all data retrieval/manipulation work

	@Autowired
	CompteService compteService;
	
	@Autowired
	OperationService operationService ;
	
	// -------------------Retrieve All
	// Users--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findUserById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getUsername());

		// if (userService.isUserExist(user)) {
		// System.out.println("A User with name " + user.getUsername() + " alreaexist");
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		// }

		// ****************

		Client cl1 = new Client("Agdam", "Youssef", "yussuf9@gmail.com", "yoyo2018", "1234", "9,rue de la victoire",
				"0641083928");
		Client cl2 = new Client("Alpha", "Mamdo", "alpha@gmail.com", "yoyo2018", "1234", "10,rue de la justice",
				"0641083928");
		Client cl3 = new Client("Ali", "Baba", "ali@gmail.com", "yoyo2018", "1234", "9,rue de la republique",
				"0641083928");

		userService.saveClient(cl1);
		userService.saveClient(cl2);
		userService.saveClient(cl3);
		
		
		
		
		Compte cc1 = new CompteCourant(1000, new Date(), 50, cl1);
		Compte cc2 = new CompteCourant(1000, new Date(), 50, cl1);
		Compte cr1 = new CompteRemunerateur(200, new Date(), 2.5, cl2);
		Compte cc3 = new CompteCourant(1000, new Date(), 50, cl2);
		Compte cr2 = new CompteRemunerateur(200, new Date(), 2.5, cl3);
		Compte cc5 = new CompteCourant(1000, new Date(), 50, cl3);
		compteService.saveCompte(cc1);
		compteService.saveCompte(cc2);
		compteService.saveCompte(cc3);
        compteService.saveCompte(cr1);
		compteService.saveCompte(cr2);
	
		Operation deb1=new Debit(new Date(),12,"libelle1", cc1);
		Operation deb2=new Debit(new Date(),15,"libelle2", cc2);
		Operation cred1 =new Credit(new Date(),18,"libelle3", cc2);
		
		
		operationService.saveOperation(deb1);
		operationService.saveOperation(cred1);
        operationService.saveOperation(deb2);
		
		
	
//		userService.saveClient(cl1);
//		userService.saveClient(cl2);
//		userService.saveClient(cl3);
//
//		compteService.saveCompteCourant(cc1);
//		compteService.saveCompteCourant(cc2);
//		compteService.saveCompteCourant(cc3);
//        compteService.saveCompteRemunerateur(cr1);
//		compteService.saveCompteRemunerateur(cr2);
//		
//	
//		
//		operationService.saveCredit(cred1);
//		operationService.saveDebit(deb1);
//		operationService.saveDebit(deb2);
		
		


		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	// ********************** Les utilisateurs ******************************//

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> findUsers() {
		return userService.findAllUsers();
	}

//	@RequestMapping(value = "/clients", method = RequestMethod.GET)
//	public List<Client> findClients() {
//		return userService.findAllClients();
//	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User trouverClient(@PathVariable int id) {
		return userService.findUserById(id);
	}

	@RequestMapping(value = "/saveclient", method = RequestMethod.POST)
	public void saveuser(@RequestBody Client client) {

		userService.saveClient(client);
	}

	// **************************** les comptes****************************//

	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte> compteClients() {
		return compteService.findAllComptes();
	}

	@RequestMapping(value = "/comptes/{id}", method = RequestMethod.GET)
	public Compte trouveCompte(@PathVariable int id) {
		return compteService.findCompteById(id);
	}

	@RequestMapping(value = "/comptesRemunerateur", method = RequestMethod.GET)
	public List<Compte> findAllClientsRem() {
		return compteService.findAllComptesRemunateurs();
	}

	@RequestMapping(value = "/comptesCourant", method = RequestMethod.GET)
	public List<Compte> findAllClientscourants() {
		return compteService.findAllComptesCourant();
	}

	@RequestMapping(value = "/savecompteCourant/{id}", method = RequestMethod.POST)
	public void savecompte(@PathVariable int id, @RequestBody CompteCourant cc) {
	Client  cl = userService.findClientById(id);
		cc.setClient(cl);
	compteService.saveCompteCourant(cc);
//		compteService.saveCompte(cc);
		
	}

	@RequestMapping(value = "/savecompteRemunerateur/{id}", method = RequestMethod.POST)
	public void savecompte(@PathVariable int id, @RequestBody CompteRemunerateur cr) {
		Client cl = userService.findClientById(id);
		cr.setClient(cl);

		compteService.saveCompteRemunerateur(cr);
	}


	//*********************les oprations **************************//
	
	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public List<Operation> operations() {
		return operationService.findAllOperation();
	}
	
	@RequestMapping(value = "/saveoperation/{id}", method = RequestMethod.POST)
	public void saveoperation(@PathVariable int id , @RequestBody Credit credit) {
		Compte compte =compteService.findCompteById(id);
		credit.setCompte(compte);
		operationService.saveOperation(credit);

	}
	

	// ------------------- Update a User// --------------------------------------------------------

	// @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	// public ResponseEntity<User> updateUser(@PathVariable("id") int id,
	// @RequestBody User user) {
	// System.out.println("Updating User " + id);
	//
	// User currentUser = userService.findUserById(id);
	//
	// if (currentUser == null) {
	// System.out.println("User with id " + id + " not found");
	// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	// }
	//
	// currentUser.setUsername(user.getUsername());
	// currentUser.setAddress(user.getAddress());
	// currentUser.setEmail(user.getEmail());
	//
	// userService.updateUser(currentUser);
	// return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	// }

	// ------------------- Delete a User// --------------------------------------------------------

	// @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	// public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
	// System.out.println("Fetching & Deleting User with id " + id);
	//
	// User user = userService.findUserById(id);
	// if (user == null) {
	// System.out.println("Unable to delete. User with id " + id + " not found");
	// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	// }
	//
	// userService.deleteUserById(id);
	// return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	// }
	//
	// // ------------------- Delete All Users // --------------------------------------------------------
	//
	// @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	// public ResponseEntity<User> deleteAllUsers() {
	// System.out.println("Deleting All Users");
	//
	// userService.deleteAllUsers();
	// return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	// }

}