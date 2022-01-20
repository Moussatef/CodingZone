package com.zone.codezone.Dao;

import com.zone.codezone.DaoImpl.*;

import com.zone.codezone.Models.Learner;
import com.zone.codezone.Models.TestCandidat;
import com.zone.codezone.Models.TestResponse;

public class DaoFactory {

    public static LearnDao getDaoLearner(){
        return new LearnDao();
    }


    public  static TestResponseDao getDaoTestResponse(){
        return new TestResponseDao();
    }
    public static StaffDao getDaoStaff(){
        return new StaffDao();
    }
    public static ChoiceDao getDaoChoice(){
        return new ChoiceDao();
    }
    public static QuestionDAO getQuestions(){
        return new QuestionDAO();
    }
    public static CompetenceDao getCompetenceDao(){
        return new CompetenceDao();
    }
    public static  ClassDao getClassDao(){ return  new ClassDao();}
    public static  TestDao getTestDao(){ return  new TestDao();}
    public static TestCandidatDao getTestCandidateDao(){ return new TestCandidatDao();}
}

