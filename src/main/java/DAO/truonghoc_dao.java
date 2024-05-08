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

import model.Class;
import model.Sv;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class truonghoc_dao implements DAO_Interface<truonghoc> {
	public static truonghoc_dao _instance;
	public static truonghoc_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new truonghoc_dao();
		
		}
			return _instance;
	}
	@Override
	public List<truonghoc> selectall() {
		List<truonghoc> result = new ArrayList<truonghoc>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from truonghoc";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("tentruong");
		
					
					truonghoc u = new truonghoc(id,ten, null, null);
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
	public truonghoc selectbyid(truonghoc t) {
		List<truonghoc> result = new ArrayList<truonghoc>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from truonghoc "
					+ " where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getId());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("tentruong");
					
					
					truonghoc u = new truonghoc(id,ten, null, null);
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result.get(0);
	}
	
	public truonghoc selectbyid(String t) {
		List<truonghoc> result = new ArrayList<truonghoc>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from truonghoc "
					+ " where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("tentruong");
					
					
					truonghoc u = new truonghoc(id,ten, null, null);
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result.get(0);
	}

	@Override
	public boolean insert(truonghoc t) {
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
	public boolean update(truonghoc t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebyid(truonghoc t) {
		// TODO Auto-generated method stub
		return false;
	}

}
