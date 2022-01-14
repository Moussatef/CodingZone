package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.*;
import com.zone.codezone.config.Config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.zone.codezone.Dao.DaoFactory.getDaoChoice;

public class TestCandidatDao implements DaoInterface<TestCandidat> {
    @Override
    public String delete(String id) {
        return null;
    }

    @Override
    public List<TestCandidat> findAll() {
        return null;
    }

    @Override
    public TestCandidat findById(String id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("test_candidates",id));

            if (result.first()) {

                TestCandidat testCandidate= new TestCandidat(result.getString("id"),result.getString("learner_code"),DaoFactory.getTestDao().findById(result.getString("test_id")),DaoFactory.getDaoLearner().findById(result.getString("learner_id")),result.getBoolean("isclosed"));
                return  testCandidate;
            }
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
        return null;
    }


    public TestCandidat findTestByCode(String code) {
        TestCandidat testCandidat=new TestCandidat();
        try {

            ResultSet queryResult = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAllWithWhere("test_learners","learner_code like '"+code+"'"));
            if (queryResult.first()) {
                 testCandidat=new TestCandidat(queryResult.getString("id"),queryResult.getString("learner_code"),DaoFactory.getTestDao().findById(queryResult.getString("test_id")), DaoFactory.getDaoLearner().findById(queryResult.getString("learner_id")),queryResult.getBoolean("isclosed"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
        return testCandidat;
    }

    @Override
    public TestCandidat insert(TestCandidat object) {
        return null;
    }

    @Override
    public String update(TestCandidat object) {
        return null;
    }
}
