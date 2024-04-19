package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cauhoi {
	@Id
	private String id ;
	private String Noidung;
	private	String dapAnA;
	private	String dapAnB;
	private	String dapAnC;
	private	String dapAnD;
	private int mucdo;
	private int dapan;
	@ManyToOne
	@JoinColumn(name = "NganHang")	
	private Nganhangcauhoi NH;
	@OneToMany(mappedBy = "cauhoi",cascade = CascadeType.ALL)
	private List<Cauhoi_DeThi> CD;
	public List<Cauhoi_DeThi> getCD() {
		return CD;
	}
	public void setCD(List<Cauhoi_DeThi> cD) {
		CD = cD;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNoidung() {
		return Noidung;
	}
	public void setNoidung(String noidung) {
		Noidung = noidung;
	}
	public String getDapAnA() {
		return dapAnA;
	}
	public void setDapAnA(String dapAnA) {
		this.dapAnA = dapAnA;
	}
	public String getDapAnB() {
		return dapAnB;
	}
	public void setDapAnB(String dapAnB) {
		this.dapAnB = dapAnB;
	}
	public String getDapAnC() {
		return dapAnC;
	}
	public void setDapAnC(String dapAnC) {
		this.dapAnC = dapAnC;
	}
	public String getDapAnD() {
		return dapAnD;
	}
	public void setDapAnD(String dapAnD) {
		this.dapAnD = dapAnD;
	}
	public int getMucdo() {
		return mucdo;
	}
	public void setMucdo(int mucdo) {
		this.mucdo = mucdo;
	}
	public int getDapan() {
		return dapan;
	}
	public void setDapan(int dapan) {
		this.dapan = dapan;
	}
	public Nganhangcauhoi getNH() {
		return NH;
	}
	public void setNH(Nganhangcauhoi nH) {
		NH = nH;
	}
	/**
	 * 
	 */
	public Cauhoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param noidung
	 * @param dapAnA
	 * @param dapAnB
	 * @param dapAnC
	 * @param dapAnD
	 * @param mucdo
	 * @param dapan
	 * @param nH
	 */
	public Cauhoi(String id, String noidung, String dapAnA, String dapAnB, String dapAnC, String dapAnD, int mucdo,
			int dapan, Nganhangcauhoi nH) {
		super();
		this.id = id;
		Noidung = noidung;
		this.dapAnA = dapAnA;
		this.dapAnB = dapAnB;
		this.dapAnC = dapAnC;
		this.dapAnD = dapAnD;
		this.mucdo = mucdo;
		this.dapan = dapan;
		NH = nH;
	}
	public void addVaoDeThi(DeThi T)
	{
		this.CD.add(new Cauhoi_DeThi(this, T));
	}
}
