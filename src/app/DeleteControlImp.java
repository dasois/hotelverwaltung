package app;

import java.sql.SQLException;
import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;
/** Implementation of DeleteControlInterface */
public class DeleteControlImp<T> implements DeleteControlInterface<T>{

	@Override
	public boolean deleteEntity(T entity) throws SQLException {
		
		if(entity instanceof Customer){		
			CustomerControlInterface controller = new CustomerControlImp();
			Customer tmp = (Customer) entity;
			return controller.delete(tmp.getId());
		}
		else if(entity instanceof Room){
			RoomControlInterface controller = new RoomControlImp();
			Room tmp = (Room) entity;
			return controller.delete(tmp.getRid());
		}
		else if(entity instanceof Service){
			ServiceControlInterface controller = new ServiceControlImp();
			Service tmp = (Service) entity;
			return controller.delete(tmp.getSid());
		} else
			return false;
	}
}