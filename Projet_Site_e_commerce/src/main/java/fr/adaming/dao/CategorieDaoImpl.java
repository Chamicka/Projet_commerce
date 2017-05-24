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
public class CategorieDaoImpl implements ICategorieDao{

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Categorie ajouterCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		return c;
	}

	@Override
	public Categorie supprimerCategorie(Categorie c) {
		Session s=sf.getCurrentSession();
		Categorie c_rec=(Categorie) s.get(Categorie.class, c.getId());
		s.delete(c_rec);
		return null;
	}

	@Override
	public Categorie modifierCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		s.update(c);
		return c;
	}

	@Override
	public Categorie getCategorieById(long id) {
		Session s = sf.getCurrentSession();
		return (Categorie) s.get(Categorie.class, id);
	}

	@Override
	public List<Categorie> getAllCategories() {
		Session s=sf.getCurrentSession();
		String rec="from Categorie";
		Query query=s.createQuery(rec);
		return query.list();
	}

}
