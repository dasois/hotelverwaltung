package app;

import java.sql.SQLException;

public interface LoginControlInterface {
	boolean loginDB(String user, String pwd) throws SQLException;
}

