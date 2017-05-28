package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clDao;
		
	/**
	 * @param clDao the clDao to set
	 */
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
	}

	@Override
	public Client ajouterClient(Client cl) {
		return clDao.ajouterClient(cl);
	}

}
