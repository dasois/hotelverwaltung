package app;

import java.sql.SQLException;

public interface TransactionInterface {
	public void saveChanges()throws SQLException;
	public void discardChanges()throws SQLException;
}
