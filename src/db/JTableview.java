/**
 * 
 */
package db;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * @author david
 * 
 */
public class JTableview {
	private JTable SQLTable = null;

	// 2. create JTable view based on a generic SQL query
	public JTableview(String SQLquery) {
		SQLTable = genSQLTable(SQLquery);
	}

	// update JTable view with new generic SQL query
	public void updateTable(String SQLquery) {
		SQLTable = genSQLTable(SQLquery);
	}

	// 4.1 return static JTable view
	public JTable getSQLTable() {
		return SQLTable;
	}

	// 3. based on the result set of the SQL query a JTable is created
	private JTable genSQLTable(String SQLquery) {
		// 3.1 create JTable
		int columnCount = 0;
		int cnt = 1;
		// initialize local JTable view
		JTable tableview = new JTable();
		tableview.enableInputMethods(false);
		tableview.setDragEnabled(false);
		tableview.setColumnSelectionAllowed(false);
		// selection of exact one field value
		// tableview.setColumnSelectionAllowed(true);
		tableview.setRowSelectionAllowed(true);
		tableview.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 3.2 create model and initialize model with reference to JTable view
		DefaultTableModel model = (DefaultTableModel) tableview.getModel();
		// initialize DB connection
		String sDbDriver = null, sDbUrl = null, sUsr = "", sPwd = "";
		// set access data for database connection
		sDbDriver = "com.mysql.jdbc.Driver";
		sDbUrl = "jdbc:mysql://localhost:3306/hotelverwaltung";
		sUsr = "hm";
		sPwd = "init";
		try {
			// select fitting database driver and connect
			Class.forName(sDbDriver);
			Connection cn = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
			System.out.println(cn.toString());
			Statement st = cn.createStatement();
			// use generic SQL query to get the result set
			ResultSet rs = st.executeQuery(SQLquery);
			// 3.3 fill model: identify column size of the result set
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
			// add column labels to the model
			for (int column = 1; column <= columnCount; column++) {
				model.addColumn(rsmd.getColumnLabel(column));
			}
			// add rows content to the model
			Object[] objects = new Object[columnCount];
			while (rs.next()) {
				cnt = 0;
				// add column content of next row to the model
				while (cnt < columnCount) {
					objects[cnt] = rs.getObject(cnt + 1);
					cnt++;
				}
				model.addRow(objects);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found: "+ex.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}
		// 3.4 set model content to JTable view and return JTable view
		tableview.setModel(model);
		return tableview;
	}

}
