package model;

import java.sql.Date;
import java.sql.Time;
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
public class KiThi {
	@Override
	public String toString() {
		return "KiThi [id=" + id + ", lop=" + lop +",thoi gian bat dau = " + thoigianbatdau
				+ ", thoigianlambai=" + thoigianlambai + ", mota=" + mota + ", date="
				+ date + ", gv=" + gv.id + ", sl=" + sl + "]";
	}
	@Id
	private String id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lop")
	private	Class lop; 
	private Time thoigianbatdau;
	private int thoigianlambai;
	private String mota;
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nguoitao")
	private Gv gv;
	private int sl;
	@OneToMany(mappedBy = "kithi")
	private List<DeThi> listdethi;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nganhangcauhoi")
	private Nganhangcauhoi nganhangcauhoi;
	@OneToMany(mappedBy = "kithi")
	private List<BaiLam> bailam;
	
	private int socauDe;
	private int socaukho;
	private int socautb;
	
	public int getSocauDe() {
		return socauDe;
	}
	public void setSocauDe(int socauDe) {
		this.socauDe = socauDe;
	}
	public int getSocaukho() {
		return socaukho;
	}
	public void setSocaukho(int socaukho) {
		this.socaukho = socaukho;
	}
	public int getSocautb() {
		return socautb;
	}
	public void setSocautb(int socautb) {
		this.socautb = socautb;
	}
	public List<BaiLam> getBailam() {
		return bailam;
	}
	public void setBailam(List<BaiLam> bailam) {
		this.bailam = bailam;
	}
	/**
	 * @param id
	 * @param lop
	 * @param thoigianlambai
	 * @param mota
	 * @param date
	 * @param gv
	 * @param sl
	 * @param listdethi
	 * @param nganhangcauhoi
	 */
	public KiThi(String id, Class lop,Time thoigianbatdau, int thoigianlambai, String mota, Date date, Gv gv, int sl, 
			Nganhangcauhoi nganhangcauhoi) {
		super();
		this.id = id;
		this.lop = lop;
		this.thoigianbatdau = thoigianbatdau;
		this.thoigianlambai = thoigianlambai;
		this.mota = mota;
		this.date = date;
		this.gv = gv;
		this.sl = sl;
		this.nganhangcauhoi = nganhangcauhoi;
	}
	public Time getThoigianbatdau() {
		return thoigianbatdau;
	}
	public void setThoigianbatdau(Time thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}
	public Nganhangcauhoi getNganhangcauhoi() {
		return nganhangcauhoi;
	}
	public void setNganhangcauhoi(Nganhangcauhoi nganhangcauhoi) {
		this.nganhangcauhoi = nganhangcauhoi;
	}
	public List<DeThi> getListdethi() {
		return listdethi;
	}
	public void setListdethi(List<DeThi> listdethi) {
		this.listdethi = listdethi;
	}
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
	public KiThi(String id, Class lop,Time thoigianbatdau , int thoigianlambai, String mota, Date date, Gv gv, int sl) {
		super();
		this.id = id;
		this.lop = lop;
		this.thoigianbatdau = thoigianbatdau;
		this.thoigianlambai = thoigianlambai;
		this.mota = mota;
		this.date = date;
		this.gv = gv;
		this.sl = sl;
	}
	/**
	 * 
	 */
	public void add_dethi(DeThi t)
	{
		this.listdethi.add(t);
	}
	public KiThi() {
		super();
		long now  = System.currentTimeMillis();
		thoigianbatdau = new Time(now);
		// TODO Auto-generated constructor stub
	}
	public void add_bailam(BaiLam t)
	{
		this.bailam.add(t);
	}
	
}
