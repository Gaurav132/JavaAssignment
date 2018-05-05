/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.daoimp;

import com.gaurav.auction.dao.GenericDAO;
import com.gaurav.auction.dao.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public abstract class GenericDAOImp<T> implements GenericDAO<T> {

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected Transaction trans;
    protected Session session;
    protected final Class<T> persistClass;

    public GenericDAOImp() {
        persistClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
    }
    
    @Override
    public void insert(T t) throws SQLException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        try {
            session.save(t);
            trans.commit();
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) throws SQLException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        try {
            session.update(t);
            trans.commit();
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(T t) throws SQLException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        boolean res = false;
        
        try {
            session.delete(t);
            trans.commit();
            res = true;
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
        
        return res;
    }

    @Override
    public List<T> getAll() throws SQLException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        List<T> list = null;
        try {
            Criteria criteria = session.createCriteria(persistClass);
            list = criteria.list();
            
            trans.commit();
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
        
        return list;
    }

    @Override
    public T getById(int id) throws SQLException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        T t = null;
        
        try {
            t = (T) session.get(persistClass, id);
            trans.commit();
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
        
        return t;
    }

}
