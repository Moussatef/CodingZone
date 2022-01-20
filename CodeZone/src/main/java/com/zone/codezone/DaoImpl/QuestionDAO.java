package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DAO;
import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Competence;
import com.zone.codezone.Models.Question;
import com.zone.codezone.Models.Test;
import com.zone.codezone.config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionDAO extends DAO<Question> {
    Question question;
    Competence competence = new Competence("UU","DATABASE");
    Test test = new Test("vyyyuytg","Test", Date.valueOf("2002-10-10"),Date.valueOf("2010-10-10"),competence);

    public List<Question> findAll() {

        String query = "SELECT * FROM questions";
        List<Question> questionsList = new ArrayList<>();
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                questionsList.add(new Question(queryResult.getString("id"), queryResult.getString("content"), queryResult.getInt("time_s"), queryResult.getFloat("score"),test));
            }

            return questionsList;

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return questionsList;
    }


    public List<Question> findQuestionsByTest(String id) {
        List<Question> testQuestions = new ArrayList<>();
        testQuestions.clear();
        try {
            Statement statement = connectDB.createStatement();
            System.out.println(SqlQueries.getAllWithWhere("questions","test_id like '"+id+"'"));
            ResultSet queryResult = statement.executeQuery(SqlQueries.getAllWithWhere("questions","test_id like '"+id+"'"));
            while (queryResult.next()) {
                Test test= DaoFactory.getTestDao().findById(queryResult.getString("test_id"));
                testQuestions.add(new Question(queryResult.getString("id"), queryResult.getString("content"), queryResult.getInt("time_s"), queryResult.getFloat("score"),test));
            }

            return testQuestions;

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return testQuestions;
    }

    @Override
    public Question find(String id) {

        try {

            ResultSet queryResult = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("questions",id));
            if (queryResult.first()) {
                //add question
                question = new Question(queryResult.getString("id"), queryResult.getString("content"), queryResult.getInt("time_s"), queryResult.getFloat("score"),test);

            }
            return question;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }


    }

    @Override
    public Question create(Question questionInsert) {
        try {
            PreparedStatement questionStatement = Config.getInstance().prepareStatement(SqlQueries.insert("questions", 5));
            questionStatement.setString(1,questionInsert.getId());
            questionStatement.setString(2,questionInsert.getContent());
            questionStatement.setInt(3,questionInsert.getTime());
            questionStatement.setString(4,questionInsert.getTest().getId());
            questionStatement.setDouble(5,questionInsert.getScore());
            System.out.println(questionStatement);
            questionStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
        return questionInsert;
    }

    @Override
    public String update(Question questionUpdate) {
        try {
            PreparedStatement questionStatement = Config.getInstance().prepareStatement(SqlQueries.update("questions", new String[]{ "content","time","score","test_id"}, questionUpdate.getId()));

            questionStatement.setString(1,questionUpdate.getContent());
            questionStatement.setInt(2,questionUpdate.getTime());
            questionStatement.setString(3,questionUpdate.getTest().getId());
            questionStatement.setDouble(4,questionUpdate.getScore());
            questionStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return questionUpdate.getId();
    }

    @Override
    public void delete(Question obj) {

    }


}
