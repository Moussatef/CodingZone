package com.zone.codezone.Dao;

import com.zone.codezone.DaoImpl.QuestionDAO;
import com.zone.codezone.Models.Question;

import java.util.List;

public class DaoFactory {
    public static List<Question> getAllQuestions(){
        return new QuestionDAO().findAll();
    }
}
