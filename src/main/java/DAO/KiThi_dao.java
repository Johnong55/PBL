package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.KiThi;
import util.HibernateUtil;

public class KiThi_dao implements DAO_Interface<KiThi>{

	@Override
	public List<KiThi> selectall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KiThi selectbyid(KiThi t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(KiThi t) {
		SessionFactory sessionFactory =HibernateUtil.getSessionfacFactory();
		if(sessionFactory!= null)
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
	public boolean update(KiThi t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebyid(KiThi t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
