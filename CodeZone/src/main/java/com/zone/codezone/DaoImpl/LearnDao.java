package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
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
        learners=new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("learners"));
            learners.clear();
            while (result.next()) {
                Learner learner = new Learner(result.getString("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"),result.getInt("class_id"));
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
                 learner = new Learner(result.getString("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"),result.getInt("class_id"));


            }
            return learner;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Learner insert(Learner learner)  {
        try {
            PreparedStatement personStatement = Config.getInstance().prepareStatement(SqlQueries.insert("learners", 5));

            personStatement.setString(1,learner.getFirstName());
            personStatement.setString(2,learner.getLastName());
            personStatement.setString(3,learner.getEmail());
            personStatement.setInt(4,learner.getClassLearner());
            personStatement.setString(5,learner.getId());
            System.out.println(personStatement);
            personStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return learner;
    }

    @Override
    public int update(Learner learner) {
        try {
            PreparedStatement personStatement = Config.getInstance().prepareStatement(SqlQueries.update("learners", new String[]{"id", "firstname","lastname","email"}, learner.getId()));
            personStatement.setString(1,learner.getId());
            personStatement.setString(2,learner.getFirstName());
            personStatement.setString(3,learner.getLastName());
            personStatement.setString(4,learner.getEmail());
            personStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
