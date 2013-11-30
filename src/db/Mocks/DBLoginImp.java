package db.Mocks;

import db.DBLogin;

public class DBLoginImp implements DBLogin{

	@Override
	public boolean loginDB(String user, String pwd) {
		return true;
	}
	
}
