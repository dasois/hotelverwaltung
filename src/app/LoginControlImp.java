package app;

import java.sql.SQLException;
import db.DBIface;
/** Implementation of LoginControlInterface */
public class LoginControlImp extends AbstractTransactionController implements LoginControlInterface{

	public boolean loginDB(String user, String pwd) throws SQLException {
		return DBIface.loginDB(user, pwd);
	}
}