package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cautraloisinhvien {
	@Id
	private String id ;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cauhoi cauhoi;
	private String cautraloi;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bailam")
	private BaiLam bailamsv ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cauhoi getCauhoi() {
		return cauhoi;
	}

	public void setCauhoi(Cauhoi cauhoi) {
		this.cauhoi = cauhoi;
	}

	public String getCautraloi() {
		return cautraloi;
	}

	public void setCautraloi(String cautraloi) {
		this.setId(this.bailamsv.getMaBailam()+this.cauhoi.getId());
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
	 * @param cauhoi
	 * @param cautraloi
	 * @param bailamsv
	 */
	public Cautraloisinhvien(String id, Cauhoi cauhoi, String cautraloi, BaiLam bailamsv) {
		
		super();
		this.setId(this.bailamsv.getMaBailam()+this.cauhoi.getId());
		this.cauhoi = cauhoi;
		this.cautraloi = cautraloi;
		this.bailamsv = bailamsv;
	}

	/**
	 * 
	 */
	public Cautraloisinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cautraloisinhvien [id=" + id + ", cauhoi=" + cauhoi + ", cautraloi=" + cautraloi + ", bailamsv="
				+ bailamsv + "]";
	}

	
	
	
	
}
