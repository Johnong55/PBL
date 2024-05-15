package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Nganhangcauhoi {
	@Id
	private String idNganHang;
	private int soluong;
	@ManyToOne
	@JoinColumn(name = "giaovienquanli")
	private Gv giaovienquanli;
	@OneToMany(mappedBy = "nganhangcauhoi")
	private List<KiThi> kithi;
	public List<KiThi> getKithi() {
		return kithi;
	}

	public void setKithi(List<KiThi> kithi) {
		this.kithi = kithi;
	}
	@OneToMany(mappedBy = "NH")
	private List<Cauhoi> listcauhoi = new ArrayList<Cauhoi>();
	public List<Cauhoi> getListcauhoi() {
		return listcauhoi;
	}
	
	public void setListcauhoi(List<Cauhoi> listcauhoi) {
		this.listcauhoi = listcauhoi;
	}
	public void addcauhoi(Cauhoi c)
	{
		this.listcauhoi.add(c);
		this.soluong++;
	}
	/**
	 * 
	 */
	public Nganhangcauhoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idNganHang
	 * @param soluong
	 * @param giaovienquanli
	 */
	public Nganhangcauhoi(String idNganHang, int soluong, Gv giaovienquanli) {
		super();
		this.idNganHang = idNganHang;
		this.soluong = soluong;
		this.giaovienquanli = giaovienquanli;
	}
	public String getIdNganHang() {
		return idNganHang;
	}
	public void setIdNganHang(String idNganHang) {
		this.idNganHang = idNganHang;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Gv getGiaovienquanli() {
		return giaovienquanli;
	}
	public void setGiaovienquanli(Gv giaovienquanli) {
		this.giaovienquanli = giaovienquanli;
	}
	public void addkithi(KiThi t)
	{
		this.kithi.add(t);
	}

	@Override
	public String toString() {
		return "Nganhangcauhoi [idNganHang=" + idNganHang + ", soluong=" + soluong + ", giaovienquanli="
				+ giaovienquanli + ", kithi=" + kithi + "]";
	}




}
