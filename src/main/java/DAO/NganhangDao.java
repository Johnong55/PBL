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
import model.Nganhangcauhoi;
import util.HibernateUtil;
import util.JDBCUtil;

public class NganhangDao implements DAO_Interface<Nganhangcauhoi> {
	public static NganhangDao _instance;
	public static NganhangDao Instance(){
		if(_instance  ==null)
		{
			_instance = new NganhangDao();
		
		}
			return _instance;
	}
	@Override
	public List<Nganhangcauhoi> selectall() {
		List<Nganhangcauhoi> result =  new ArrayList<Nganhangcauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Nganhangcauhoi";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("idNganHang");
					int sl = kq.getInt("soluong");
					Gv gv = new Gv(); 
					gv.setMaGv(kq.getString("giaovienquanli")); 
					Nganhangcauhoi u = new Nganhangcauhoi(id,sl,gv);
					u.setListcauhoi(Cauhoi_Dao.Instance().selectallbyNHCH(id));
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
	public Nganhangcauhoi selectbyid(Nganhangcauhoi t) {
		Nganhangcauhoi nh = null;
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Nganhangcauhoi where idNganHang = ? ";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getIdNganHang());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("idNganHang");
					int sl = kq.getInt("soluong");
					Gv gv = new Gv(); gv.setMaGv(kq.getString("giaovienquanli")); 
					Nganhangcauhoi u = new Nganhangcauhoi(id,sl,gv);
					nh = u;
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nh;
		// TODO Auto-generated method stub	}
	}
	public Nganhangcauhoi selectbyid(String t) {
		Nganhangcauhoi nh = null;
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Nganhangcauhoi where idNganHang = ? ";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("idNganHang");
					int sl = kq.getInt("soluong");
					Gv gv = new Gv(); gv.setMaGv(kq.getString("giaovienquanli")); 
					Nganhangcauhoi u = new Nganhangcauhoi(id,sl,gv);
					nh = u;
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nh;
		// TODO Auto-generated method stub
	}
	
	public List<Nganhangcauhoi> selectbyidgv(Gv g) {
		List<Nganhangcauhoi> result =  new ArrayList<Nganhangcauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Nganhangcauhoi where giaovienquanli = ? ";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, g.getMaGv());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("idNganHang");
					int sl = kq.getInt("soluong");
					Gv gv = new Gv(); gv.setMaGv(kq.getString("giaovienquanli")); 
					Nganhangcauhoi u = new Nganhangcauhoi(id,sl,gv);
					u.setListcauhoi(Cauhoi_Dao.Instance().selectallbyNHCH(id));
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean insert(Nganhangcauhoi t) {
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
	
	public void updateNGCHBeforeDeleteGv(String idGv) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "update Nganhangcauhoi set giaovienquanli = NULL where giaovienquanli = (select id from Gv where id = ?)";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idGv);
				a.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean update(Nganhangcauhoi t) {
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
	public boolean deletebyid(Nganhangcauhoi t) {
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