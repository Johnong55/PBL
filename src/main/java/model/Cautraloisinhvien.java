package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cautraloisinhvien {
	@Id
	private String id;
	private int cauhoiso;
	private String cautraloi;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private BaiLam bailamsv ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCauhoiso() {
		return cauhoiso;
	}

	public void setCauhoiso(int cauhoiso) {
		this.cauhoiso = cauhoiso;
		this.id   =  bailamsv.getMaBailam()+cauhoiso;
	}

	public String getCautraloi() {
		return cautraloi;
	}

	public void setCautraloi(String cautraloi) {
		this.cautraloi = cautraloi;
	}

	public BaiLam getBailamsv() {
		return bailamsv;
	}

	public void setBailamsv(BaiLam bailamsv) {
		this.bailamsv = bailamsv;
	}

	/**
	 * @param id
	 * @param cauhoiso
	 * @param cautraloi
	 * @param bailamsv
	 */
	public Cautraloisinhvien(String id, int cauhoiso, String cautraloi, BaiLam bailamsv) {
		super();
		this.id = id;
		this.cauhoiso = cauhoiso;
		this.cautraloi = cautraloi;
		this.bailamsv = bailamsv;
	}

	/**
	 * 
	 */
	public Cautraloisinhvien() {
		super();
		
	}
	
	
	
}
