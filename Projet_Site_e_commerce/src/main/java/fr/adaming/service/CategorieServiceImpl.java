package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Service
@Transactional
public class CategorieServiceImpl implements ICategorieService{

	@Autowired
	private ICategorieDao cDao;
	
	public void setcDao(ICategorieDao cDao) {
		this.cDao = cDao;
	}

	@Override
	public Categorie ajouterCategorie(Categorie c) {
		return cDao.ajouterCategorie(c);
	}

	@Override
	public Categorie supprimerCategorie(Categorie c) {
		return cDao.supprimerCategorie(c);
	}

	@Override
	public Categorie modifierCategorie(Categorie c) {
		return cDao.modifierCategorie(c);
	}

	@Override
	public Categorie getCategorieById(long id) {
		return cDao.getCategorieById(id);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return cDao.getAllCategories();
	}

}
