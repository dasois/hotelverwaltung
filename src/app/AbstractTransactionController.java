package app;

import java.sql.SQLException;

import db.DBIface;

public abstract class AbstractTransactionController implements TransactionInterface {
	public void saveChanges() throws SQLException{
		DBIface.commitChanges();
	}
	public void discardChanges() throws SQLException{
		DBIface.rollbackChanges();
	}
}
