package net.teamname.booksale.dao;

import java.util.List;
import net.teamname.booksale.domain.University;

/**
 * Created by devil on 11/15/14.
 */
public interface UniDao {

    List<University> getAllUniversity();

    List<University> getAllDept();

    List<University> getSpecificUniDept(int uniId);

    public University getDept(int deptID);
}
