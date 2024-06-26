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

import model.Account;
import model.Class;
import model.Sv;
import model.truonghoc;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
import util.HibernateUtil;
import util.JDBCUtil;

public class Account_dao implements DAO_Interface<Account> {

	private static Account_dao _instance;
	public static  Account_dao Instance() {
		if(_instance == null) {
			_instance  = new Account_dao();
		}
		return _instance;
		
	}
	@Override
	public List<Account> selectall() {
		List<Account> result = new ArrayList<Account>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from Account";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String linkanh = kq.getString("linkAnh");
				int maQuyen = kq.getInt("maquyen");
				String username = kq.getString("username");
				String password = kq.getString("password");

				Account u = new Account(id, username, password, maQuyen, linkanh);
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
	public Account selectbyid(Account t) {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from Account where id = ?";

			PreparedStatement a;

			a = con.prepareStatement(sql);
			a.setString(1, t.getId());
			ResultSet kq = a.executeQuery();
			while (kq.next()) {
				String id = kq.getString("id");
				String linkanh = kq.getString("linkAnh");
				int maQuyen = kq.getInt("maquyen");
				String username = kq.getString("username");
				String password = kq.getString("password");

				Account u = new Account(id, username, password, maQuyen, linkanh);
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
	public boolean insert(Account t) {
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
	public boolean update(Account t) {
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
	public boolean deletebyid(Account t) {
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
	
}
