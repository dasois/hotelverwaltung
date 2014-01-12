package app;

import java.sql.SQLException;

import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;


public class DeleteControlImp<T> implements DeleteControlInterface<T>{

	@Override
	public boolean deleteEntitie(T entitie) throws SQLException {
		
		if(entitie instanceof Customer){		
			CustomerControlInterface controller = new CustomerControlImp();
			Customer tmp = (Customer)entitie;
			return controller.delete(tmp.getId());
		}
		else if(entitie instanceof Room){
			RoomControlInterface controller = new RoomControlImp();
			Room tmp = (Room)entitie;
			return controller.delete(tmp.getRid());
		}
		else if(entitie instanceof Service){
			ServiceControlInterface controller = new ServiceControlImp();
			Service tmp = (Service)entitie;
			return controller.delete(tmp.getSid());
		}else
			return false;
	}
	
}
