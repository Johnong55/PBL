package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Nganhangcauhoi {
	@Id
	private String idNganHang;
	private int soluong;
	@ManyToOne
	@JoinColumn(name = "giaovienquanli")
	private Gv giaovienquanli;
	@OneToMany(mappedBy = "NH")
	private List<Cauhoi> listcauhoi;
	public List<Cauhoi> getListcauhoi() {
		return listcauhoi;
	}
	public void setListcauhoi(List<Cauhoi> listcauhoi) {
		this.listcauhoi = listcauhoi;
	}
	public void addcauhoi(Cauhoi c)
	{
		this.listcauhoi.add(c);
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





}
