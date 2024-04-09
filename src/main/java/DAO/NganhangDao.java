package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Class;
import model.Giangday;
import model.Gv;
import model.Nganhangcauhoi;
import util.JDBCUtil;

public class NganhangDao implements DAO_Interface<Nganhangcauhoi> {

	@Override
	public List<Nganhangcauhoi> selectall() {
		List<Nganhangcauhoi> result =  new ArrayList<Nganhangcauhoi>();	
		try {
			Connection con  = JDBCUtil.getConnection();
			String sql = "select * from Nganhangcauhoi";
			
			PreparedStatement a;

				a = con.prepareStatement(sql);
				ResultSet kq = a.executeQuery();
				while(kq.next())
				{
					String id = kq.getString("idNganHang");
					int sl = kq.getInt("soluong");
					Gv gv = new Gv(); gv.setMaGv(kq.getString("giaovienquanli")); 
					Nganhangcauhoi u = new Nganhangcauhoi(id,sl,gv);
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
	public Nganhangcauhoi selectbyid(Nganhangcauhoi t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Nganhangcauhoi t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Nganhangcauhoi t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebyid(Nganhangcauhoi t) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
