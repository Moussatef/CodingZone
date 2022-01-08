package com.zone.codezone.DaoImpl;

import com.zone.codezone.Dao.DaoInterface;
import com.zone.codezone.Models.Staff;
import com.zone.codezone.config.Config;

import java.sql.PreparedStatement;
import java.util.List;

public class StaffDao implements DaoInterface<Staff> {
    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Staff> findAll() {
        return null;
    }

    @Override
    public Staff findById(int id) {
        return null;
    }

    @Override
    public Staff findByName(String name) {
        return null;
    }

    @Override
    public Staff insert(Staff object) {
        return null;
    }

    @Override
    public int update(Staff object) {
        return 0;
    }

    // login
    public Boolean login(String username, String password){
        try {
            String query = "SELECT * FROM stuff WHERE username = '" + username + "' AND password = '" + password + "'";
            PreparedStatement preparedStatement = Config.getInstance().prepareStatement(query);
            preparedStatement.execute();
            return preparedStatement.getResultSet().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
