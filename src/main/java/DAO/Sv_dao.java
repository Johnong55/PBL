package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Account;
import model.Class;
import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import model.Sv;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Sv_dao implements DAO_Interface<Sv> {
	private static Sv_dao _instance;
	public static  Sv_dao Instance() {
		if(_instance == null) {
			_instance  = new Sv_dao();
		}
		return _instance;
		
	}
	public KiThi findKithiSoon(Sv t) {
		KiThi k = new KiThi(null,null,null,0,null,null,null,0);
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select kithi.* from kithi \r\n"
					+ "INNER JOIN sv ON sv.lop = kithi.lop\r\n"
					+ " WHERE ( (kithi.date > ? ) OR ( kithi.date = ?  and kithi.thoigianbatdau > ?)) and sv.id = ?\r\n"
					+ "order by date,thoigianbatdau limit 1;";
			PreparedStatement a;
			LocalTime time =  LocalTime.now();
	        long currentTimeMillis = System.currentTimeMillis();
			Date d = new  Date(currentTimeMillis);
			a = con.prepareStatement(sql);
			a.setString(1, d.toString());
			a.setString(2,d.toString() );
			a.setString(3, time.toString());
			a.setString(4, t.getId());
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
				k = new KiThi(id, Lresult, startTime,tg, mota, date, gv, sl);
				
				return k;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
	public KiThi findKithiOnl(Sv t) {
		KiThi k = new KiThi(null,null,null,0,null,null,null,0);
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select kithi.* from kithi "
					+ "INNER JOIN sv ON sv.lop =kithi.lop "
					+ "  where date = ? and thoigianbatdau <= ?"
					+" and ADDTIME(thoigianbatdau , SEC_TO_TIME(thoigianlambai * 60)) >= ?"
					+ " and sv.id = ? "
					+ "order by date,thoigianbatdau limit 1;" ;
			PreparedStatement a;
			LocalTime time =  LocalTime.now();
	        long currentTimeMillis = System.currentTimeMillis();
			Date d = new  Date(currentTimeMillis);
			a = con.prepareStatement(sql);
			a.setString(1, d.toString());
			a.setString(2, time.toString());
			a.setString(3, time.toString());
			a.setString(4, t.getId());
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
				
				k = new KiThi(id, Lresult, startTime,tg, mota, date, gv, sl,dataNganHang);
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
		return k;
	}
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
					Account sv = 	Account_dao.Instance().selectbyid(t);
				Sv u = new Sv(id, ten, lop1);
				u.setLinkAnh(sv.getLinkAnh());
				u.setPassword(sv.getPassword());
				u.setMaquyen(sv.maquyen);
				u.setUsername(sv.getUsername());
				return u;
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
	public Sv selectbyid(String idSv) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Sv "
					+ " where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idSv);
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
						//UPDATE TenBang SET TenKhoaNgoai = NULL WHERE TenKhoaNgoai = (SELECT TenKhoaChinh FROM TenBangKhac WHERE DieuKien)
	public void updateSvBeforeDeleteClass(String idclass) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "update Sv set lop = NULL where lop = (select idclass from class where idclass = ?)";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idclass);
				a.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void deleteSvFromClass(String idsv) {
		System.out.println(idsv);
		
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "UPDATE Sv SET lop = NULL WHERE id = ?";
		
			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, idsv);
			a.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public Sv selectbyid(Account t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Sv "
					+ " where id = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getId() );
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					
					String id = kq.getString("id");
					String ten = kq.getString("ten");
					String lop= kq.getString("lop");
					Account sv = 	Account_dao.Instance().selectbyid(t);
					Sv u = new Sv(id, ten, Class_dao.Instance().selectbyid(lop));
					u.setLinkAnh(sv.getLinkAnh());
					u.setPassword(sv.getPassword());
					u.setMaquyen(sv.maquyen);
					u.setUsername(sv.getUsername());
				
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
		
			Sv u = new Sv(id, ten, lop1);
			Account sv = 	Account_dao.Instance().selectbyid(u);
			u.setLinkAnh(sv.getLinkAnh());
			u.setPassword(sv.getPassword());
			u.setMaquyen(sv.maquyen);
			u.setUsername(sv.getUsername());
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
