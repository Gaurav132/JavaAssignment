/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.daoimp;

import com.gaurav.auction.dao.GenericDAO;
import com.gaurav.auction.database.DBConnection;
import com.gaurav.auction.entity.UserProfile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nishan Dhungana
 */
public class UserProfileDAOImp implements GenericDAO<UserProfile>{

    private PreparedStatement pst;
    private ResultSet res;
    
    public UserProfileDAOImp() {
        
    }
    
    @Override
    public void insert(UserProfile t) throws SQLException {
        final String sql = "INSERT INTO tbl_user_profile VALUES(?, ?, ?, ?);";
        DBConnection.getConnection().setAutoCommit(false);
        
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, t.getFullName());
            pst.setString(2, t.getContact());
            pst.setString(3, t.getUsername());
            pst.setString(4, t.getUsername());
            
            pst.executeUpdate();
            DBConnection.getConnection().commit();
            
        } catch(SQLException ex) {
            DBConnection.getConnection().rollback();
            throw new SQLException(ex);
        } finally {
            DBConnection.getConnection().close();
        }
    }

    @Override
    public void update(UserProfile t) throws SQLException {
        
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<UserProfile> getAll() throws SQLException {
        return null;
    }

    @Override
    public UserProfile getById(int id) throws SQLException {
        return null;
    }
    
    public boolean isLogin(String username, String password) throws SQLException {
        final String query = "SELECT * FROM tbl_user_profile WHERE username = ? AND password = ?";
        DBConnection.getConnection().setAutoCommit(false);
        
        try {
            pst = DBConnection.getConnection().prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            
            res = pst.executeQuery();
            
            while(res.next()) {
                return true;
            }
            
            DBConnection.getConnection().commit();
            
        } catch(SQLException ex) {
            DBConnection.getConnection().rollback();
            throw new SQLException(ex);
        } finally {
            DBConnection.getConnection().close();
        }
        
        return false;
    }
}
