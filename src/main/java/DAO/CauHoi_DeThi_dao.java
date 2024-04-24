	package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cauhoi_DeThi;
import util.HibernateUtil;

public class CauHoi_DeThi_dao implements DAO_Interface<Cauhoi_DeThi> {
	public static CauHoi_DeThi_dao _instance;
	public static CauHoi_DeThi_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new CauHoi_DeThi_dao();
		
		}
			return _instance;
	}
	@Override
	public List<Cauhoi_DeThi> selectall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cauhoi_DeThi selectbyid(Cauhoi_DeThi t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Cauhoi_DeThi t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();
		if(sessionFactory!=null)
		{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(t);
			tr.commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Cauhoi_DeThi t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();
		if(sessionFactory!=null)
		{
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
	public boolean deletebyid(Cauhoi_DeThi t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();
		if(sessionFactory!=null)
		{
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
