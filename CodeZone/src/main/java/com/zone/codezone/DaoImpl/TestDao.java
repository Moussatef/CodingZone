package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.*;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zone.codezone.Dao.DaoFactory.getDaoChoice;

public class TestDao implements DaoInterface<Test> {
    List<Test> tests;
    Test test;
    @Override
    public String delete(String id) {
        try {
            Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    SqlQueries.delete("test", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public ArrayList<Test> findAll() {
        ArrayList<Test> tests = new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("tests"));

            while (result.next()) {
                Competence competence= DaoFactory.getCompetenceDao().findById(result.getString("competences_id"));
                Test test = new Test(result.getString("id"),result.getString("title"),result.getDate("start_date"),result.getDate("end_date"),competence);
                tests.add(test);
                System.out.println(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tests;
    }

    @Override
    public Test findById(String id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("tests",id));

            if (result.first()) {
                Competence competence= DaoFactory.getCompetenceDao().findById(result.getString("competences_id"));
                test = new Test(result.getString("id"),result.getString("title"),result.getDate("start_date"),result.getDate("end_date"),competence);


            }
            return test;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Test insert(Test test) {
        try {
            PreparedStatement testStatement = Config.getInstance().prepareStatement(SqlQueries.insert("tests", 5));

            testStatement.setString(1,test.getId());
            testStatement.setString(2,test.getTitle());
            testStatement.setDate(3,test.getStart_date());
            testStatement.setDate(4,test.getEnd_date());
            testStatement.setString(5,test.getCompetence().getId());
            testStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return test;
    }

    @Override
    public String update(Test test) {
        try {
            PreparedStatement testStatement = Config.getInstance().prepareStatement(SqlQueries.update("tests", new String[]{"id", "title","start_date","end_date","competence_id"},test.getId()));

            testStatement.setString(1,test.getId());
            testStatement.setString(2,test.getTitle());
            testStatement.setDate(3,test.getStart_date());
            testStatement.setDate(4,test.getStart_date());
            testStatement.setString(5,test.getCompetence().getId());
            testStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return test.getId();
    }

    public double getTestTotalScore(String id){
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getTestTotal(id));

            if (result.first()) {
                return result.getDouble("total_score");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return  0;
    }
}
