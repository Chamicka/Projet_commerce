package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {

	public Categorie ajouterCategorie(Categorie c);
	public Categorie supprimerCategorie(Categorie c);
	public Categorie modifierCategorie(Categorie c);
	public Categorie getCategorieById(long id);
	public List<Categorie> getAllCategories();
}
