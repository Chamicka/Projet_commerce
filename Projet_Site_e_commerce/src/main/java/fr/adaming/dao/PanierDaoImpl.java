package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

@Repository
public class PanierDaoImpl implements IPanierDao{

	@Autowired
	private SessionFactory sf;
	
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public int calculerTotal(Panier p) {
		int total = 0 ;
		List<LigneCommande> lignes = new ArrayList<LigneCommande>();
		if (p.getLignesCommande() == null) {
		} else {
			lignes = p.getLignesCommande() ;
			for (int i=0; i<p.getLignesCommande().size(); i++) {
				total = total + lignes.get(i).getPrix() ; 
			}
		}
		return total;
		
	}

}