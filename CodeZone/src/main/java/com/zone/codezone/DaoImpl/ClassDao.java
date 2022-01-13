package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.ClassLearner;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDao implements DaoInterface<ClassLearner> {

    List<ClassLearner> classes;
    ClassLearner classLearner;

    @Override
    public String delete(String id) {
        try {
            Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    SqlQueries.delete("classes", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<ClassLearner> findAll() {
        classes=new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("classes"));
            classes.clear();
            while (result.next()) {

                ClassLearner classLearner = new ClassLearner(result.getString("id"),result.getString("class_name"));
                classes.add(classLearner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    @Override
    public ClassLearner findById(String id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("classes",id));
            if (result.first()) {
                classLearner =  new ClassLearner(result.getString("id"),result.getString("class_name"));

            }
            return classLearner;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public ClassLearner insert(ClassLearner classLearner) {

        try {
            PreparedStatement classStatement = Config.getInstance().prepareStatement(SqlQueries.insert("classes", 2));

            classStatement.setString(1,classLearner.getId());
            classStatement.setString(2,classLearner.getClass_name());
            classStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return classLearner;
    }

    @Override
    public String update(ClassLearner classLearner) {

        try {
            PreparedStatement classStatement = Config.getInstance().prepareStatement(SqlQueries.update("classes", new String[]{"id", "class_name"}, classLearner.getId()));
            classStatement.setString(1,classLearner.getId());
            classStatement.setString(2,classLearner.getClass_name());
            classStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return classLearner.getId();
    }
}
