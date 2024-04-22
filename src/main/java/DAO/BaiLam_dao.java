package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.BaiLam;
import util.HibernateUtil;

public class BaiLam_dao implements DAO_Interface<BaiLam> {

	private static BaiLam_dao _instance;
	public static  BaiLam_dao Instance() {
		if(_instance == null) {
			_instance  = new BaiLam_dao();
		}
		return _instance;
		
	}
	@Override
	public List<BaiLam> selectall() {
		
		return null;
	}

	@Override
	public BaiLam selectbyid(BaiLam t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(BaiLam t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();

		if (sessionFactory != null) {
			try {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.save(t);
				tr.commit();
				session.close();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		return false;
	}

	@Override
	public boolean update(BaiLam t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(t);
			tr.commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean deletebyid(BaiLam t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(t);
			tr.commit();
			session.close();
			return true;
		}
		return false;
	}
	
}
