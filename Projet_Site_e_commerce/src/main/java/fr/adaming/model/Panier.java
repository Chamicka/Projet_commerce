package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paniers")
public class Panier implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pa")
	private long id ;
	
	@OneToMany
	private List<LigneCommande> lignesCommande ;

	/**
	 * 
	 */
	public Panier() {
		super();
	}

	/**
	 * @param lignesCommande
	 */
	public Panier(List<LigneCommande> lignesCommande) {
		super();
		this.lignesCommande = lignesCommande;
	}

	/**
	 * @param id
	 * @param lignesCommande
	 */
	public Panier(long id, List<LigneCommande> lignesCommande) {
		super();
		this.id = id;
		this.lignesCommande = lignesCommande;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the lignesCommande
	 */
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	/**
	 * @param lignesCommande the lignesCommande to set
	 */
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Panier [id=" + id + ", lignesCommande=" + lignesCommande + "]";
	}
	
	
	
}
