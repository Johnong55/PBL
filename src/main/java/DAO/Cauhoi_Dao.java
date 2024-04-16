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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.Cauhoi;
import model.Class;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Cauhoi_Dao implements DAO_Interface<Cauhoi> {

	@Override
	public List<Cauhoi> selectall() {
		List<Cauhoi> result =  new ArrayList<Cauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				ResultSetMetaData rsmd  = (ResultSetMetaData) kq.getMetaData();
				
				while(kq.next())
				{
				
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}

	@Override
	public Cauhoi selectbyid(Cauhoi t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Cauhoi t) {
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
	public boolean update(Cauhoi t) {
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
	public boolean deletebyid(Cauhoi t) {
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
