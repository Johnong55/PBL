package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DAO.Account_dao;
import DAO.Class_dao;
import DAO.Giangday_dao;
import DAO.Gv_dao;
import DAO.NganhangDao;	
import DAO.Sv_dao;
import DAO.truonghoc_dao;
import model.Account;
import model.Class;
import model.Giangday;
import model.Gv;
import model.Sv;
import model.truonghoc;
import util.HibernateUtil;

public class Demo {
	public static void main(String[] args) {
		Account_dao ac_dao = new Account_dao();
		Gv_dao gv = new Gv_dao();
		Sv_dao sv = new Sv_dao();
		truonghoc_dao tr  = new truonghoc_dao();
		Class_dao cl = new Class_dao();
		Giangday_dao gd = new Giangday_dao();
		NganhangDao nh = new NganhangDao();
		truonghoc truong1 = new truonghoc();
		truong1.setId("01");
		truong1.setTentruong("THPT HOA VANG");
		
		Class cl1 = new Class();
		cl1.setIdclass("01");
		cl1.setTenlop("10A");
		cl1.setTruong(truong1);
		Class cl2 = new Class();
		cl2.setIdclass("02");
		cl2.setTenlop("10B");
		cl2.setTruong(truong1);
		Class cl3 = new Class();
		cl3.setIdclass("03");
		cl3.setTenlop("10C");
		cl3.setTruong(truong1);
		List<Class> a = new ArrayList<Class>();
		a.add(cl1);
		a.add(cl2);
		a.add(cl3);
		Gv gv1= new Gv();
		gv1.setId("01");
		gv1.setTen("ONG VAN QUANG TRI");
		gv1.setTruong(truong1);
		gv1.setMaquyen(1);
		gv1.setUsername(gv1.getId());
		gv1.setPassword("123456");
		gv1.addclass(cl1);
		gv1.addclass(cl3);
		Gv gv2= new Gv();
		gv2.setId("02");
		gv2.setTen("ONG ");
		gv2.setTruong(truong1);
		gv2.setMaquyen(1);
		gv2.setUsername(gv2.getId());
		gv2.setPassword("123456");
		gv2.addclass(cl1);
		gv2.addclass(cl2);
		Sv sv1 = new Sv();
		sv1.setId("102220088");
		sv1.setUsername(sv1.getId());
		sv1.setPassword(sv1.getId());
		sv1.setMaquyen(2);
		sv1.setTen("Ong Van Quang Tri");
		Sv sv2 = new Sv();
		sv2.setId("102220089");
		sv2.setUsername(sv2.getId());
		sv2.setPassword(sv2.getId());
		sv2.setMaquyen(2);
		sv2.setTen("Nguyen Thanh Vinh");
		Sv sv3 = new Sv();
		sv3.setId("102220090");
		sv3.setUsername(sv3.getId());
		sv3.setPassword(sv3.getId());
		sv3.setMaquyen(2);
		sv3.setTen("Tran Dang Minh Duc");
		Sv sv4 = new Sv();
		sv4.setId("102220091");
		sv4.setUsername(sv4.getId());
		sv4.setPassword(sv4.getId());
		sv4.setMaquyen(2);
		sv4.setTen("Le Khiet Dan");
		
		Sv sv5 = new Sv();
		sv5.setId("102220092");
		sv5.setUsername(sv5.getId());
		sv5.setPassword(sv5.getId());
		sv5.setMaquyen(2);
		sv5.setTen("Nguyen Quang Truong");
		sv4.setIdclass(cl3);
		sv2.setIdclass(cl2);
		sv1.setIdclass(cl1);
		sv3.setIdclass(cl2);
		sv5.setIdclass(cl3);
	
		List<Gv> show = new ArrayList<Gv>();
		show= 	cl.selectGvinClass(cl1);
		for( Gv i : show)
		{
			System.out.println(i);
		}
	}
}
