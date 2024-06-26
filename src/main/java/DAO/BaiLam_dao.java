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
import model.Cauhoi;
import model.Cautraloisinhvien;
import model.Class;
import model.DeThi;
import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import model.Sv;
import util.HibernateUtil;
import util.JDBCUtil;

public class BaiLam_dao implements DAO_Interface<BaiLam> {

	private static BaiLam_dao _instance;
	public static  BaiLam_dao Instance() {
		if(_instance == null) {
			_instance  = new BaiLam_dao();
		}
		return _instance;
		
	}
	@Override
	public List<BaiLam> selectall() {
		List<BaiLam> result  = new ArrayList<BaiLam>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam ";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				result.add(u);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	public BaiLam selectbyid(BaiLam t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where maBailam = ?";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, t.getMaBailam());
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				return u;
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public BaiLam selectbyid(String t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where maBailam = ? ";

			PreparedStatement a;
			a = con.prepareStatement(sql);
			a.setString(1, t);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				return u;
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public BaiLam selectbyidSvAndidKithi(String idsv, String idkithi) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where Sv = ? and kithi_id = ? ";

			PreparedStatement a;
			a = con.prepareStatement(sql);
			a.setString(1, idsv);
			a.setString(2, idkithi);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				return u;
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<BaiLam> selectbyidSV(String t) {
		List<BaiLam> listBailam = new ArrayList<BaiLam>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where Sv = ? ";

			PreparedStatement a;
			a = con.prepareStatement(sql);
			a.setString(1, t);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				listBailam.add(u);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBailam;
	}
	public List<BaiLam> selectbyidKiThi(String t) {
		List<BaiLam> listBailam = new ArrayList<BaiLam>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where kithi_id = ? ";

			PreparedStatement a;
			a = con.prepareStatement(sql);
			a.setString(1, t);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				listBailam.add(u);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBailam;
	}

	@Override
	public boolean insert(BaiLam t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();

		if (sessionFactory != null) {
			try {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.save(t);
				tr.commit();
				session.close();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		return false;
	}

	@Override
	public boolean update(BaiLam t) {
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
	public boolean deletebyid(BaiLam t) {
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
	public List<BaiLam> selectbailamfromkithi(String idkithi)
	{
		List<BaiLam> result  = new ArrayList<BaiLam>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where kithi_id = ? ";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, idkithi);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				result.add(u);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<BaiLam> selectbailambysv(Sv t)
	{
		List<BaiLam> result  = new ArrayList<BaiLam>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from bailam where sv = ? ";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, t.getId());
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String mabailam = kq.getString("maBailam");
				double  diem = kq.getDouble("diem");
				Time thoigianbatdau = kq.getTime("thoigianbatdau");
				Time thoigianketthuc = kq.getTime("thoigianketthuc");
				String dethi_id = kq.getString("dethi_id");
				String kithi_id = kq.getString("kithi_id");
				String sv_id = kq.getString("sv");
				int socaudung = kq.getInt("socaudung");
				int socausai = kq.getInt("socausai");
				DeThi dethi = new DeThi();
				dethi.setId(dethi_id);
				KiThi kithi = new KiThi();
				kithi.setId(kithi_id);
				Sv sv = new Sv();
				sv.setId(sv_id);
			
				BaiLam u  = new BaiLam(mabailam, Sv_dao.Instance().selectbyid(sv), diem, thoigianbatdau, thoigianketthuc, DeThi_dao.Instance().selectbyid(dethi), KiThi_dao.Instance().selectbyid(kithi), null);
				u.setCautraloi(CautraloiSinhvien_dao.Instance().selectCautraloisinhvienfromBailam(u));
				u.setSocaudung(socaudung);
				u.setSocausai(socausai);
				result.add(u);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}

		return result;
	}
	
}
