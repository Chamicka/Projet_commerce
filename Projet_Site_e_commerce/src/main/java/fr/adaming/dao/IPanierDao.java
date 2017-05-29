package fr.adaming.dao;

import fr.adaming.model.Panier;

public interface IPanierDao {

	public int calculerTotal(Panier p);
	public Panier supprimerLigne(Panier p, long idL);
	public Panier supprimerMoins(Panier p, int index);
}
