package fr.adaming.model;

import java.util.Date;
import java.util.List;

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
@Table(name="commandes")
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_co")
	private Long id;
	@Column(name="date_co")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_cl")
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> listeLigneCommandes;
	
	public Commande() {
		super();
	}

	public Commande(Date date) {
		super();
		this.date = date;
	}

	public Commande(Long id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommandes;
	}

	public void setListeLigneCommande(List<LigneCommande> listeLigneCommandes) {
		this.listeLigneCommandes = listeLigneCommandes;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + "]";
	}
	
	
	
}
