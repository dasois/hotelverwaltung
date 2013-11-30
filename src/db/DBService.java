/**
 * 
 */
package db;
import app.entities.Service;

/**
 * @author david
 *
 */
public interface DBService {
	Service[] getAll();
	int create(Service srv);
	boolean update(int ServiceId, Service srv);
	boolean delete(int ServiceId);
}