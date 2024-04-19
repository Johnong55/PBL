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

public class Gv_dao implements DAO_Interface<Gv> {
	public static Gv_dao _instance;
	public static Gv_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new Gv_dao();
		
		}
			return _instance;
	}
	@Override
	public List<Gv> selectall() {
		List<Gv> result = new ArrayList<Gv>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Gv";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("ten");
					String idtruong= kq.getString("truong");
					truonghoc truong = new truonghoc();
					truong.setId(idtruong);
					truonghoc_dao tr = new truonghoc_dao();
					Gv u = new Gv();
					u.setMaGv(id);
					u.setTen(ten);
					u.setTruong(tr.selectbyid(truong));
					
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
	public Gv selectbyid(Gv t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Gv "
					+ "where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getMaGv());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("ten");
					String idtruong= kq.getString("truong");
					truonghoc truong = new truonghoc();
					truong.setId(idtruong);
					truonghoc_dao tr = new truonghoc_dao();
					truonghoc b = new truonghoc();
					b = tr.selectbyid(truong);
					Gv u = new Gv(id,ten,b);
				
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
	public boolean insert(Gv t) {
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
	public boolean update(Gv t) {
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
	public boolean deletebyid(Gv t) {
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
	public List<Class> selectclassbyid(Gv gv)
	{
		List<Class> result =new ArrayList<Class>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class \r\n"
					+ "inner join giangday on class.idclass = giangday.lop\r\n"
					+ "where giangday.giaoviendunglop = (select maGv from gv"
					+ " where id = ?)";
			
			PreparedStatement a;
			
				a = con.prepareStatement(sql);
				a.setString(1, gv.getMaGv());
				ResultSet kq = a.executeQuery();
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
}
