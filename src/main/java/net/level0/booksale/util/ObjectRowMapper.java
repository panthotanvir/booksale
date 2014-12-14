package net.level0.booksale.util;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by mithunshawon on 11/15/14.
 */
public interface ObjectRowMapper<E> {
    E mapRowToObject(ResultSet resultSet) throws SQLException;
}