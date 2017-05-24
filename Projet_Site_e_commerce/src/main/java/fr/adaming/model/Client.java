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
@Table(name="clients")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private Long id ;
	private String nom ;
	private String adresse ;
	private String mail ;
	private String tel ;
	
	@OneToMany(mappedBy="client")
	private List<Commande> listeCommandes ;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param nom
	 * @param adresse
	 * @param mail
	 * @param tel
	 * @param listeCommandes
	 */
	public Client(String nom, String adresse, String mail, String tel, List<Commande> listeCommandes) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
		this.listeCommandes = listeCommandes;
	}

	/**
	 * @param id
	 * @param nom
	 * @param adresse
	 * @param mail
	 * @param tel
	 * @param listeCommandes
	 */
	public Client(Long id, String nom, String adresse, String mail, String tel, List<Commande> listeCommandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
		this.listeCommandes = listeCommandes;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the listeCommandes
	 */
	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	/**
	 * @param listeCommandes the listeCommandes to set
	 */
	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + ", tel=" + tel + "]";
	}
	
	
}
