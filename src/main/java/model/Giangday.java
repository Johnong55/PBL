package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Giangday {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "giaoviendunglop")
	Gv maGv;
	
	@ManyToOne
	@JoinColumn(name = "lop")
	Class  malop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Giangday(Gv maGv, Class malop) {
		super();
		this.maGv = maGv;
		this.malop = malop;
	}

	public Giangday() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}