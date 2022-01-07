package com.zone.codezone.Dao;

import com.zone.codezone.DaoImpl.LearnDao;
import com.zone.codezone.Models.Learner;

public class DaoFactory {

    public  static DaoInterface<Learner> getDaoLearner(){
        return new LearnDao();
    }


}
