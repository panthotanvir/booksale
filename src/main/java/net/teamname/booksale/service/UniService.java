package net.teamname.booksale.service;

import net.teamname.booksale.domain.University;

import java.util.List;

/**
 * Created by mithun on 11/15/14.
 */
public interface UniService {

    List<University> getAllUniversity();

    List<University> getAllDept();

    List<University> getSpecificUniDept(int uniId);

    public University getDept(int deptID);
}
