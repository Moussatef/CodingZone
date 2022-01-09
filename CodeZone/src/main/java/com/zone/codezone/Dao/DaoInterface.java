package com.zone.codezone.Dao;

import java.util.List;

public interface DaoInterface<T> {


     int delete(int id);

     List<T> findAll();

     T findById(int id);

     T insert(T object);

     int update(T object);
}
