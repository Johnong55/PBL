package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class KiThi {
	@Id
	private String id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lop")
	private	Class lop; 
	private int thoigianlambai;
	private String mota;
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nguoitao")
	private Gv gv;
	private int sl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Class getLop() {
		return lop;
	}
	public void setLop(Class lop) {
		this.lop = lop;
	}
	public int getThoigianlambai() {
		return thoigianlambai;
	}
	public void setThoigianlambai(int thoigianlambai) {
		this.thoigianlambai = thoigianlambai;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Gv getGv() {
		return gv;
	}
	public void setGv(Gv gv) {
		this.gv = gv;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	/**
	 * @param id
	 * @param lop
	 * @param thoigianlambai
	 * @param mota
	 * @param date
	 * @param gv
	 * @param sl
	 */
	public KiThi(String id, Class lop, int thoigianlambai, String mota, Date date, Gv gv, int sl) {
		super();
		this.id = id;
		this.lop = lop;
		this.thoigianlambai = thoigianlambai;
		this.mota = mota;
		this.date = date;
		this.gv = gv;
		this.sl = sl;
	}
	/**
	 * 
	 */
	public KiThi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
