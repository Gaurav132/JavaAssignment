/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.daoimp;

import com.gaurav.auction.dao.UserProfileDAO;
import com.gaurav.auction.entity.UserProfile;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Nishan Dhungana
 */
public class UserProfileDAOImp extends GenericDAOImp<UserProfile> implements UserProfileDAO{

    @Override
    public boolean isLogin(String username, String password) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        UserProfile user = null;
        final String SQL = "SELECT u FROM UserProfile u WHERE username=:username AND password=:pass";
            
        try {
            Query query = session.createQuery(SQL);
            query.setParameter("username", username);
            query.setParameter("pass", password);
            
            trans.commit();
            user = (UserProfile) query.uniqueResult();
            
            if (user != null) {
                return true;
            }
            
        } catch(HibernateException ex) {
            trans.rollback();
            throw ex;
        } finally {
            session.close();
        }
        
        return false;
    }

    @Override
    public int getUserId(String username, String password) throws Exception {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        final String SQL = "SELECT u.id FROM UserProfile u WHERE username=:username AND password=:pass";
        
        try {
            Query query = session.createQuery(SQL);
            query.setParameter("username", username);
            query.setParameter("pass", password);
            
            return (int) query.uniqueResult();
            
        } catch(HibernateException ex) {
            trans.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
    
}

