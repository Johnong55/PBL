package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DeThi {
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name = "kithi")	
	private KiThi kithi;
	private String mota;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public KiThi getKithi() {
		return kithi;
	}
	public void setKithi(KiThi kithi) {
		this.kithi = kithi;
	}
	/**
	 * @param id
	 * @param kithi
	 */
	public DeThi(String id, KiThi kithi) {
		super();
		this.id = id;
		this.kithi = kithi;
	}
	/**
	 * 
	 */
	public DeThi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
