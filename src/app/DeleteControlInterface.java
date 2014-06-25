package app;

import java.sql.SQLException;
/** interface for using the db from inside the app-layer
*	This is for the entities room,service and customer*/
public interface DeleteControlInterface<T> extends TransactionInterface{
	boolean deleteEntity(T entity) throws SQLException;
}