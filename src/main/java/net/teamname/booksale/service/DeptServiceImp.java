package net.teamname.booksale.service;

import net.teamname.booksale.dao.DeptDao;
import net.teamname.booksale.domain.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created on 11/24/14 3:56 PM.
 *
 * @author: mithunshawon
 */
public class DeptServiceImp implements DeptService {
    private static final Logger log = LoggerFactory.getLogger(DeptServiceImp.class);

    private DeptDao deptDao = null;
    @Override
    public List<Department> getAllDept() {
        return null;
    }

    @Override
    public Department getDept(int deptID) {
        return deptDao.getDept(deptID);
    }
}
