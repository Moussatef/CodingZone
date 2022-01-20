package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Helpers.SqlQueries;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.Models.Question;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoiceDao implements DaoInterface<Choice> {


    Choice choice;
    List<Choice> choices;

    @Override
    public String delete(String id) {
        try {
            Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    SqlQueries.delete("choices", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    @Override
    public List<Choice> findAll() {
        choices=new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAll("choices"));
            choices.clear();
            while (result.next()) {
                Question question= DaoFactory.getQuestions().find(result.getString("question_id"));
                Choice choice =new Choice(result.getString("id"),result.getString("content"),result.getBoolean("iscorrect"),question);
                choices.add(choice);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return choices;
    }


    public List<Choice> getQuestionChoices(String id) {
        choices=new ArrayList<>();
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getAllWithWhere("choices","question_id like '"+id+"'"));
            System.out.println(SqlQueries.getAllWithWhere("choices","question_id like '"+id+"'"));
            choices.clear();
            while (result.next()) {
                Question question= DaoFactory.getQuestions().find(result.getString("question_id"));
                Choice choice =new Choice(result.getString("id"),result.getString("content"),result.getBoolean("iscorrect"),question);
                choices.add(choice);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return choices;
    }


    @Override
    public Choice findById(String  id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    SqlQueries.getById("choices",id));
            if (result.first()) {
                Question question= DaoFactory.getQuestions().find(result.getString("question_id"));
                choice = new Choice(result.getString("id"),result.getString("content"),result.getBoolean("iscorrect"),question);

            }
            return choice;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }


    @Override
    public Choice insert(Choice choice) {
        try {
            PreparedStatement choiceStatement = Config.getInstance().prepareStatement(SqlQueries.insert("choices", 4));

            choiceStatement.setString(1,choice.getId());
            choiceStatement.setString(2,choice.getContent());
            choiceStatement.setBoolean(3,choice.isCorrect());
            choiceStatement.setString(4,choice.getQuestion().getId());
            System.out.println(choiceStatement);
            choiceStatement.executeUpdate();
        }
        catch (SQLException  e){
            e.printStackTrace();

        }
        return choice;
    }


    @Override
    public String update(Choice choice) {
        try {
            PreparedStatement choiceStatement = Config.getInstance().prepareStatement(SqlQueries.update("choices", new String[]{"id", "content","iscorrect","questin_id"}, choice.getId()));
            choiceStatement.setString(1,choice.getId());
            choiceStatement.setString(2,choice.getContent());
            choiceStatement.setBoolean(3,choice.isCorrect());
            choiceStatement.setString(4,choice.getQuestion().getId());
            choiceStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return choice.getId();
    }
}
