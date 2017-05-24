package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {
	
	public Produit ajouterProduit(Produit p) ;
	public Produit supprimerProduit(Produit p);
	public Produit modifierProduit(Produit p);
	public Produit getProduitById(int id);
	public List<Produit> getAllProduits() ;
}
