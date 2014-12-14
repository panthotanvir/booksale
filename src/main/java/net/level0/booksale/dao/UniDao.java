package net.level0.booksale.dao;

import java.util.List;
import net.level0.booksale.domain.University;

/**
 * Created by mithunshawon on 11/15/14.
 */
public interface UniDao {

    List<University> getAllUniversity();

    List<University> getAllDept();

    List<University> getSpecificUniDept(int uniId);

    public University getDept(int deptID);

}
