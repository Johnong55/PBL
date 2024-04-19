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

import model.Class;
import model.Gv;
import model.KiThi;
import model.Sv;
import util.HibernateUtil;
import util.JDBCUtil;

public class KiThi_dao implements DAO_Interface<KiThi> {

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
		
				KiThi kt = new KiThi(id, Lresult, startTime,tg, mota, date, gv, sl);
				
				result.add(kt);
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
		
				KiThi kt = new KiThi(id, Lresult,startTime, tg, mota, date, gv, sl);
				
				return kt;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

}
