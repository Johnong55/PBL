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
public class Gv extends Account{		
	
	private String ten;
	@OneToMany(mappedBy = "maGv", cascade = CascadeType.ALL)
	private List<Giangday> danhsachlop ;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "truong")
	private truonghoc truong;
	@OneToMany(mappedBy = "giaovienquanli", cascade = CascadeType.ALL)
	private List<Nganhangcauhoi> NH;
	@OneToMany(mappedBy = "gv", cascade = CascadeType.ALL)
	private List<KiThi> kithi;
	public List<KiThi> getKithi() {
		return kithi;
	}

	public void setKithi(List<KiThi> kithi) {
		this.kithi = kithi;
	}

	public List<Nganhangcauhoi> getNH() {
		return NH;
	}

	public void setNH(List<Nganhangcauhoi> nH) {
		NH = nH;
	}

	public String getMaGv() {
		return id;
	}
	
	/**
	 * @param maGv
	 * @param ten
	 * @param danhsachlop
	 * @param truong
	 */
	public Gv(String maGv, String ten, List<Giangday> danhsachlop, truonghoc truong) {
		super();
		this.id = maGv;
		this.ten = ten;
		this.danhsachlop = danhsachlop;
		this.truong = truong;
	}
	public truonghoc getTruong() {
		return truong;
	}
	public void setTruong(truonghoc truong) {
		this.truong = truong;
	}
	@Override
	public String toString() {
		return "Gv [maGv=" + id + ", ten=" + ten + ", danhsachlop=" + danhsachlop + ", truong=" + truong + ", NH="
				+ NH + "]";
	}

	public void setMaGv(String maGv) {
		this.id = maGv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public List<Giangday> getDanhsachlop() {
		return danhsachlop;
	}
	public void setDanhsachlop(List<Giangday> danhsachlop) {
		this.danhsachlop = danhsachlop;
	}
	public Gv() {
		super();
		// TODO Auto-generated constructor stub
		this.danhsachlop  =new ArrayList<Giangday>();
	}
	public Gv(String id, String ten2, truonghoc truong1) {
		// TODO Auto-generated constructor stub
	}
	public void addclass(Class t)
	{
		
		danhsachlop.add(new Giangday(this,t));
	}
	
}
