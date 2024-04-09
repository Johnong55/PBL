package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class truonghoc {
	@Id
	String id;
	String tentruong;
	@OneToMany(mappedBy = "truong")
	List<Gv> danhsachgiaovien;
	@OneToMany(mappedBy = "truong")
	List<Class> danhsachclop;
	/**
	 * 
	 */
	public truonghoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param tentruong
	 * @param danhsachgiaovien
	 * @param danhsachclop
	 */
	public truonghoc(String id, String tentruong, List<Gv> danhsachgiaovien, List<Class> danhsachclop) {
		super();
		this.id = id;
		this.tentruong = tentruong;
		this.danhsachgiaovien = danhsachgiaovien;
		this.danhsachclop = danhsachclop;
	}
	public String getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public truonghoc(String id) {
		super();
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getTentruong() {
		return tentruong;
	}
	public void setTentruong(String tentruong) {
		this.tentruong = tentruong;
	}
	public List<Gv> getDanhsachgiaovien() {
		return danhsachgiaovien;
	}
	public void setDanhsachgiaovien(List<Gv> danhsachgiaovien) {
		this.danhsachgiaovien = danhsachgiaovien;
	}
	public List<Class> getDanhsachclop() {
		return danhsachclop;
	}
	public void setDanhsachclop(List<Class> danhsachclop) {
		this.danhsachclop = danhsachclop;
	}
}
