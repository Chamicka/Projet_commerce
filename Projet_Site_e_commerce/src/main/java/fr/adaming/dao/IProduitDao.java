package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitDao {

	public Produit ajouterProduit(Produit p);
	public Produit supprimerProduit(Produit p);
	public Produit modifierProduit(Produit p);
	public Produit getProduitById(long id);
	public List<Produit> getAllProduits();
	public List<Produit> getAllProduitsByCat(Categorie c);
	public Produit ajouterAuPanier(long id_prod, long id_pan , int quantite);
	
	
	
}
