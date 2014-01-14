package app;

import java.sql.SQLException;

public interface DeleteControlInterface<T> {
	boolean deleteEntity(T entity) throws SQLException;
}
