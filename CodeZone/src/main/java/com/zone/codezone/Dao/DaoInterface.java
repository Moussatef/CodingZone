package com.zone.codezone.Dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {


    public int delete(int id);


    public List<T> findAll();

    public T findById(int id);

    public T findByName(String name);


    public T insert(T object);

    public int update(T object);
}
