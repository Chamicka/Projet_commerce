package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao{

	@Autowired
	private SessionFactory sf;
	
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Produit ajouterProduit(Produit p) {
		Session s = sf.getCurrentSession();
		s.save(p);
		return p;
	}

	@Override
	public Produit supprimerProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit modifierProduit(Produit p) {
		Session s = sf.getCurrentSession();
		s.update(p);
		return p;
	}

	@Override
	public Produit getProduitById(Produit p) {
		Session s = sf.getCurrentSession();
		return (Produit) s.get(Produit.class, p.getId());
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return null;
	}

}
