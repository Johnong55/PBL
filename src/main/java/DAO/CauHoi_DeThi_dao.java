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

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import model.Cauhoi;
import model.Cauhoi_DeThi;
import model.DeThi;
import util.HibernateUtil;
import util.JDBCUtil;

public class CauHoi_DeThi_dao implements DAO_Interface<Cauhoi_DeThi> {
	public static CauHoi_DeThi_dao _instance;
	public static CauHoi_DeThi_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new CauHoi_DeThi_dao();
		
		}
			return _instance;
	}
	@Override
	public List<Cauhoi_DeThi> selectall() {
		List<Cauhoi_DeThi> cauhois = new ArrayList<Cauhoi_DeThi>();
		Connection con = JDBCUtil.getConnection();
		String sql = "select * from cauhoi_dethi";
		
		PreparedStatement a;
		try {
			a = con.prepareStatement(sql);
			ResultSet kq = a.executeQuery();
			System.out.println(2);
			while(kq.next()){
				int id = kq.getInt("id");
				String cauhoi = kq.getString("Cauhoi");
				String dethi = kq.getString("DeThi");
				Cauhoi c = Cauhoi_Dao.Instance().selectbyidCauHoi(cauhoi);
				DeThi dt = DeThi_dao.Instance().selectbyidDeThi(dethi);
				Cauhoi_DeThi cd = new Cauhoi_DeThi(id,c, dt);
				cauhois.add(cd);
				System.out.println(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cauhois;
	}
	public List<Cauhoi_DeThi> selectbyIdDeThi(String idDeThi) {
		List<Cauhoi_DeThi> cauhois = new ArrayList<Cauhoi_DeThi>();
		Connection con = JDBCUtil.getConnection();
		String sql = "select * from cauhoi_dethi where DeThi = ?";
		
		PreparedStatement a;
		try {
			a = con.prepareStatement(sql);
			a.setString(1, idDeThi);
			ResultSet kq = a.executeQuery();
			System.out.println(2);
			while(kq.next()){
				int id = kq.getInt("id");
				String cauhoi = kq.getString("Cauhoi");
				String dethi = kq.getString("DeThi");
				Cauhoi c = Cauhoi_Dao.Instance().selectbyidCauHoi(cauhoi);
				DeThi dt = DeThi_dao.Instance().selectbyidDeThi(dethi);
				Cauhoi_DeThi cd = new Cauhoi_DeThi(id,c, dt);
				cauhois.add(cd);
				System.out.println(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cauhois;
	}

	@Override
	public Cauhoi_DeThi selectbyid(Cauhoi_DeThi t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Cauhoi_DeThi t) {
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
	public boolean update(Cauhoi_DeThi t) {
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
	public boolean deletebyid(Cauhoi_DeThi t) {
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
	public boolean updatewhendelete(String id)
	{
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "update cauhoi_dethi set cauhoi = \"cauhoitrong\" where cauhoi = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1,id);
				int kq = a.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
}
