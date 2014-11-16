package net.teamname.booksale.util;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by devil on 11/15/14.
 */
public interface ObjectRowMapper<E> {
    E mapRowToObject(ResultSet resultSet) throws SQLException;
}