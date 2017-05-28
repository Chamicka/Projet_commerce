package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPanierDao;
import fr.adaming.dao.PanierDaoImpl;
import fr.adaming.model.Panier;

@Service
@Transactional
public class PanierServiceImpl implements IPanierService {

	@Autowired
	private IPanierDao pDao = new PanierDaoImpl();
	
	
	/**
	 * @param pDao the pDao to set
	 */
	public void setpDao(IPanierDao pDao) {
		this.pDao = pDao;
	}


	@Override
	public int calculerTotal(Panier p) {
		return pDao.calculerTotal(p);
	}


	@Override
	public Panier supprimerLigne(Panier p, long idL) {
		return pDao.supprimerLigne(p, idL);
	}

}
