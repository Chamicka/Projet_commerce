package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {

	public Categorie ajouterCategorie(Categorie c);
	public Categorie supprimerCategorie(Categorie c);
	public Categorie modifierCategorie(Categorie c);
	public Categorie getCategorieById(Categorie c);
	public List<Categorie> getAllCategories();
}
