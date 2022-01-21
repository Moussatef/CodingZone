package com.zone.codezone.Dao;


import java.sql.Connection;
import java.util.List;

public interface DaoInterface<T> {


     String delete(String id);

     List<T> findAll();

     T findById(String id);

     T insert(T object);


    // public Boolean login(String admin, String admin1);

     String update(T object);
}
