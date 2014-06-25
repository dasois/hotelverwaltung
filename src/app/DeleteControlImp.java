package app;

import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;

import java.sql.SQLException;

/**
 * Implementation of DeleteControlInterface
 */
public class DeleteControlImp<T> implements DeleteControlInterface<T> {

    @Override
    public boolean deleteEntity(T entity) throws SQLException {

        if (entity instanceof Customer) {
            CustomerControlInterface controller = new CustomerControlImp();
            Customer tmp = (Customer) entity;
            return controller.delete(tmp.getCid());
        } else if (entity instanceof Room) {
            RoomControlInterface controller = new RoomControlImp();
            Room tmp = (Room) entity;
            return controller.delete(tmp.getRid());
        } else if (entity instanceof Service) {
            ServiceControlInterface controller = new ServiceControlImp();
            Service tmp = (Service) entity;
            return controller.delete(tmp.getSid());
        } else
        	System.out.println("hier");
            return false;
    }
}