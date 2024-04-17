package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cauhoi_DeThi {
	@Id
	@GeneratedValue
	private double id;
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Cauhoi")
	private Cauhoi cauhoi;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DeThi")
	private DeThi deThi;

	public Cauhoi getCauhoi() {
		return cauhoi;
	}
	public void setCauhoi(Cauhoi cauhoi) {
		this.cauhoi = cauhoi;
	}
	public DeThi getDeThi() {
		return deThi;
	}
	public void setDeThi(DeThi deThi) {
		this.deThi = deThi;
	}
	/**
	 * @param id
	 * @param cauhoi
	 * @param deThi
	 */
	public Cauhoi_DeThi(Cauhoi cauhoi, DeThi deThi) {
		super();
		this.cauhoi = cauhoi;
		this.deThi = deThi;
	}


}
