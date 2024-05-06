package model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class request {
	
	@Id
	private String id;
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	private Date time;
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = account.getId()+time;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @param id
	 * @param account
	 * @param time
	 */
	public request(String id, Account account, Date time) {
		super();
		this.id = id;
		this.account = account;
		this.time = time;
	}
	/**
	 * 
	 */
	public request() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "request [id=" + id + ", account=" + account + ", time=" + time + "]";
	}
}
