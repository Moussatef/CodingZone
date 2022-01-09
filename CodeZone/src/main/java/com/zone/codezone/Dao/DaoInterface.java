package com.zone.codezone.Dao;

import java.util.List;

public interface DaoInterface<T> {


     String delete(String id);

     List<T> findAll();

     T findById(String id);

     T insert(T object);

     int update(T object);
}
