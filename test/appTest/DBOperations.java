/**
 * 
 */
package appTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.Assert;


import org.junit.Test;

import db.DBIface;
import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;

/**
 * @author david
 *
 */
public class DBOperations {

	@Test
	public void test() throws SQLException {
		try {
			//Create Room
			Room room = new Room();
			room.setDoubleRoom(false);
			room.setPrice(35.52);
			int roomId = room.create();
			System.out.println("Room with ID "+roomId+" created.");
			ResultSet rs = DBIface.executeQuery("SELECT * from Room where RID="+roomId);
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(roomId, rs.getInt(1));
			System.out.println("Room("+rs.getInt(1)+", "+rs.getDouble(2)+", "+rs.getBoolean(3)+")");
			
			//Create another Room
			Room room2 = new Room();
			room2.setDoubleRoom(true);
			room2.setPrice(23.10);
			int roomId2 = room2.create();
			System.out.println("Room with ID "+roomId2+" created.");
			rs = DBIface.executeQuery("SELECT * from Room where RID="+roomId2);
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(roomId2, rs.getInt(1));
			System.out.println("Room("+rs.getInt(1)+", "+rs.getDouble(2)+", "+rs.getBoolean(3)+")");
			
			//Update first Room
			room.setDoubleRoom(true);
			double price = 56.95;
			room.setPrice(price);
			room.update();
			System.out.println("Updated Room.");
			rs = DBIface.executeQuery("SELECT * from Room where RID="+roomId);
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(roomId, rs.getInt(1));
			Assert.assertEquals(price, rs.getDouble(2));
			Assert.assertEquals(true, rs.getBoolean(3));
			System.out.println("Room("+rs.getInt(1)+", "+rs.getDouble(2)+", "+rs.getBoolean(3)+")");
			
			//Create Service
			double servicePrice = 61.23;
			Service service = new Service("Massage normal", servicePrice);
			int serviceId = service.create();
			System.out.println("Service with ID "+serviceId+" created.");
			rs = DBIface.executeQuery("SELECT * from Service where SID="+serviceId);
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(serviceId, rs.getInt(1));
			System.out.println("Service("+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getDouble(3)+")");
			
			//Create another Service
			double servicePrice2 = 121.23;
			Service service2 = new Service("Massage happy finish", servicePrice2);
			int serviceId2 = service2.create();
			System.out.println("Service with ID "+serviceId2+" created.");
			rs = DBIface.executeQuery("SELECT * from Service where SID="+serviceId2);
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(serviceId2, rs.getInt(1));
			System.out.println("Service("+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getDouble(3)+")");
			
			//Update first Service
			servicePrice = 71.23;
			String serviceType = "Massage standard";
			service.setPrice(servicePrice);
			service.setType(serviceType);
			service.update();
			System.out.println("Updated Service.");
			rs = DBIface.executeQuery("SELECT * from Service where SID="+serviceId);
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(serviceId, rs.getInt(1));
			Assert.assertEquals(serviceType, rs.getString(2));
			Assert.assertEquals(servicePrice, rs.getDouble(3));
			System.out.println("Service("+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getDouble(3)+")");
			
			//Create Customer
			Customer customer = new Customer("Hans", "Meier", "Beispielstr. 123, 12345 Hintertupfing", Date.valueOf("1980-12-30"));
			customer.create();
			Customer customer2 = new Customer("Hans", "Meier", "Beispielstr. 123, 12345 Hintertupfing", Date.valueOf("1960-12-30"));
			customer2.create();
			
			//Update customer
			customer.setfName("Peter");
			customer.setlName("Huber");
			customer.setAddress("Lothstr. 1, 80123 München");
			customer.setBirthdate(Date.valueOf("1900-1-1"));
			customer.update();

			//Create 2 Bookings on Room and 1 Booking on Room2
			BookingRoom br = new BookingRoom(Date.valueOf("2014-2-1"),room,customer);
			br.create();
			System.out.println("BookingRoom with ID "+br.getBrid()+" created.");
			rs = DBIface.executeQuery("SELECT * from Booking_Room where BRID="+br.getBrid());
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(br.getBrid(), rs.getInt(1));
			Assert.assertEquals(br.getDate(), rs.getDate(2));
			Assert.assertEquals(br.getRoom().getRid(), rs.getInt(3));
			Assert.assertEquals(br.getCustomer().getId(), rs.getInt(4));
			
			BookingRoom br2 = new BookingRoom(Date.valueOf("2014-2-2"),room,customer2);
			br2.create();
			System.out.println("BookingRoom with ID "+br2.getBrid()+" created.");
			rs = DBIface.executeQuery("SELECT * from Booking_Room where BRID="+br2.getBrid());
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(br2.getBrid(), rs.getInt(1));
			Assert.assertEquals(br2.getDate(), rs.getDate(2));
			Assert.assertEquals(br2.getRoom().getRid(), rs.getInt(3));
			Assert.assertEquals(br2.getCustomer().getId(), rs.getInt(4));
			
			BookingRoom br3 = new BookingRoom(Date.valueOf("2015-10-30"),room2,customer);
			br3.create();
			System.out.println("BookingRoom with ID "+br3.getBrid()+" created.");
			rs = DBIface.executeQuery("SELECT * from Booking_Room where BRID="+br3.getBrid());
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(br3.getBrid(), rs.getInt(1));
			Assert.assertEquals(br3.getDate(), rs.getDate(2));
			Assert.assertEquals(br3.getRoom().getRid(), rs.getInt(3));
			Assert.assertEquals(br3.getCustomer().getId(), rs.getInt(4));
			
			//Create 2 Service Bookings
			BookingService bs = new BookingService(Date.valueOf("2015-10-30"),service,br3);
			bs.create();
			System.out.println("BookingService with ID "+bs.getBsid()+" created.");
			rs = DBIface.executeQuery("SELECT * from Booking_Service where BSID="+bs.getBsid());
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(bs.getBsid(), rs.getInt(1));
			Assert.assertEquals(bs.getDate(), rs.getDate(2));
			Assert.assertEquals(bs.getService().getSid(), rs.getInt(3));
			Assert.assertEquals(bs.getBookingRoom().getBrid(), rs.getInt(4));
			
			BookingService bs2 = new BookingService(Date.valueOf("2014-2-2"),service2,br2);
			bs2.create();
			System.out.println("BookingService with ID "+bs2.getBsid()+" created.");
			rs = DBIface.executeQuery("SELECT * from Booking_Service where BSID="+bs2.getBsid());
			rs.last();
			Assert.assertEquals(1, rs.getRow());
			Assert.assertEquals(bs2.getBsid(), rs.getInt(1));
			Assert.assertEquals(bs2.getDate(), rs.getDate(2));
			Assert.assertEquals(bs2.getService().getSid(), rs.getInt(3));
			Assert.assertEquals(bs2.getBookingRoom().getBrid(), rs.getInt(4));
			
			//Delete Customers
			customer.delete();
			customer2.delete();
			rs = DBIface.executeQuery("SELECT * from Customer where ID="+customer.getId()+" OR ID="+customer2.getId());
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("Customer "+customer.getId()+" deleted.");
			System.out.println("Customer "+customer.getId()+" deleted.");
			
			//Delete Services
			service.delete();
			rs = DBIface.executeQuery("SELECT * from Service where SID="+serviceId);
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("Service "+serviceId+" deleted.");
			service2.delete();
			rs = DBIface.executeQuery("SELECT * from Service where SID="+serviceId2);
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("Service "+serviceId2+" deleted.");
			
			//Delete Rooms
			room.delete();
			rs = DBIface.executeQuery("SELECT * from Room where RID="+roomId);
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("Room "+roomId+" deleted.");
			room2.delete();
			rs = DBIface.executeQuery("SELECT * from Room where RID="+roomId2);
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("Room "+roomId2+" deleted.");
			
			//Check cascaded deletion of bookings
			rs = DBIface.executeQuery("SELECT * FROM Booking_Room WHERE BRID="+br.getBrid()+" OR BRID="+br2.getBrid()+" OR BRID="+br3.getBrid());
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("BookingRooms deleted.");
			rs = DBIface.executeQuery("SELECT * FROM Booking_Service WHERE BSID="+bs.getBsid()+" OR BSID="+bs2.getBsid());
			rs.last();
			Assert.assertEquals(0, rs.getRow());
			System.out.println("BookingServices deleted.");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
