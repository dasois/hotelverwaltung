package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBIface {
	
	private static String sDbDriver = null;
	private static String sDbUrl = null;
	private static String sUsr = "";
	private static String sPwd = "";
	
	public DBIface() {
		// set access data for database connection
		sDbDriver = "com.mysql.jdbc.Driver";
		sDbUrl = "jdbc:mysql://localhost:3306/studienarbeit";
		sUsr = "root";
		sPwd = "init";
	}
	
	public DBIface (String SQLQuery) throws SQLException {
		new DBIface();
		DBIface.executeQuery(SQLQuery);
	}
	
	/*
	 * Login to Database using the Default Connection Parameters
	 */
	static boolean loginDB() throws SQLException {
		return DBIface.loginDB(DBIface.sUsr, DBIface.sPwd);
	}
	
	/*
	 * Login to Database
	 * @param user: user name
	 * @param pwd: password
	 */
	static boolean loginDB(String user, String pwd) throws SQLException {
		try{
			Class.forName(sDbDriver);
			Connection cn = DriverManager.getConnection(DBIface.sDbUrl, DBIface.sUsr, DBIface.sPwd);
			System.out.println(cn.toString());
			return true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found: "+ex.getMessage());
		}
		return false;
	}
	
	public static ResultSet executeQuery(String SQLQuery) throws SQLException {
		ResultSet rs = null;
		try{
			DBIface.loginDB();
			Class.forName(sDbDriver);
			Connection cn = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
			System.out.println(cn.toString());
			Statement st = cn.createStatement();
			rs = st.executeQuery(SQLQuery);
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found: "+ex.getMessage());
		}
		return rs;
	}
}