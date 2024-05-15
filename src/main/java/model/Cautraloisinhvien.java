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
	@ManyToOne
	private Cauhoi cauhoi;
	private String cautraloi;
	
	@ManyToOne
	@JoinColumn(name = "bailam")
	private BaiLam bailamsv ;
	private int kiemtra;
	
	public int getKiemtra() {
		return kiemtra;
	}

	public void setKiemtra() {
	
		if(this.cauhoi.getDapan().equals(cautraloi))
		{
			
			kiemtra = 1;
		}
		else {
			kiemtra = 0;
		}
		System.out.println("kiem tra "+kiemtra);
	}

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
		this.setId(this.bailamsv.getMaBailam()+this.cauhoi.getId());
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
		cautraloi="";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cautraloisinhvien [id=" + id + ", cauhoi=" + cauhoi + ", cautraloi=" + cautraloi + ", bailamsv="
				+ bailamsv + "]";
	}

	
	
	
	
}
