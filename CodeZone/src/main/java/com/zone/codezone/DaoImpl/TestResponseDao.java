package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Helpers.UuidHelper;
import com.zone.codezone.Models.*;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
               // Test test=new Test();
                TestCandidat testCandidat=DaoFactory.getTestCandidateDao().findById(result.getString("test_candidats_id"));
                Question question= DaoFactory.getQuestions().find(result.getString("question_id"));
                TestResponse response = new TestResponse(result.getString("id"),question,choice,result.getInt("timer"),testCandidat);
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
               Question question= DaoFactory.getQuestions().find(result.getString("question_id"));
                TestCandidat testCandidat=DaoFactory.getTestCandidateDao().findById(result.getString("test_candidats_id"));
                 testresponse = new TestResponse(result.getString("id"),question,choice,result.getInt("timer"),testCandidat);

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

            String id= UuidHelper.getUuiId();
            while (Objects.nonNull(findById(id))){
                id=UuidHelper.getUuiId();
            }
            PreparedStatement responseStatement = Config.getInstance().prepareStatement(SqlQueries.insert("test_responses", 5));

            responseStatement.setString(1,id);
            responseStatement.setString(2,response.getTestCondidat().getId());
            responseStatement.setString(3,response.getQuestion().getId());
            responseStatement.setString(4,response.getChoice().getId());
            responseStatement.setInt(5,response.getTimerResponse());
            System.out.println(responseStatement);
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
            responseStatement.setString(2,response.getQuestion().getId());
            responseStatement.setString(3,response.getChoice().getId());
            // responseStatement.setString(4,response.getTestCandidate().getId());
            responseStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return response.getId();
    }
}
