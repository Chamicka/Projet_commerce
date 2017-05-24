package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao {

	public Produit ajouterProduit(Produit p) ;
	public Produit supprimerProduit(Produit p);
	public Produit modifierProduit(Produit p);
	public Produit getProduitById(long id);
	public List<Produit> getAllProduits() ;
	
	
	
}
