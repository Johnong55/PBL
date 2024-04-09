package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Giangday {
	@Id
	private String id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "giaoviendunglop")
	Gv maGv;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lop")
	Class  malop;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Gv getMaGv() {
		return maGv;
	}

	public void setMaGv(Gv maGv) {
		this.maGv = maGv;
	}

	public Class getMalop() {
		return malop;
	}

	public void setMalop(Class malop) {
		this.malop = malop;
	}

	public Giangday(String id, Gv maGv, Class malop) {
		super();
		this.id = id;
		this.maGv = maGv;
		this.malop = malop;
	}

	public Giangday() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}