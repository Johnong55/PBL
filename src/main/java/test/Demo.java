package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DAO.Class_dao;
import DAO.Giangday_dao;
import DAO.Gv_dao;
import DAO.Sv_dao;
import DAO.truonghoc_dao;
import model.Class;
import model.Giangday;
import model.Gv;
import model.Sv;
import model.truonghoc;
import util.HibernateUtil;

public class Demo {
	public static void main(String[] args) {
		Gv_dao gv = new Gv_dao();
		Gv gv1 = new Gv();
		Class cl1 = new Class();
		cl1.setIdclass("dt2");
		truonghoc truong = new truonghoc();
		truong.setId("Nguyen Hong Anh");
		cl1.setIdclass("dt2");
		gv1.setMaGv("15");
		gv1.setTen("JOHNQto");
		gv1.setTruong(truong);
		Giangday gd = new Giangday();
		gd.setId("5");
		gd.setMaGv(gv1);
		gd.setMalop(cl1);
		Giangday_dao giangday_dao = new Giangday_dao();
		giangday_dao.insert(gd);
		
	}
}
