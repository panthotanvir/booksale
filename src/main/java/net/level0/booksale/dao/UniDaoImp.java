package net.level0.booksale.dao;

import net.level0.booksale.domain.University;
import net.level0.booksale.util.*;
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

    @Override
    public List<University> getAllDept() {
        log.info("GetAllDeptMethod Called ");

        String query = "SELECT * FROM department";
        List<University> deptList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<University>() {
            @Override
            public University mapRowToObject(ResultSet resultSet) throws SQLException {
                return setDepartment(resultSet);
            }
        });

        log.info("Dept List Size : {} " , deptList.size());
        return deptList;
    }

    private University setDepartment(ResultSet resultSet) throws SQLException {
        Integer deptId = Integer.parseInt(resultSet.getString("dept_id"));
        University dept = new University();
        dept.setDeptId(deptId);
        dept.setDeptName(resultSet.getString("dept_name"));

        return dept;
    }

    @Override
    public List<University> getSpecificUniDept(int uniId) {
        String query = "SELECT * FROM department where uni_id = '"+uniId+"' ";
        List<University> uniList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<University>() {
            @Override
            public University mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUniDept(resultSet);
            }
        });

        log.info("Uni List Size : {} " , uniList.size());
        return uniList;
    }

    private University setUniDept(ResultSet resultSet) throws SQLException {
        Integer uniId = Integer.parseInt(resultSet.getString("uni_id"));
        Integer deptId = Integer.parseInt(resultSet.getString("dept_id"));

        University dept = new University();
        dept.setId(uniId);
        dept.setDeptId(deptId);
        dept.setDeptName(resultSet.getString("dept_name"));
        dept.setUniName(resultSet.getString("uni_name"));
        return dept;
    }

    @Override
    public University getDept(int deptID) {
        return null;
    }


    private University setUniversity(ResultSet resultSet) throws SQLException {

        Integer uniId = Integer.parseInt(resultSet.getString("uni_id"));

        University uni = new University();
        uni.setUniName(resultSet.getString("uni_name"));
        uni.setId(uniId);

        return uni;
    }

}
