package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	private SessionFactory sf;
		
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Client ajouterClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.save(cl);
		return cl;
	}

	@Override
	public Client supprimerClient(Client cl) {
		Session s = sf.getCurrentSession();
		Client cl_rec=(Client) s.get(Client.class, cl.getId());
		s.delete(cl_rec);
		return null;
	}

	@Override
	public Client modifierClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.update(cl);
		return null;
	}

	@Override
	public Client getClientById(long id) {
		Session s = sf.getCurrentSession();
		return (Client) s.get(Client.class, id);
	}

}
