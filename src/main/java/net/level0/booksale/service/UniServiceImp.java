package net.level0.booksale.service;

import net.level0.booksale.dao.*;
import net.level0.booksale.domain.University;

import java.util.List;

/**
 * Created by devil on 11/15/14.
 */
public class UniServiceImp implements UniService {
    private UniDao uniDao = null;

    public UniServiceImp(){
        this.uniDao = new UniDaoImp();
    }

    @Override
    public List<University> getAllUniversity() {
        return  uniDao.getAllUniversity();

    }

    @Override
    public List<University> getAllDept() {
        return uniDao.getAllDept();
    }

    @Override
    public List<University> getSpecificUniDept(int uniId) {
        return  uniDao.getSpecificUniDept(uniId);
    }

    @Override
    public University getDept(int deptID) {
        return null;
    }
}
