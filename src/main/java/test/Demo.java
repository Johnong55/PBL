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
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();
		if(sessionFactory!=null)
		{
			Session session  = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			tr.commit();
			session.close();
			System.out.println("Tri ngu");
			
		}
		
	}
}
