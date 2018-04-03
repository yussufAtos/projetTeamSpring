package com.wha.springmvc.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Compte;

import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.User;

@Repository("compteDao")
public class CompteDaoImpl extends AbstractDao<Integer, Compte> implements CompteDao {

	@SuppressWarnings("unchecked")
	public List<Compte> findAllComptes() {
		List<Compte> Comptes = getEntityManager().createQuery("SELECT cp FROM Compte cp ").getResultList();

		return Comptes;
	}

	@Override
	public Compte findCompteById(int id) {
		Compte compte = getByKey(id);
		return compte;
	}

	@Override
	public CompteCourant saveCompteCourant(CompteCourant cpc) {
		// TODO Auto-generated method stub
		persist(cpc);
		return cpc;

	}

	@Override
	public List<Compte> findAllComptesRemunateurs() {
		List<Compte> ComptesRemun = getEntityManager().createQuery("SELECT cr FROM Compte cr where type_compte='CR' ")
				.getResultList();
		return ComptesRemun;

	}

	@Override
	public List<Compte> findAllComptesCourant() {
		List<Compte> ComptesRemun = getEntityManager().createQuery("SELECT cr FROM Compte cr where type_compte='CC' ")
				.getResultList();
		return ComptesRemun;

	}

	@Override
	public CompteRemunerateur saveCompteRemunerateur(CompteRemunerateur cr) {
		persist(cr);
		return cr;
	}

	@Override
	public Compte saveCompte(Compte compte) {
		persist(compte);
		return compte;
	}

}
