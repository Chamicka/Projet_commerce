package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_r")
	private int id ;
	private String rolename ;
	
	@ManyToOne
	@JoinColumn(name="admin_id", referencedColumnName="id_ad")
	private Admin admin ;
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_cl")
	private Client client ;
	

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param rolename
	 * @param admin
	 */
	public Role(String rolename, Admin admin) {
		super();
		this.rolename = rolename;
		this.admin = admin;
	}

	/**
	 * @param id
	 * @param rolename
	 * @param admin
	 */
	public Role(int id, String rolename, Admin admin) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.admin = admin;
	}

	
	/**
	 * @param id
	 * @param rolename
	 * @param admin
	 * @param client
	 */
	public Role(int id, String rolename, Admin admin, Client client) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.admin = admin;
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", admin=" + admin + "]";
	}
	
	
}
