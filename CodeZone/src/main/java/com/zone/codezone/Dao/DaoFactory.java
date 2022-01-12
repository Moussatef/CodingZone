package com.zone.codezone.Dao;

import com.zone.codezone.DaoImpl.*;

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

    public static CompetanceDao getCompetenceDao(){
        return new CompetanceDao();
    }

    public static TestDao getTest(){
        return new TestDao();
    }


}

