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

import model.BaiLam;
import model.Cauhoi;
import model.Cautraloisinhvien;
import model.Nganhangcauhoi;
import util.HibernateUtil;
import util.JDBCUtil;

public class CautraloiSinhvien_dao  {

	public static CautraloiSinhvien_dao _instance;
	public static CautraloiSinhvien_dao Instance(){
		if(_instance  ==null)
		{
			_instance = new CautraloiSinhvien_dao();
		
		}
			return _instance;
	}
	public List<Cautraloisinhvien> selectCautraloisinhvienfromBailam(BaiLam bailam)
	{
		List<Cautraloisinhvien> result = new ArrayList<Cautraloisinhvien>();
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = " select * from cautraloisinhvien\r\n"
					+ "where bailam = ? \r\n";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				a.setString(1, bailam.getMaBailam());
				ResultSet kq = a.executeQuery();
				
				while(kq.next())
				{
					String id = kq.getString("id");
					String cauhoi= kq.getString("cauhoi_id");
					String cautraloi = kq.getString("cautraloi");
					String bailamid = kq.getString("bailam");
					Cautraloisinhvien u = new Cautraloisinhvien();
					u.setBailamsv(bailam);
					Cauhoi ch = new Cauhoi();
					ch.setId(cauhoi);
					u.setCauhoi(Cauhoi_Dao.Instance().selectbyid(ch));
					u.setCautraloi(cautraloi);
					u.setId(id);
					result.add(u);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	public boolean deletebyid(Cautraloisinhvien t) {
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
