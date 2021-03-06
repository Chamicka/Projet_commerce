package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
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

	@Override
	public List<Produit> getAllProduitsByCat(Categorie c) {
		Session s=sf.getCurrentSession();
		String rec = "FROM Produit p WHERE p.categorie.id =:pIdC";
		Query query = s.createQuery(rec);
		query.setParameter("pIdC", c.getId());	
		return query.list();
	}

	@Override
	public Panier ajouterAuPanier(long id_prod, Panier panier, int quantite) {
		Session s=sf.getCurrentSession();
		Produit p_rec = (Produit) s.get(Produit.class, id_prod);
		LigneCommande lc = new LigneCommande() ;
		
		lc.setProduit(p_rec);
		lc.setQuantite(quantite);
		lc.calculerPrix();
		List<LigneCommande> newList = new ArrayList<LigneCommande>();
		if (panier.getLignesCommande() == null) {
		} else {
			newList = panier.getLignesCommande();
			int i = newList.size();
			lc.setId(i);
		}
		newList.add(lc);
		panier.setLignesCommande(newList);
		p_rec.setQuantite(p_rec.getQuantite()-quantite);
		modifierProduit(p_rec);
		return panier ;
	}
	
	public Panier ajouterAuPanierPlus(Panier panier, int index) {
		int quantite = panier.getLignesCommande().get(index).getQuantite();
		panier.getLignesCommande().get(index).setQuantite(quantite+1);
		Produit p_rec = panier.getLignesCommande().get(index).getProduit();
		p_rec.setQuantite(p_rec.getQuantite()-1);
		modifierProduit(p_rec);
		return panier ;
	}

	@Override
	public List<Produit> getByKeyWord(String mot) {
		Session s=sf.getCurrentSession();
		String rec="from Produit p where p.designation LIKE :pDes or p.description LIKE :pDes";
		Query query=s.createQuery(rec);
		query.setParameter("pDes", '%'+mot+'%');
		
		return query.list();
	}

}
