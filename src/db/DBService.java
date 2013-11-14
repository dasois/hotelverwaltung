/**
 * 
 */
package db;
import app.Service;

/**
 * @author david
 *
 */
public interface DBService {
	JTableview getAll();
	int create(Service srv);
	boolean update(int ServiceId, Service srv);
	boolean delete(int ServiceId);
}