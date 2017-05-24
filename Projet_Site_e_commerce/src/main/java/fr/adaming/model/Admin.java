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
@Table(name="admins")
public class Admin implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ad")
	private int id ;
	private String username ;
	private String password ;
	private boolean activated ;
	
	@OneToMany(mappedBy="admin")
	private List<Role> roles ;

	/**
	 * 
	 */
	public Admin() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 * @param activated
	 * @param roles
	 */
	public Admin(String username, String password, boolean activated, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.activated = activated;
		this.roles = roles;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param activated
	 * @param roles
	 */
	public Admin(int id, String username, String password, boolean activated, List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.activated = activated;
		this.roles = roles;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", activated=" + activated
				+ "]";
	}
	
	
	
}
