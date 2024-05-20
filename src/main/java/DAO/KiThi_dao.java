package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.BaiLam;
import model.Class;
import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import model.Sv;
import util.HibernateUtil;
import util.JDBCUtil;

public class KiThi_dao implements DAO_Interface<KiThi> {
	public static KiThi_dao _instance;
	public static KiThi_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new KiThi_dao();
		
		}
			return _instance;
	}
	@Override
	public List<KiThi> selectall() {
		List<KiThi> result = new ArrayList<KiThi>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from KiThi";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String mota = kq.getString("mota");
				String lop = kq.getString("lop");
				String nguoitao = kq.getString("nguoitao");
				Time startTime = kq.getTime("thoigianbatdau");
				int tg = kq.getInt("thoigianlambai");
				int sl = kq.getInt("sl");
				Date date = kq.getDate("date");
				String nganhang = kq.getString("nganhangcauhoi");
				int socaude = kq.getInt("socauDe");
				int socaukho = kq.getInt("socaukho");
				int socautb  = kq.getInt("socautb");
				String tenmon = kq.getString("monhoc");

				Nganhangcauhoi dataNganHang= NganhangDao.Instance().selectbyid(nganhang);
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
		
			KiThi	k = new KiThi(id, Lresult,tenmon, startTime,tg, mota, date, gv, sl,dataNganHang);
				k.setSocauDe(socaude);
				k.setSocaukho(socaukho);
				k.setSocautb(socautb);
				
				result.add(k);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	@Override
	public KiThi selectbyid(KiThi t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from KiThi "
					+ " where id = ?";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, t.getId());
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String mota = kq.getString("mota");
				String lop = kq.getString("lop");
				String nguoitao = kq.getString("nguoitao");
				Time startTime = kq.getTime("thoigianbatdau");
				int tg = kq.getInt("thoigianlambai");
				int sl = kq.getInt("sl");
				Date date = kq.getDate("date");
				String nganhang = kq.getString("nganhangcauhoi");
				int socaude = kq.getInt("socauDe");
				int socaukho = kq.getInt("socaukho");
				int socautb  = kq.getInt("socautb");
				String tenmon = kq.getString("monhoc");

				Nganhangcauhoi dataNganHang= NganhangDao.Instance().selectbyid(nganhang);
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
		
				KiThi k = new KiThi(id, Lresult,tenmon, startTime,tg, mota, date, gv, sl,dataNganHang);
				k.setSocauDe(socaude);
				k.setSocaukho(socaukho);
				k.setSocautb(socautb);
				
				
				return k;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public KiThi selectbyid(String t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from KiThi "
					+ " where id = ?";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, t);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String mota = kq.getString("mota");
				String lop = kq.getString("lop");
				String nguoitao = kq.getString("nguoitao");
				Time startTime = kq.getTime("thoigianbatdau");
				int tg = kq.getInt("thoigianlambai");
				int sl = kq.getInt("sl");
				Date date = kq.getDate("date");
				String nganhang = kq.getString("nganhangcauhoi");
				int socaude = kq.getInt("socauDe");
				int socaukho = kq.getInt("socaukho");
				int socautb  = kq.getInt("socautb");
				String tenmon = kq.getString("monhoc");

				Nganhangcauhoi dataNganHang= NganhangDao.Instance().selectbyid(nganhang);
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
		
				KiThi k = new KiThi(id, Lresult,tenmon, startTime,tg, mota, date, gv, sl,dataNganHang);
				k.setSocauDe(socaude);
				k.setSocaukho(socaukho);
				k.setSocautb(socautb);
				return k;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<KiThi> selectByIdGv(String idgv) {
		List<KiThi> result = new ArrayList<KiThi>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from KiThi where nguoitao = ? ";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, idgv);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String mota = kq.getString("mota");
				String lop = kq.getString("lop");
				String nguoitao = kq.getString("nguoitao");
				Time startTime = kq.getTime("thoigianbatdau");
				int tg = kq.getInt("thoigianlambai");
				int sl = kq.getInt("sl");
				Date date = kq.getDate("date");
				String nganhang = kq.getString("nganhangcauhoi");
				int socaude = kq.getInt("socauDe");
				int socaukho = kq.getInt("socaukho");
				int socautb  = kq.getInt("socautb");
				String tenmon = kq.getString("monhoc");

				Nganhangcauhoi dataNganHang= NganhangDao.Instance().selectbyid(nganhang);
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
		
			KiThi	k = new KiThi(id, Lresult,tenmon, startTime,tg, mota, date, gv, sl,dataNganHang);
				k.setSocauDe(socaude);
				k.setSocaukho(socaukho);
				k.setSocautb(socautb);
				
				result.add(k);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insert(KiThi t) {
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
	
	public void updateKithiBeforeDeleteGv(String idGv) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "update KiThi set nguoitao = NULL where nguoitao = ? ";
			
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
	public boolean update(KiThi t) {
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
	public boolean deletebyid(KiThi t) {
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
	
	public List<BaiLam> showlistbailamsinhvien(String makithi)
	{
		List<BaiLam> result = new ArrayList<BaiLam>();
		
		
		
		return result;
	}
}
	