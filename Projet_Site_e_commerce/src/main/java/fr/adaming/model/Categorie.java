package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ca")
	private Long id;
	@Column(name="nom_ca")
	private String nom;
	@Lob
	private String photo;
	private String description;
	
	@OneToMany(mappedBy="categorie", cascade=CascadeType.REMOVE)
	private List<Produit> listeProduits;
	
	public Categorie() {
		super();
	}

	public Categorie(String nom, String photo, String description) {
		super();
		this.nom = nom;
		this.photo = photo;
		this.description = description;
	}

	public Categorie(Long id, String nom, String photo, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.photo = photo;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", photo=" + photo + ", description="
				+ description + "]";
	}
	
	
	
	
}
