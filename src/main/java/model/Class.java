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

@Entity
public class Class {
	@Id
	private String idclass;
	private String tenlop;
	@OneToMany(mappedBy = "lop",cascade = CascadeType.ALL)
	private List<KiThi> kithi;
	@OneToMany(mappedBy = "idclass", cascade = CascadeType.ALL)
	private List<Sv> Svs;
	@OneToMany(mappedBy = "malop", cascade = CascadeType.ALL)
	private List<Giangday> danhsachgiaovien =  new ArrayList<Giangday>();
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "truong")
	private truonghoc truong;
	private int soluong;
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	/**
	 * @param idclass
	 * @param tenlop
	 * @param svs
	 * @param danhsachgiaovien
	 * @param truong
	 */
	public Class(String idclass, String tenlop, List<Sv> svs, List<Giangday> danhsachgiaovien, truonghoc truong) {
		super();
		this.idclass = idclass;
		this.tenlop = tenlop;
		Svs = svs;
		this.danhsachgiaovien = danhsachgiaovien;
		this.truong = truong;
	}
	@Override
	public String toString() {
		return "Class [idclass=" + idclass + ", tenlop=" + tenlop + ", Svs=" + Svs + ", danhsachgiaovien="
				+ danhsachgiaovien + ", truong=" + truong + "]";
	}
	public truonghoc getTruong() {
		return truong;
	}
	public void setTruong(truonghoc truong) {
		this.truong = truong;
	}
	public String getIdclass() {
		return idclass;
	}
	public void setIdclass(String idclass) {
		this.idclass = idclass;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public List<Sv> getSvs() {
		if(Svs==null) {
			return new ArrayList<Sv>();
		}
		return Svs;
	}
	public void setSvs(List<Sv> svs) {
		Svs = svs;
	}
	public List<Giangday> getDanhsachgiaovien() {
		return danhsachgiaovien;
	}	

	public void setDanhsachgiaovien(List<Giangday> danhsachgiaovien) {
		this.danhsachgiaovien = danhsachgiaovien;
	}
	/**
	 * @param idclass
	 * @param tenlop
	 * @param truong
	 */
	public Class(String idclass, String tenlop, truonghoc truong) {
		super();
		this.idclass = idclass;
		this.tenlop = tenlop;
		this.truong = truong;
	}
	public Class() {
	super();
	}
	public List<KiThi> getKithi() {
		return kithi;
	}
	public void setKithi(List<KiThi> kithi) {
		this.kithi = kithi;
	}
	public void addGv(Gv t)
	{
		this.danhsachgiaovien.add(new Giangday(t,this));
	}
}
