package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produits")
public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pr")
	private Long id ;
	private String designation ;
	private String description ;
	private double prix ;
	private int quantite ;
	private boolean selectionne ;
	private String photo ;
	
	
	@ManyToOne
	@JoinColumn(name="categorie_id", referencedColumnName="id_ca")
	private Categorie categorie ;

	/**
	 * 
	 */
	public Produit() {
		super();
	}

	/**
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 * @param photo
	 * @param categorie
	 */
	public Produit(String designation, String description, double prix, int quantite, boolean selectionne, String photo,
			Categorie categorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
		this.categorie = categorie;
	}

	/**
	 * @param id
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 * @param photo
	 * @param categorie
	 */
	public Produit(Long id, String designation, String description, double prix, int quantite, boolean selectionne,
			String photo, Categorie categorie) {
		super();
		this.id = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
		this.categorie = categorie;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the selectionne
	 */
	public boolean isSelectionne() {
		return selectionne;
	}

	/**
	 * @param selectionne the selectionne to set
	 */
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", description=" + description + ", prix=" + prix
				+ ", quantite=" + quantite + ", selectionne=" + selectionne + ", photo=" + photo + ", categorie="
				+ categorie + "]";
	}
	
	


	
	
	
}
