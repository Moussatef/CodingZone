package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DAO;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Models.Question;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO extends DAO<Question> {


    public List<Question> findAll(){
        System.out.println("TEEESTTTTTT");
        String query = "SELECT * FROM questions";
        List<Question> questionsList = new ArrayList<>();
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                questionsList.add(new Question(queryResult.getString("id"),queryResult.getString("content"),queryResult.getInt("time_s"),queryResult.getFloat("score")));
            }
            System.out.println("ID : "+queryResult.getString("id"));

            return questionsList;

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return questionsList;

    }

    @Override
    public Question find(int id) {

        return null;
    }

    @Override
    public Question create(Question obj) {
        return null;
    }

    @Override
    public Question update(Question object) {
        return null;
    }

    @Override
    public void delete(Question obj) {

    }
}
