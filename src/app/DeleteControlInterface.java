package app;

import java.sql.SQLException;

public interface DeleteControlInterface<T> {
	boolean deleteEntitie(T entitie) throws SQLException;
}
