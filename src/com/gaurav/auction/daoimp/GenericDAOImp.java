/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.daoimp;

import com.gaurav.auction.dao.GenericDAO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public abstract class GenericDAOImp<T> implements GenericDAO<T>{

    @Override
    public void insert(T t) throws SQLException {
        
    }

    @Override
    public void update(T t) throws SQLException {
        
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<T> getAll() throws SQLException {
        return null;
    }

    @Override
    public T getById(int id) throws SQLException {
        return null;
    }
    
}
