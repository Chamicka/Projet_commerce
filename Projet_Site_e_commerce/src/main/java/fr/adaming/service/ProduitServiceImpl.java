package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;
@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	private IProduitDao pDao ;
	
	/**
	 * @param pDao the pDao to set
	 */
	public void setpDao(IProduitDao pDao) {
		this.pDao = pDao;
	}

	@Override
	public Produit ajouterProduit(Produit p) {
		return pDao.ajouterProduit(p);
	}

	@Override
	public Produit supprimerProduit(Produit p) {
		return pDao.supprimerProduit(p);
	}

	@Override
	public Produit modifierProduit(Produit p) {
		return pDao.modifierProduit(p);
	}

	@Override
	public Produit getProduitById(Produit p) {
		return pDao.getProduitById(p);
	}

	@Override
	public List<Produit> getAllProduits() {
		return pDao.getAllProduits();
	}

}
