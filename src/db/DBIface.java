package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBIface {

	private static String sDbDriver = "com.mysql.jdbc.Driver";
	private static String sDbUrl = "jdbc:mysql://localhost:3306/hotelverwaltung";
	private static String sUsr = "hm";
	private static String sPwd = "init";
	private static Connection cn;
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
			Connection localConnection = getConnection();
			Statement st = localConnection.createStatement();
			if (st.execute(SQLQuery, Statement.RETURN_GENERATED_KEYS))
				rs = st.getResultSet();
			else
				rs = st.getGeneratedKeys();
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found: " + ex.getMessage());
		}
		return rs;
	}
	
	
	private static Connection getConnection() throws SQLException {
		if (cn == null) {
			cn = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
			cn.setAutoCommit (false);
			cn.setTransactionIsolation(1);
		}
		
		return cn;
	}
	
	public static void commitChanges() throws SQLException {
		cn.commit();
	}
	
	public static void rollbackChanges() throws SQLException {
		cn.rollback();
	}
	
}