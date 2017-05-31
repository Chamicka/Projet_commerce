package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

public interface IProduitService {
	
	public Produit ajouterProduit(Produit p) ;
	public Produit supprimerProduit(Produit p);
	public Produit modifierProduit(Produit p);
	public Produit getProduitById(long id);
	public List<Produit> getAllProduits() ;
	public List<Produit> getAllProduitsByCat(Categorie c);
	public Panier ajouterAuPanier(long id_prod, Panier panier , int quantite);
	public Panier ajouterAuPanierPlus(Panier panier, int index);
	public List<Produit> getByKeyWord(String mot);
}
