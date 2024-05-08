package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	@Id
	public String id;
	public String username;
	public String password;
	public int maquyen;
	public String linkAnh;
	@OneToOne(mappedBy = "account")
	private request request;
	public request getRequest() {
		return request;
	}
	public void setRequest(request request) {
		this.request = request;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", maquyen=" + maquyen
				+ ", linkAnh=" + linkAnh + ", request=" + request + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaquyen() {
		return maquyen;
	}
	public void setMaquyen(int maquyen) {
		this.maquyen = maquyen;
	}
	public String getLinkAnh() {
		return linkAnh;
	}
	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param maquyen
	 * @param linkAnh
	 * @param gv
	 * @param sv
	 */
	public Account(String id, String username, String password, int maquyen, String linkAnh) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.maquyen = maquyen;
		this.linkAnh = linkAnh;
	
	}
	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
