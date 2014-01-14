package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBIface {

	private static String sDbDriver = "com.mysql.jdbc.Driver";
	private static String sDbUrl = "jdbc:mysql://localhost:3306/hotelverwaltung";
	private static String sUsr = "root";
	private static String sPwd = "init";

	/*
	 * Login to Database using the Default Connection Parameters
	 */
	public static boolean loginDB() throws SQLException {
		return DBIface.loginDB(DBIface.sUsr, DBIface.sPwd);
	}

	/*
	 * Login to Database
	 * 
	 * @param user: user name
	 * 
	 * @param pwd: password
	 */
	public static boolean loginDB(String user, String pwd) throws SQLException {
		try {
			Class.forName(sDbDriver);
			if (user!=""&&pwd!="") {
				DBIface.sUsr = user; DBIface.sPwd = pwd;
			}
			DriverManager.getConnection(DBIface.sDbUrl, DBIface.sUsr, DBIface.sPwd);
			//System.out.println(cn.toString());
			return true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found: " + ex.getMessage());
		}
		return false;
	}

	public static ResultSet executeQuery(String SQLQuery) throws SQLException {
		ResultSet rs = null;
		try {
			DBIface.loginDB();
			Class.forName(sDbDriver);
			Connection cn = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
			//System.out.println(cn.toString());
			Statement st = cn.createStatement();
			if (st.execute(SQLQuery, Statement.RETURN_GENERATED_KEYS))
				rs = st.getResultSet();
			else
				rs = st.getGeneratedKeys();
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found: " + ex.getMessage());
		}
		return rs;
	}
}