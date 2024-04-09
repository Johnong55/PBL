package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
public class JDBCUtil {
	public static Connection getConnection()
	{
		Connection C = null;
		try {
			/// đăng kí mysql driver với drivermanager
			DriverManager.registerDriver( new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/demo";
			String username = "root";
			String password = "";
			///////// tạo kết nối
			C = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		return C;
	}
	public static void closeConnection(Connection C) {
		try {
			if(C!=null)
			{
				C.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void printInfor(Connection c)
	{
		try {
			if(c!=null)
			{
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
