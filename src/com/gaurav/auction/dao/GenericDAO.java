/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericDAO<T> {
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
}
