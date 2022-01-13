package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DAO;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Question;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QuestionDAO extends DAO<Question> {
    Question question;

    public List<Question> findAll() {
        String query = "SELECT * FROM questions";
        List<Question> questionsList = new ArrayList<>();
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            while (queryResult.next()) {
                questionsList.add(new Question(queryResult.getString("id"), queryResult.getString("content"), queryResult.getInt("time_s"), queryResult.getFloat("score")));
            }

            return questionsList;

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return questionsList;
    }



    @Override
    public Question find(String id) {

        try {

            ResultSet queryResult = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("questions",id));
            if (queryResult.first()) {
                //add question
                question = new Question(queryResult.getString("id"), queryResult.getString("content"), queryResult.getInt("time_s"), queryResult.getFloat("score"));

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
            questionStatement.setFloat(4,questionInsert.getScore());
            questionStatement.setInt(5,questionInsert.getTest().getId());
            System.out.println(questionStatement);
            questionStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return questionInsert;
    }

    @Override
    public Question update(Question obj) {
        return null;
    }

    @Override
    public void delete(Question obj) {

    }


}
