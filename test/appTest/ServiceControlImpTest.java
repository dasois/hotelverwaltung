package test.appTest;

import app.ServiceControlImp;
import db.DBIface;
import db.entities.Service;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.AccessDeniedException;
import java.sql.ResultSet;
import java.util.Random;

public class ServiceControlImpTest {


    private ServiceControlImp serviceControl;

    @Before
    public void setUp() throws Exception {
        boolean loggedIn = DBIface.loginDB("hm", "init");
        if (!loggedIn) {
            throw new AccessDeniedException("Wrong DB login credentials.");
        }
        serviceControl = new ServiceControlImp();
    }

    @After
    public void tearDown() throws Exception {
        //DBIface.rollbackChanges();
    }

    @Test
    public void testGetAll() throws Exception {
        ResultSet servicesResultSet = DBIface.executeQuery("SELECT * FROM Service");
        servicesResultSet.last();
        int servicesInDB = servicesResultSet.getRow();
        Assert.assertEquals(serviceControl.getAll().size(), servicesInDB);
        //System.out.println(serviceControl.getAll().size());
        //System.out.println(servicesInDB);
        Service testService = new Service("TestService", 123.12);
        testService.create();
        Assert.assertEquals(serviceControl.getAll().size(), servicesInDB+1);
        testService.delete();
        Assert.assertEquals(serviceControl.getAll().size(), servicesInDB);
    }

    @Test
    public void testCreate() throws Exception {
        Service service = new Service();
        ResultSet services = service.getAll();
        services.last();
        int numServices = services.getRow();
        int service2Id = serviceControl.create("Test Service 1&$", 10.00);
        ResultSet service2 = service.getAll();
        service2.last();
        Assert.assertEquals(service2.getRow(), numServices+1); // there is one more service in the DB
        Assert.assertNotEquals(service2.getInt(1), 0); // ID generated correctly
        Assert.assertEquals(service2.getString(2), "Test Service 1&$");
        Assert.assertEquals(service2.getDouble(3), 10.00, 0.009);
        int service3Id = serviceControl.create("Test Free Service", 00.00);
        ResultSet service3 = service.getAll();
        service3.last();
        Assert.assertEquals(service3.getRow(), numServices+2); // there is one more service in the DB
        Assert.assertNotEquals(service3.getInt(1), 0); // ID generated correctly
        Assert.assertEquals(service3.getString(2), "Test Free Service");
        Assert.assertEquals(service3.getDouble(3), 0.00, 0.009);
        new Service(service2Id).delete();
        new Service(service3Id).delete();
        services = service.getAll();
        services.last();
        Assert.assertEquals(services.getRow(), numServices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCreateWithNegativePrice() throws Exception{
        serviceControl.create("Test Negative Price", -01.00);
    }

    @Test
    public void testUpdate() throws Exception {
        int numServices = serviceControl.getAll().size();
        int service2Id = serviceControl.create("Test Service 1&$", 10.00);
        ResultSet newService = DBIface.executeQuery("SELECT * FROM Service WHERE SID="+service2Id);
        newService.last();
        Assert.assertEquals(1, newService.getRow());
        Assert.assertEquals("Test Service 1&$", newService.getString(2));
        Assert.assertEquals(10.00, newService.getDouble(3), 0.009);
        serviceControl.update(new Service(service2Id, "Updated Name", 100.00));
        newService = DBIface.executeQuery("SELECT * FROM Service WHERE SID="+service2Id);
        newService.last();
        Assert.assertEquals(1, newService.getRow());
        Assert.assertEquals("Updated Name", newService.getString(2));
        Assert.assertEquals(100.00, newService.getDouble(3), 0.009);
        new Service(service2Id).delete();
        Assert.assertEquals(serviceControl.getAll().size(), numServices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUpdateToNegativePrice() throws Exception {
        int numServices = serviceControl.getAll().size();
        int service2Id = serviceControl.create("Test Service 1&$", 10.00);
        try{
            ResultSet newService = DBIface.executeQuery("SELECT * FROM Service WHERE SID="+service2Id);
            newService.last();
            Assert.assertEquals(1, newService.getRow());
            Assert.assertEquals("Test Service 1&$", newService.getString(2));
            Assert.assertEquals(10.00, newService.getDouble(3), 0.009);
            serviceControl.update(new Service(service2Id, "Updated Name", -100.00));
            newService = DBIface.executeQuery("SELECT * FROM Service WHERE SID="+service2Id);
            newService.last();
            Assert.assertEquals(1, newService.getRow());
            Assert.assertEquals("Updated Name", newService.getString(2));
            Assert.assertEquals(-100.00, newService.getDouble(3), 0.009);
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            new Service(service2Id).delete();
            Assert.assertEquals(serviceControl.getAll().size(), numServices);
        }
    }

    @Test
    public void testDelete() throws Exception {
        int serviceId = serviceControl.create("Test service", 100.00);
        boolean result = serviceControl.delete(serviceId);
        ResultSet newService = DBIface.executeQuery("SELECT * FROM Service WHERE SID="+serviceId);
        newService.last();
        Assert.assertEquals(0, newService.getRow());
        Assert.assertEquals(result, true);
        int row, freeServiceId;
        do {
            freeServiceId = new Random().nextInt();
            newService = DBIface.executeQuery("SELECT * FROM Service WHERE SID="+ freeServiceId);
            newService.last();
            row = newService.getRow();
        } while (row > 0);
        Assert.assertEquals(true, serviceControl.delete(freeServiceId));
    }
}