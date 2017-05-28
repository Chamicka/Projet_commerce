package fr.adaming.dao;

import fr.adaming.model.Client;

public interface IClientDao {

	public Client ajouterClient(Client cl);
	public Client supprimerClient(Client cl);
	public Client modifierClient(Client cl);
	public Client getClientById(long id);
}
