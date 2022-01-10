package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.Models.TestResponse;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zone.codezone.Dao.DaoFactory.getDaoChoice;

public class TestResponseDao implements DaoInterface<TestResponse> {

    List<TestResponse> responses;
    TestResponse testresponse;

    @Override
    public String delete(String id) {
        try {
            Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    SqlQueries.delete("test_response", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    @Override
    public List<TestResponse> findAll() {
        responses=new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("test_responses"));
            responses.clear();
            while (result.next()) {
                Choice choice=getDaoChoice().findById(result.getString("choice_id"));
                TestResponse response = new TestResponse(result.getString("id"),choice,result.getInt("timer"));
                responses.add(response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responses;
    }

    @Override
    public TestResponse findById(String id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("test_responses",id));

            if (result.first()) {
                Choice choice=getDaoChoice().findById(result.getString("choice_id"));
                 testresponse = new TestResponse(result.getString("id"),choice,result.getInt("timer"));

            }
            return testresponse;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public TestResponse insert(TestResponse response)  {
        try {
            PreparedStatement responseStatement = Config.getInstance().prepareStatement(SqlQueries.insert("test_responses", 4));

            responseStatement.setString(1,response.getId());
            responseStatement.setLong(2,response.getQuestion().getId());
            responseStatement.setString(3,response.getChoice().getId());
           // responseStatement.setString(4,response.getTestCandidate().getId());
            responseStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return response;
    }

    @Override
    public String update(TestResponse response) {
        try {
            PreparedStatement responseStatement = Config.getInstance().prepareStatement(SqlQueries.update("test_responses", new String[]{"id", "question_id","choice_id","test_candidats_id"}, response.getId()));
            responseStatement.setString(1,response.getId());
            responseStatement.setLong(2,response.getQuestion().getId());
            responseStatement.setString(3,response.getChoice().getId());
            // responseStatement.setString(4,response.getTestCandidate().getId());
            responseStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return response.getId();
    }
}
