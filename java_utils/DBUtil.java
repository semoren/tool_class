package org.tarena.netctoss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Properties properties = new Properties();
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String pwd=null;
	static {
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver=properties.getProperty("jdbc.driver");
			url=properties.getProperty("jdbc.url");
			user=properties.getProperty("jdbc.user");
			pwd=properties.getProperty("jdbc.password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection openConnection() throws SQLException{
		return DriverManager.getConnection(url, user, pwd);
	}
	public static void closeConnection(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭连接时发现异常");
			}
		}
	}
}
