/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.dao;

import com.gaurav.auction.entity.UserProfile;

/**
 *
 * @author Nishan Dhungana
 */
public interface UserProfileDAO extends GenericDAO<UserProfile>{
    boolean isLogin(String username, String password) throws Exception;
    int getUserId(String username, String password) throws Exception;
}
