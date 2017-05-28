package fr.adaming.service;

import fr.adaming.model.Panier;

public interface IPanierService {
	public int calculerTotal(Panier p);
	public Panier supprimerLigne(Panier p, long idL);
}
