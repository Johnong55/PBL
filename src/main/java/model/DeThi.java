	package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DeThi {
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name = "kithi")	
	private KiThi kithi;
	private String mota;
	@OneToMany(mappedBy = "deThi",cascade = CascadeType.ALL)
	private List<Cauhoi_DeThi> list;
	@OneToMany(mappedBy = "dethi",cascade = CascadeType.ALL)
	private List<BaiLam> bailam;
	public List<BaiLam> getBailam() {
		return bailam;
	}
	public void setBailam(List<BaiLam> bailam) {
		this.bailam = bailam;
	}
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
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public List<Cauhoi> getList() {
		 List<Cauhoi> cauhoi =  new ArrayList<Cauhoi>();
		for(Cauhoi_DeThi i : list)
		{
			cauhoi.add(i.getCauhoi());
		}
		return cauhoi;
	}
	public void setList(List<Cauhoi_DeThi> list) {
		this.list = list;
	}
	/**
	 * 
	 */
	public DeThi() {
		super();
		list= new ArrayList<Cauhoi_DeThi>();
		// TODO Auto-generated constructor stub
	}
	public void addCauhoi(Cauhoi t)
	{
		this.list.add(new Cauhoi_DeThi(t, this));
	}
	@Override
	public String toString() {
		return "DeThi [id=" + id + ", kithi=" + kithi + ", mota=" + mota + ", list=" + list + "]";
	}
	public void addBailam(BaiLam t)
	{
		this.bailam.add(t);
	}
	
}
