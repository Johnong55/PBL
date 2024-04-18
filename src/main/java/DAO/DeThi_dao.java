package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Account;
import model.DeThi;
import model.KiThi;
import util.HibernateUtil;
import util.JDBCUtil;

public class DeThi_dao implements DAO_Interface<DeThi>{

	@Override
	public List<DeThi> selectall() {
		List<DeThi> result = new ArrayList<DeThi>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from dethi";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String  kithi = kq.getString("kithi");
				String mota= kq.getString("mota");
				KiThi_dao kt = new KiThi_dao();
				KiThi x  = new KiThi();
				x.setId(kithi);
				KiThi_dao kithiDao = new KiThi_dao();
				DeThi  u  = new DeThi(id,kithiDao.selectbyid(x));
				result.add(u);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	
	}

	@Override
	public DeThi selectbyid(DeThi t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(DeThi t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();

		if (sessionFactory != null) {
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
	public boolean update(DeThi t) {
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
	public boolean deletebyid(DeThi t) {
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
