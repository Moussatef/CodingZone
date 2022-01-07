package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LearnDao implements DaoInterface<Learner> {

    List<Learner> learners;
    Learner learner;
    @Override
    public int delete(int id) {
        try {
            Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    SqlQueries.delete("learners", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Learner> findAll() {
        learners=new ArrayList<Learner>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("learners"));
            learners.clear();
            while (result.next()) {
                Learner learner = new Learner(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"));
                learners.add(learner);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return learners;
    }

    @Override
    public Learner findById(int id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("learners",id));
            if (result.first()) {
                 learner = new Learner(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"));


            }
            return learner;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Learner findByName(String name) {
        return null;
    }

    @Override
    public int insert(Learner learner) {

        return 0;
    }

    @Override
    public int update(Learner object) {
        return 0;
    }
}
