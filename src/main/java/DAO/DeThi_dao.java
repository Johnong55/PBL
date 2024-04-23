package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.Account;
import model.Cauhoi;
import model.DeThi;
import model.KiThi;
import model.Nganhangcauhoi;
import util.HibernateUtil;
import util.JDBCUtil;

public class DeThi_dao implements DAO_Interface<DeThi>{
	public static DeThi_dao _instance;
	public static DeThi_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new DeThi_dao();
		
		}
			return _instance;
	}
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

	/*
	 * public DeThi getDethi() { DeThi a; String id= "" , mota,kithi=""; try {
	 * Connection con = JDBCUtil.getConnection(); String sql =
	 * "select * from dethi " + "inner join kithi on dethi.kithi = kithi.id " +
	 * "order by RAND() LIMIT 1;"; Statement st = con.createStatement(); ResultSet
	 * rs = st.executeQuery(sql); while(rs.next()) { id = rs.getString("id"); mota =
	 * rs.getString("mota"); kithi = rs.getString("kithi");
	 * 
	 * } } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } a= new
	 * DeThi(id,KiThi_dao.Instance().selectbyid(kithi)); return a;
	 * 
	 * }
	 */
	public List<Cauhoi> Hienthicauhoi(DeThi t)
	{
		List<Cauhoi> result =  new ArrayList<Cauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from cauhoi \r\n"
					+ "inner join cauhoi_dethi on cauhoi.id = cauhoi_dethi.cauhoi\r\n"
					+ "where cauhoi_dethi.Dethi = ?";
			
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
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	public List<Cauhoi> Xaydungdethi(KiThi t)
	{
		List<Cauhoi> result = new ArrayList<Cauhoi>();
		
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from cauhoi "
					+ "where Nganhang = ? and mucdo = ? "
					+ " order by rand() "
					+ " limit ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1,t.getNganhangcauhoi().getIdNganHang());
				a.setInt(2,1);
				a.setInt(3, t.getSocauDe());
				ResultSet kq = a.executeQuery();
				System.out.println(a.toString());
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
				a.setInt(2,2);
				a.setInt(3, t.getSocautb());
				kq = a.executeQuery();
				System.out.println(a.toString());
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
				a.setInt(2,3);
				a.setInt(3, t.getSocaukho());
				kq = a.executeQuery();
				System.out.println(a.toString());
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

}
