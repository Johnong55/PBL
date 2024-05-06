package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Account;
import model.request;
import model.truonghoc;
import util.HibernateUtil;
import util.JDBCUtil;

public class request_dao {
	public static request_dao _instance;
	public static request_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new request_dao();
		
		}
			return _instance;
	}
	public List<request> selectallfromrequest()
	{
		List<request> result =  new ArrayList<request>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from request";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("id");
					String account_id = kq.getString("account_id");
					System.out.println(account_id);
					Date date =  kq.getDate("time");
					Account ac = new Account();
					ac.setId(account_id);
					System.out.println(ac.id);
					request u  = new request(id,Account_dao.Instance().selectbyid(ac),date);
					result.add(u);
					
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	public boolean insert(request t)
	{
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
				throw(e);
			}
			
		}
		return false;
	}
}