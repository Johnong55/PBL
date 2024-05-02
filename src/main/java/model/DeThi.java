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
import javax.persistence.OneToOne;

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
	@OneToOne(mappedBy = "dethi")
	private BaiLam bailam;
	
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
		
		 List<Cauhoi> cauhoi =  new ArrayList<Cauhoi>();
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
	public void addlistcauhoi(List<Cauhoi> t)
	{
		this.list = new ArrayList<Cauhoi_DeThi>();
		for(Cauhoi i : t)
		{
			this.list.add(new Cauhoi_DeThi(i, this));
		}
	}
	@Override
	public String toString() {
		return "DeThi [id=" + id + ", kithi=" + kithi + ", mota=" + mota + ", list=" + list + "]";
	}
	public BaiLam getBailam() {
		return bailam;
	}
	public void setBailam(BaiLam bailam) {
		this.bailam = bailam;
	}
	public List<Cauhoi> listcauhoi()
	{
		List<Cauhoi> result = new ArrayList<Cauhoi>();
		for(Cauhoi_DeThi i : list)
		{
			result.add(i.getCauhoi());
		}
		
		return result;
		
	}
	
}
