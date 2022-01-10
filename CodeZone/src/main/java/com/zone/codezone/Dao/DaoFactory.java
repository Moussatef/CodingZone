package com.zone.codezone.Dao;

import com.zone.codezone.DaoImpl.ChoiceDao;
import com.zone.codezone.DaoImpl.LearnDao;

import com.zone.codezone.DaoImpl.StaffDao;

import com.zone.codezone.Models.Learner;

public class DaoFactory {

    public static DaoInterface<Learner> getDaoLearner(){
        return new LearnDao();
    }

    public static StaffDao getDaoStaff(){
        return new StaffDao();
    }

    public  static ChoiceDao getDaoChoice(){
        return new ChoiceDao();
    }


}
