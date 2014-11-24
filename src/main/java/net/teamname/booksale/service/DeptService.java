package net.teamname.booksale.service;

import net.teamname.booksale.domain.Department;

import java.util.List;

/**
 * Created on 11/24/14 3:55 PM.
 *
 * @author: mithunshawon
 */
public interface DeptService {

    List<Department> getAllDept();

    public Department getDept(int deptID);
}
