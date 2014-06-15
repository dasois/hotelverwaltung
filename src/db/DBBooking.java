package db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by david on 14.06.14.
 */
public interface DBBooking {
    ResultSet getAll() throws SQLException;

    ResultSet getAllByCustomer(int CustomerId) throws SQLException;

    ResultSet getRelatedServiceBookings() throws SQLException;

    ResultSet getRelatedRoomBookings() throws SQLException;

    int create() throws SQLException;

    boolean update() throws SQLException;

    boolean delete() throws SQLException;
}
