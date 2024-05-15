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
import model.Nganhangcauhoi;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Cauhoi_Dao implements DAO_Interface<Cauhoi> {
	public static Cauhoi_Dao _instance;
	public static Cauhoi_Dao Instance(){
		if(_instance  ==null)
		{
			_instance = new Cauhoi_Dao();
		
		}
			return _instance;
	}
	@Override
	public List<Cauhoi> selectall() {
		List<Cauhoi> result =  new ArrayList<Cauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from cauhoi";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				
				while(kq.next())
				{
					String id  = kq.getString("id");
					String	noidung  =  kq.getString("Noidung");
					String dapAnA = kq.getString("dapAnA");
					String dapAnB = kq.getString("dapAnB");
					String dapAnC = kq.getString("dapAnC");
					String dapAnD = kq.getString("dapAnD");
					String dapAn = kq.getString("dapan");
					int mucdo = kq.getInt("mucdo");
					String Nganhang = kq.getString("NganHang");
					Cauhoi u  = new Cauhoi(id, noidung, dapAnA, dapAnB, dapAnC, dapAnD, mucdo ,dapAn, NganhangDao.Instance().selectbyid(new Nganhangcauhoi(Nganhang,0, null)));					
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	
	public List<Cauhoi> selectallbyNHCH(String idNHCH) {
		List<Cauhoi> result =  new ArrayList<Cauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from cauhoi where NganHang = ? ";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idNHCH);
				ResultSet kq = a.executeQuery();
				
				while(kq.next())
				{
					String id  = kq.getString("id");
					String	noidung  =  kq.getString("Noidung");
					String dapAnA = kq.getString("dapAnA");
					String dapAnB = kq.getString("dapAnB");
					String dapAnC = kq.getString("dapAnC");
					String dapAnD = kq.getString("dapAnD");
					String dapAn = kq.getString("dapan");
					int mucdo = kq.getInt("mucdo");
					String Nganhang = kq.getString("NganHang");
					Cauhoi u  = new Cauhoi(id, noidung, dapAnA, dapAnB, dapAnC, dapAnD, mucdo ,dapAn, NganhangDao.Instance().selectbyid(new Nganhangcauhoi(Nganhang,0, null)));					
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
	public Cauhoi selectbyid(Cauhoi t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from cauhoi where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getId());
				ResultSet kq = a.executeQuery();
				
				while(kq.next())
				{
					String id  = kq.getString("id");
					String	noidung  =  kq.getString("Noidung");
					String dapAnA = kq.getString("dapAnA");
					String dapAnB = kq.getString("dapAnB");
					String dapAnC = kq.getString("dapAnC");
					String dapAnD = kq.getString("dapAnD");
					String dapAn = kq.getString("dapan");
					int mucdo = kq.getInt("mucdo");
					String Nganhang = kq.getString("NganHang");
					Cauhoi u  = new Cauhoi(id, noidung, dapAnA, dapAnB, dapAnC, dapAnD, mucdo ,dapAn, NganhangDao.Instance().selectbyid(new Nganhangcauhoi(Nganhang,0, null)));					
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

	public void updateBeforeDeleteGv(String idGv, String idNh) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "update cauhoi set NganHang = NULL where NganHang = (select idNganHang from Nganhangcauhoi where giaovienquanli = ? and idNganHang = ? )";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idGv);
				a.setString(2, idNh);
				a.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
