package model;

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
public class BaiLam extends DeThi {
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "Sv") private Sv sv; private Map<Cauhoi, Integer>
	 * CautraloiCuaSV; private Time thoigianbatdau; public Sv getSv() { return sv; }
	 * public void setSv(Sv sv) { this.sv = sv; } public Map<Cauhoi, Integer>
	 * getCautraloiCuaSV() { return CautraloiCuaSV; } public void
	 * setCautraloiCuaSV(Map<Cauhoi, Integer> cautraloiCuaSV) { CautraloiCuaSV =
	 * cautraloiCuaSV; } public Time getThoigianbatdau() { return thoigianbatdau; }
	 * public void setThoigianbatdau(Time thoigianbatdau) { this.thoigianbatdau =
	 * thoigianbatdau; }
	 *//**
		* 
		*/
	/*
	 * public BaiLam() { super(); long now = System.currentTimeMillis();
	 * this.thoigianbatdau = new Time(now); }
	 *//**
		 * @param id
		 * @param kithi
		 */
	/*
	*//**
		 * @param id
		 * @param kithi
		 * @param sv
		 * @param cautraloiCuaSV
		 * @param thoigianbatdau
		 *//*
			 * public BaiLam(String id, KiThi kithi, Sv sv, Map<Cauhoi, Integer>
			 * cautraloiCuaSV, Time thoigianbatdau) { super(id, kithi); this.sv = sv;
			 * CautraloiCuaSV = cautraloiCuaSV; this.thoigianbatdau = thoigianbatdau; }
			 * public void addcautraloi() {
			 * 
			 * }
			 */

}
