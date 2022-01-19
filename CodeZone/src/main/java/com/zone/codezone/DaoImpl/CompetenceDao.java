package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Competence;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompetenceDao implements DaoInterface<Competence> {
    List<Competence> competences;
    Competence competence;

    @Override
    public String delete(String id) {

        try {
            Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    SqlQueries.delete("competences", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public ArrayList<Competence> findAll() {
        ArrayList competences = new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("competences"));
            competences.clear();
            while (result.next()) {
                Competence competence = new Competence(result.getString("id"), result.getString("competence_name"));
                competences.add(competence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return competences;
    }

    @Override
    public Competence findById(String id) {
        try {
            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("competences", id));

            if(result.next()){
                competence = new Competence(result.getString("id"), result.getString("competence_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return competence;
    }

    @Override
    public Competence insert(Competence competence) {
        try {
            PreparedStatement competenceStatement = Config.getInstance().prepareStatement(SqlQueries.insert("competences", 2));

            competenceStatement.setString(1,competence.getId());
            competenceStatement.setString(2,competence.getCompetence_name());
            competenceStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return competence;
    }

    @Override
    public String update(Competence competence) {
        try {
            PreparedStatement competenceStatement = Config.getInstance().prepareStatement(SqlQueries.update("competences", new String[]{"id", "competence_name"}, competence.getId()));
            competenceStatement.setString(1,competence.getId());
            competenceStatement.setString(2,competence.getCompetence_name());
            competenceStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return " ";
    }
}
