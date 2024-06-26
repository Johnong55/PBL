
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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.Account;
import model.Class;
import model.Gv;
import model.KiThi;
import model.Sv;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class Class_dao implements DAO_Interface<Class> {
	public static Class_dao _instance;
	public static Class_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new Class_dao();
		
		}
			return _instance;
	}
	public int selectsoluonglop(String malop)
	{
		int soluong =0 ;
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select count(*) from sv where lop = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, malop);
				ResultSet kq = a.executeQuery();
				
				
				while(kq.next())
				{
					soluong = kq.getInt("count(*)");
					return soluong;
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		
	}
	@Override
	public List<Class> selectall() {
		List<Class> result =  new ArrayList<Class>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();

				while(kq.next())
				{
					String id = kq.getString("idclass");
					String name = kq.getString("tenlop");
					String school= kq.getString("truong");
					truonghoc truong = new truonghoc();
					truong.setId(school);
					truonghoc_dao tr = new truonghoc_dao();
					truonghoc b = new truonghoc();
					b = tr.selectbyid(truong);
					
					Class u = new Class(id, name,b);
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	public List<String> selectallID() {
		List<String> result =  new ArrayList<String>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				
				while(kq.next())
				{
					String id = kq.getString("idclass");
					result.add(id);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}

	@Override
	public Class selectbyid(Class t) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class "
					+ "where idclass = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getIdclass());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{

					String id = kq.getString("idclass");
					String name = kq.getString("tenlop");
					String school= kq.getString("truong");
					
					Class u = new Class(id, name,new truonghoc(school));
				return u;
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	public Class selectbyid(String idclass) {
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from class "
					+ "where idclass = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, idclass);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{

					String id = kq.getString("idclass");
					String name = kq.getString("tenlop");
					String school= kq.getString("truong");
					truonghoc truong = new truonghoc();
					truong.setId(school);
					truonghoc_dao tr = new truonghoc_dao();
					truonghoc b = new truonghoc();
					b = tr.selectbyid(truong);
					
					Class u = new Class(id, name,b);
					
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
	public boolean insert(Class t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();
		if(sessionFactory!=null)
		{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			try {
				session.save(t);
				tr.commit();
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Class t) {
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
	
	public boolean deletebyid(Class t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfacFactory();
		if(sessionFactory!=null)
		{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Class classEntity = session.get(Class.class,t.getIdclass());
			session.delete(classEntity);
			tr.commit();
			session.close();
			return true;
		}
		return false;
	}
	
	/// show hoc vien cua 1 lop
	public List<Sv> selectSVinclass(Class t)
	{
		List<Sv> result = new ArrayList<Sv>();
		
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Sv"
					+ " where lop = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getIdclass());
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String ten = kq.getString("ten");
					String lop= kq.getString("lop");
					Class lop1 = Class_dao.Instance().selectbyid(lop);
					Sv u = new Sv(id,ten,lop1);
					u.setList(BaiLam_dao.Instance().selectbyidSV(id));
					u.setDTB();
					
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	public List<Gv> selectGvinClass(Class t)
	{
		List<Gv> result = new ArrayList<Gv>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "\r\n"
					+ "select * from gv \r\n"
					+ " inner join giangday on gv.id = giangday.giaoviendunglop \r\n"
					+ " where giangday.lop = (select idclass from class\r\n"
					+ " where idclass =? );";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getIdclass());
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
	public List<KiThi> selectKithiByclass(Class t)
	{	
		List<KiThi> result  = new ArrayList<KiThi>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Kithi"
					+ " where lop = ?";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, t.getIdclass());
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
