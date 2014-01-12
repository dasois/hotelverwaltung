/**
 * 
 */
package db.entities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import db.DBCustomer;
import db.DBIface;

/**
 * @author david
 *
 */
public class Customer implements DBCustomer{
	private int id;
	private String fName;
	private String lName;
	private String address;
	private Date birthdate;
	

	/**
	 * @param id: Id of the Customer. Leave NULL if you want to use auto_increment!
	 * @param fName: First name
	 * @param lName: Last name
	 * @param address: Customer's address, use syntax like: "Lothstr. xy, 80abc München"
	 * @param birthdate: Customer's date of birth
	 */
	public Customer(String fName, String lName, String address,
			Date date) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.birthdate = date;
	}
	public Customer(int id,String fName, String lName, String address,
			Date birthdate) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.birthdate = birthdate;
	}
	public Customer(){}
	public Customer(int id){this.id = id;}
	
	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Customer");
	}
	@Override
	public int create() throws SQLException {
		ResultSet rs = DBIface.executeQuery("Insert into Customer values ("+this.getId()+",\""+this.getfName()+"\",\""+this.getlName()+"\",\""+this.getAddress()+"\",\""+this.getBirthdate().toString()+"\")");
		if (rs.next()) {
			this.id = rs.getInt(1);
		}
		return this.getId();
	}
	@Override
	public boolean update() throws SQLException {
		DBIface.executeQuery(
			"Update Customer set "+
					"FName = \""+this.getfName()+
					"\",LName = \""+this.getlName()+
					"\",Address = \""+this.getAddress()+
					"\",BDate = \""+this.getBirthdate().toString()+
					"\" Where ID = "+this.getId()
		);
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Customer where id = "+this.getId());
		rs.next();
		if (rs.getInt(1)==1){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean delete() throws SQLException {
		DBIface.executeQuery("DELETE from Customer where id = "+this.getId());
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Customer where id = "+this.getId());
		rs.next();
		if (rs.getInt(1)==0){
			return true;
		}
		return false;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
