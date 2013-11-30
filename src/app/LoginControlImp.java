package app;

import db.DBLogin;
import db.Mocks.DBLoginImp;

public class LoginControlImp implements LoginControlInterface{


	public boolean loginDB(String user, String pwd) {
		DBLogin tmp = new DBLoginImp();
		return tmp.loginDB(user, pwd);
	}
}
