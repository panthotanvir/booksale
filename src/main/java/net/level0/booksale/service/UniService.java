package net.level0.booksale.service;

import net.level0.booksale.domain.University;

import java.util.List;

/**
 * Created by mithunshawon on 11/15/14.
 */
public interface UniService {

    List<University> getAllUniversity();

    List<University> getAllDept();

    List<University> getSpecificUniDept(int uniId);

    public University getDept(int deptID);
}
