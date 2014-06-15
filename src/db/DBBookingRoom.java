/**
 *
 */
package db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author david
 */
public interface DBBookingRoom {
    ResultSet getAll() throws SQLException;

    ResultSet getByDate(Date date) throws SQLException;

    int create() throws SQLException;

    boolean update() throws SQLException;

    boolean delete() throws SQLException;
}