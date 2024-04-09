
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

import model.Class;

import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Class_dao implements DAO_Interface<Class> {

	@Override
	public List<Class> selectall() {
		List<Class> result =  new ArrayList<Class>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				ResultSetMetaData rsmd  = (ResultSetMetaData) kq.getMetaData();
				
				while(kq.next())
				{
					String id = kq.getString("idclass");
					String name = kq.getString("tenlop");
					String school= kq.getString("truong");
					
					Class u = new Class(id, name, new truonghoc(school));
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
	public Class selectbyid(Class t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class "
					+ "where idclass = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(0, t.getIdclass());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{

					String id = kq.getString("idclass");
					String name = kq.getString("tenlop");
					String school= kq.getString("truong");
					Class u = new Class(id, name, new truonghoc(school));
				return u;
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}


	@Override
	public boolean insert(Class t) {
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
	public boolean update(Class t) {
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
	public boolean deletebyid(Class t) {
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
