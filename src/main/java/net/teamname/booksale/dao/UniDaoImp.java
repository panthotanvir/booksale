package net.teamname.booksale.dao;

import net.teamname.booksale.domain.University;
import net.teamname.booksale.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by devil on 11/15/14.
 */
public class UniDaoImp implements UniDao {
    private static final Logger log = LoggerFactory.getLogger(UniDaoImp.class);


    @Override
    public List<University> getAllUniversity() {
        log.info("GetAllUniversityMethod Called ");

        String query = "SELECT * FROM university";
        List<University> uniList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<University>() {
            @Override
            public University mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUniversity(resultSet);
            }
        });

        log.info("Uni List Size : {} " , uniList.size());
        return uniList;
    }



    private University setUniversity(ResultSet resultSet) throws SQLException {
        University uni = new University();
        uni.setUniName(resultSet.getString("uni_name"));

        return uni;
    }

}
