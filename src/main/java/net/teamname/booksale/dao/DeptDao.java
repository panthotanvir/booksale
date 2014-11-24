package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Department;

import java.util.List;

/**
 * Created on 11/24/14 3:29 PM.
 *
 * @author: mithunshawon
 */
public interface DeptDao {

    List<Department> getAllDept();

    public Department getDept(int deptID);
}
