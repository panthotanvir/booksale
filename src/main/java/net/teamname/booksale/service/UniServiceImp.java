package net.teamname.booksale.service;

import net.teamname.booksale.dao.*;
import net.teamname.booksale.domain.University;

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
}
