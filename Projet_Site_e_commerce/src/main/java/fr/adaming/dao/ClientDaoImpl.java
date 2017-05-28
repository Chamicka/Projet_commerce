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

}
