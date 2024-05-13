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
import model.Giangday;
import model.Gv;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Giangday_dao implements DAO_Interface<Giangday> {
	public static Giangday_dao _instance;
	public static Giangday_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new Giangday_dao();
		
		}
			return _instance;
	}
	@Override
	public List<Giangday> selectall() {
		List<Giangday> result =  new ArrayList<Giangday>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Giangday";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					
					String gv = kq.getString("giaoviendunglop");
					String lop= kq.getString("lop");
					Gv  gv1 = new Gv();
					gv1.setMaGv(gv);
					Class cl = new Class();
					cl.setIdclass(lop);
					
					Giangday u = new Giangday(gv1,cl );
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		
	}
	
	public List<Giangday> selectGiangdayOfGv(String idgv) {
		List<Giangday> result =  new ArrayList<Giangday>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Giangday where giaoviendunglop = ? ";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idgv);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					int id = kq.getInt("id");
					String gv = kq.getString("giaoviendunglop");
					String lop= kq.getString("lop");
					Gv  gv1 = new Gv();
					gv1.setMaGv(gv);
					Class cl = new Class();
					cl.setIdclass(lop);
					
					Giangday u = new Giangday(id, gv1,cl );
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
	public Giangday selectbyid(Giangday t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Giangday "
					+ "where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(0, t.getMaGv().getId());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					
					String gv = kq.getString("giaoviendunglop");
					String lop= kq.getString("lop");
					Gv  gv1 = new Gv();
					gv1.setMaGv(gv);
					Class cl = new Class();
					cl.setIdclass(lop);
					
					Giangday u = new Giangday(gv1,cl );
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
	public boolean insert(Giangday t) {
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
	public boolean update(Giangday t) {
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
	public boolean deletebyid(Giangday t) {
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
