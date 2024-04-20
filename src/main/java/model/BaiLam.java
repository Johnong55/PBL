package model;

import java.sql.Date;
import java.sql.Time;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BaiLam{
	@Id 
	private String maBailam;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Sv")
	private Sv sv;
	//private Map<Cauhoi, Integer> CautraloiCuaSV;
	private double diem;
	private Time thoigianbatdau;
	private Time thoigianketthuc;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private DeThi dethi;
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

	/*
	 * public Map<Cauhoi, Integer> getCautraloiCuaSV() { return CautraloiCuaSV; }
	 * public void setCautraloiCuaSV(Map<Cauhoi, Integer> cautraloiCuaSV) {
	 * CautraloiCuaSV = cautraloiCuaSV; }
	 */
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
	/**
	 * @param maBailam
	 * @param sv
	 * @param cautraloiCuaSV
	 * @param diem
	 * @param thoigianbatdau
	 * @param thoigianketthuc
	 * @param dethi
	 */
	public BaiLam(String maBailam, Sv sv,  double diem, Time thoigianbatdau,
			Time thoigianketthuc, DeThi dethi) {
		super();
		this.maBailam = maBailam;
		this.sv = sv;
		//CautraloiCuaSV = cautraloiCuaSV;
		this.diem = diem;
		this.thoigianbatdau = thoigianbatdau;
		this.thoigianketthuc = thoigianketthuc;
		this.dethi = dethi;
	}
	/**
	 * 
	 */
	public BaiLam() {
		super();
		// TODO Auto-generated constructor stub
	}

}
