package app;

import app.entities.Customer;
import app.entities.HotelRoom;
import app.entities.Service;

public class DeleteControlImp<T> implements DeleteControlInterface<T>{

	@Override
	public boolean deleteEntitie(T entitie) {
		
		if(entitie instanceof Customer){		
			CustomerControlInterface controller = new CustomerControlImp();
			Customer tmp = (Customer)entitie;
			return controller.delete(tmp.getCustomerId());
		}
		else if(entitie instanceof HotelRoom){
			RoomControlInterface controller = new RoomControlImp();
			HotelRoom tmp = (HotelRoom)entitie;
			return controller.delete(tmp.getRoomId());
		}
		else if(entitie instanceof Service){
			ServiceControlInterface controller = new ServiceControlImp();
			Service tmp = (Service)entitie;
			return controller.delete(tmp.getServiceId());
		}else
			return false;
	}
	
}
