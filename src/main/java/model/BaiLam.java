package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import DAO.DeThi_dao;

@Entity
public class BaiLam{
	@Id 
	private String maBailam;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Sv")
	private Sv sv;	
	private double diem;
	private Time thoigianbatdau;
	private Time thoigianketthuc;
	@OneToOne(cascade = CascadeType.ALL)
	private DeThi dethi;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private KiThi kithi;
	@OneToMany( mappedBy = "bailamsv",	cascade = CascadeType.ALL)
	private List<Cautraloisinhvien> cautraloi;
	
	public List<Cautraloisinhvien> getCautraloi() {
		return cautraloi;
	}
	public void setCautraloi(List<Cautraloisinhvien> cautraloi) {
		this.cautraloi = cautraloi;
	}
	public String getMaBailam() {
		return maBailam;
	}
	public void setMaBailam(String maBailam) {
		this.maBailam = maBailam;
	}
	public Sv getSv() {
		return sv;
	}
	public void setSv(Sv sv) {
		this.sv = sv;
	}
	
	
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	public Time getThoigianbatdau() {
		return thoigianbatdau;
	}
	public void setThoigianbatdau(Time thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}
	public Time getThoigianketthuc() {
		return thoigianketthuc;
	}
	public void setThoigianketthuc(Time thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}
	public DeThi getDethi() {
		return dethi;
	}
	public void setDethi(DeThi dethi) {
		this.dethi = dethi;
	}
	public KiThi getKiThi() {
		return kithi;
	}
	public void setKiThi(KiThi kiThi) {
		this.kithi = kiThi;
	}
	/**
	 * @param maBailam
	 * @param sv
	 * @param cautraloiCuaSV
	 * @param diem
	 * @param thoigianbatdau
	 * @param thoigianketthuc
	 * @param dethi
	 * @param kiThi
	 */
	
	/**
	 * 
	 */
	public BaiLam() {
		super();
		this.cautraloi= new ArrayList<Cautraloisinhvien>();
		
		// TODO Auto-generated constructor stub
	}
	public void createbailam()
	{
		
		this.maBailam = this.sv.getId()+this.kithi.getId();
		this.dethi = new DeThi(maBailam, kithi );
		this.dethi.setMota("Hoàn thành");
		dethi.addlistcauhoi(DeThi_dao.Instance().Xaydungdethi(kithi));


	}
	public void addCautraloi(Cautraloisinhvien cautraloi) {
		this.cautraloi.add(cautraloi);
	}
}
