package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sv extends Account{

	private String ten;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lop")
	private Class idclass; 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sv")
	private List<BaiLam> list;
	public Sv() {
		super();
		list = new ArrayList<BaiLam>();;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sv [idSv=" + id+ ", ten=" + ten + ", idclass=" + idclass.getIdclass() + "]";
	}
	public Sv(String idSv, String ten, Class idclass) {
		super();
		this.id = idSv;
		this.ten = ten;
		this.idclass = idclass;
	}
	public String getIdSv() {
		return id;
	}
	public void setIdSv(String idSv) {
		this.id = idSv;
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
	public void addKetqua(BaiLam t)
	{
		this.list.add(t);
	}
	public List<BaiLam> getList() {
		return list;
	}
	public void setList(List<BaiLam> list) {
		this.list = list;
	}
}
