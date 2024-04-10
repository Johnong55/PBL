package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Gv{		
	@Id
	private String maGv;
	private String ten;
	@OneToMany(mappedBy = "maGv", cascade = CascadeType.ALL)
	private List<Giangday> danhsachlop;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "truong")
	private truonghoc truong;
	@OneToMany(mappedBy = "giaovienquanli", cascade = CascadeType.ALL)
	private List<Nganhangcauhoi> NH;
	public List<Nganhangcauhoi> getNH() {
		return NH;
	}

	public void setNH(List<Nganhangcauhoi> nH) {
		NH = nH;
	}

	public String getMaGv() {
		return maGv;
	}
	
	/**
	 * @param maGv
	 * @param ten
	 * @param danhsachlop
	 * @param truong
	 */
	public Gv(String maGv, String ten, List<Giangday> danhsachlop, truonghoc truong) {
		super();
		this.maGv = maGv;
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
		return "Gv [maGv=" + maGv + ", ten=" + ten + ", danhsachlop=" + danhsachlop + ", truong=" + truong.getId() + ", NH="
				+ NH + "]";
	}

	public void setMaGv(String maGv) {
		this.maGv = maGv;
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
	}
	public Gv(String id, String ten2, truonghoc truong1) {
		// TODO Auto-generated constructor stub
	}
	
}
