package com.zone.codezone.Dao;

import com.zone.codezone.DaoImpl.QuestionDAO;

import com.zone.codezone.DaoImpl.ChoiceDao;
import com.zone.codezone.DaoImpl.LearnDao;

import com.zone.codezone.DaoImpl.StaffDao;

import com.zone.codezone.DaoImpl.TestResponseDao;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.Models.TestResponse;

public class DaoFactory {

    public static DaoInterface<Learner> getDaoLearner(){
        return new LearnDao();
    }

    public  static DaoInterface<TestResponse> getDaoTestResponse(){
        return new TestResponseDao();
    }


    public static StaffDao getDaoStaff(){
        return new StaffDao();
    }

    public  static ChoiceDao getDaoChoice(){
        return new ChoiceDao();
    }

    public static QuestionDAO getQuestions(){
        return new QuestionDAO();
    }


}

