package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
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
		Session s=sf.getCurrentSession();
		Produit p_rec=(Produit) s.get(Produit.class, p.getId());
		s.delete(p_rec);
		return null;
	}

	@Override
	public Produit modifierProduit(Produit p) {
		Session s = sf.getCurrentSession();
		s.update(p);
		return p;
	}

	@Override
	public Produit getProduitById(long id) {
		Session s = sf.getCurrentSession();
		return (Produit) s.get(Produit.class, id);
	}

	@Override
	public List<Produit> getAllProduits() {
		Session s=sf.getCurrentSession();
		String rec="from Produit";
		Query query=s.createQuery(rec);
		return query.list();
	}

}
