/**
 * 
 */
package db.entities;

import db.DBCustomer;
import db.DBIface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author david
 *
 */
public class Customer implements DBCustomer{
    private int cid;
    private String fName;
	private String lName;
	private String address;
	private Date birthdate;
	private String title;


	/**
     * @param cid: Id of the Customer. Leave NULL if you want to use auto_increment!
     * @param fName: First name
	 * @param lName: Last name
	 * @param address: Customer's address, use syntax like: "Lothstr. xy, 80abc München"
	 * @param birthdate: Customer's date of birth
	 */
	public Customer(String fName, String lName, String address,
                    Date birthdate, String title) {
        this.fName = fName;
		this.lName = lName;
		this.address = address;
        this.birthdate = birthdate;
        this.title = title;
	}

    public Customer(int cid, String fName, String lName, String address,
                    Date birthdate, String title) {
        this.cid = cid;
        this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.birthdate = birthdate;
		this.title = title;
	}
	public Customer(){}

    public Customer(int cid) {
        this.cid = cid;
    }

	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Customer");
	}
	@Override
	public int create() throws SQLException {
        ResultSet rs = DBIface.executeQuery("Insert into Customer values (" + this.getCid() + ",\"" + this.getfName() + "\",\"" + this.getlName() + "\",\"" + this.getAddress() + "\",\"" + this.getBirthdate().toString() + "\",\"" + this.getTitle() + "\")");
        if (rs.next()) {
            this.cid = rs.getInt(1);
        }
        return this.getCid();
    }
	@Override
	public boolean update() throws SQLException {
		DBIface.executeQuery(
			"Update Customer set "+
					"FName = \""+this.getfName()+
					"\",LName = \""+this.getlName()+
					"\",Address = \""+this.getAddress()+
					"\",BDate = \""+this.getBirthdate().toString()+
					"\",Title = \""+this.getTitle()+
                    "\" Where CID = " + this.getCid()
        );
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Customer where cid = " + this.getCid());
        rs.next();
		if (rs.getInt(1)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete() throws SQLException {
        DBIface.executeQuery("DELETE from Customer where cid = " + this.getCid());
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Customer where cid = " + this.getCid());
        rs.next();
		if (rs.getInt(1)==0){
			return true;
		}
		return false;
	}

	/**
     * @return the cid
     */
    public int getCid() {
        return cid;
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
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }
	public String toString(){
        return "CId: " + cid + " Name " + fName + " " + lName + " Adresse: " + address + " Geb: " + birthdate + "\n";
    }
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
