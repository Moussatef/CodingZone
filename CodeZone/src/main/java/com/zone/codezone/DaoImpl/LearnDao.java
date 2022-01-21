package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Helpers.UuidHelper;
import com.zone.codezone.Models.ClassLearner;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LearnDao implements DaoInterface<Learner> {

    List<Learner> learners;
    Learner learner;
    @Override
    public String delete(String id) {
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
                ClassLearner classLearner=DaoFactory.getClassDao().findById(result.getString("class_id"));
               Learner learner = new Learner(result.getString("id"), result.getString("first_name"), result.getString("last_name"), result.getString("email"),classLearner);
                learners.add(learner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return learners;
    }

    @Override
    public Learner findById(String id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("learners",id));
            if (result.first()) {
                ClassLearner classLearner=DaoFactory.getClassDao().findById(result.getString("class_id"));
                 learner = new Learner(result.getString("id"), result.getString("first_name"), result.getString("last_name"), result.getString("email"),classLearner);


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
            String id=UuidHelper.getUuiId();
            while (Objects.nonNull(findById(id))){
                id=UuidHelper.getUuiId();
            }
            PreparedStatement personStatement = Config.getInstance().prepareStatement(SqlQueries.insert("learners", 5));

            personStatement.setString(1,learner.getFirstName());
            personStatement.setString(2,learner.getLastName());
            personStatement.setString(3,learner.getEmail());
            personStatement.setString(4,learner.getClassLearner().getId());
            personStatement.setString(5,id);
            System.out.println(personStatement);
            personStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return learner;
    }

    @Override
    public String update(Learner learner) {
        try {
            PreparedStatement personStatement = Config.getInstance().prepareStatement(SqlQueries.update("learners", new String[]{"id", "firstname","lastname","email","class_id"}, learner.getId()));
            personStatement.setString(1,learner.getId());
            personStatement.setString(2,learner.getFirstName());
            personStatement.setString(3,learner.getLastName());
            personStatement.setString(4,learner.getEmail());
            personStatement.setString(5,learner.getClassLearner().getId());
            personStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return learner.getId();
    }


    public String findEmailByCode(String code) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getLearnerByCode(code));
            if (result.first()) {
                return result.getString("email");
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
        return "";
    }

}
