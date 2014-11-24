package net.teamname.booksale.dao;


import net.teamname.booksale.domain.Department;
import net.teamname.booksale.util.DatabaseTemplate;
import net.teamname.booksale.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 11/24/14 3:30 PM.
 *
 * @author: mithunshawon
 */
public class DeptDaoImp implements  DeptDao {
    private static final Logger log = LoggerFactory.getLogger(DeptDaoImp.class);

    @Override
    public List<Department> getAllDept() {
        return null;
    }

    @Override
    public Department getDept(int deptID) {
        String query = "SELECT * FROM department WHERE dept_id = ' " + deptID + " ' ";

        List<Department> deptList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Department>() {
            @Override
            public Department mapRowToObject(ResultSet resultSet) throws SQLException {
                return setDepartment(resultSet);
            }
        });

        if (deptList.size() != 0) {
            log.debug("Department information returned");
            return deptList.get(0);
        }

        return null;
    }

    private Department setDepartment(ResultSet resultSet) throws SQLException {
        Integer deptId = Integer.parseInt(resultSet.getString("dept_id"));

        Department dept = new Department();
        dept.setDeptId(deptId);
        dept.setDeptName(resultSet.getString("dept_name"));

        return dept;
    }
}
