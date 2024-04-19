package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Class;
import model.Gv;
import model.KiThi;
import model.Sv;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Sv_dao implements DAO_Interface<Sv> {

	@Override
	public List<Sv> selectall() {
		List<Sv> result = new ArrayList<Sv>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Sv";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("ten");
					String lop= kq.getString("lop");
			Class lop1 = new Class();
			lop1.setIdclass(lop);
					Class_dao c = new Class_dao();
					Class Lresult = new Class();
					Lresult = c.selectbyid(lop1);
					Sv u = new Sv(id,ten,Lresult);
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
	public Sv selectbyid(Sv t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Sv "
					+ " where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getIdSv());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("ten");
					String lop= kq.getString("lop");
						Class lop1 = new Class();
						lop1.setIdclass(lop);
					
				Sv u = new Sv(id, ten, lop1);
				
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
	public boolean insert(Sv t) {
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
	public boolean update(Sv t) {
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
	public boolean deletebyid(Sv t) {
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
	public List<Sv> selectbyclass(Class t)
	{
		List<Sv> result = new ArrayList<Sv>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Sv"
					+ " where lop = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
			a.setString(1,t.getIdclass());
			System.out.println(a);
				ResultSet kq = a.executeQuery();
			
				while(kq.next())
				{
					String id = kq.getString("idSv");
					String ten = kq.getString("ten");
					String lop= kq.getString("lop");
			Class lop1 = new Class();
			lop1.setIdclass(lop);
					
					Sv u = new Sv(id,ten,lop1);
					result.add(u);
					
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		return result;
	}	
	public List<KiThi> selectKithiBySV(Sv sv)
	{	
		List<KiThi> result  = new ArrayList<KiThi>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Kithi"
					+ " where lop = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, sv.getIdclass().getIdclass());
				ResultSet kq = a.executeQuery();
			
				
				while(kq.next())
				{
					String id = kq.getString("id");
					String mota = kq.getString("mota");
					String lop = kq.getString("lop");
					String nguoitao = kq.getString("nguoitao");
					int tg = kq.getInt("thoigianlambai");
					int sl = kq.getInt("sl");
					Date date = kq.getDate("date");
					Class_dao c = new Class_dao();
					Gv_dao gvdao = new Gv_dao();
					Class lop1 = new Class();
					lop1.setIdclass(lop);
					Class Lresult = new Class();
					Gv gv = new Gv();
					Gv gresult = new Gv();
					gv.setId(nguoitao);
					gresult = gvdao.selectbyid(gv);
					Lresult = c.selectbyid(lop1);
			
					KiThi kt = new KiThi(id, Lresult, tg, mota, date, gv, sl);
					
					result.add(kt);
					
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	} 
	
}
