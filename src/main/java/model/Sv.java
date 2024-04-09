package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sv {
	@Id
	private String idSv;
	private String ten;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lop")
	private Class idclass; 
	public Sv() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sv [idSv=" + idSv + ", ten=" + ten + ", idclass=" + idclass + "]";
	}
	public Sv(String idSv, String ten, Class idclass) {
		super();
		this.idSv = idSv;
		this.ten = ten;
		this.idclass = idclass;
	}
	public String getIdSv() {
		return idSv;
	}
	public void setIdSv(String idSv) {
		this.idSv = idSv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Class getIdclass() {
		return idclass;
	}
	public void setIdclass(Class idclass) {
		this.idclass = idclass;
	} 
}
