package com.crossover.lanbackup.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
@Repository
public class HibernateUtil {
	
	@Autowired
    private SessionFactory sessionFactory;
	
		
    public <T> Serializable create(final T entity) {
        return sessionFactory.getCurrentSession().save(entity);        
    }
    
    public <T> T update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);   
        return entity;
    }
    
	public <T> void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <T> void delete(Serializable id, String entityName) {
		T entity = fetchById(id, entityName);
		delete(entity);
	}
    
    @SuppressWarnings("unchecked")	
    public <T> List<T> fetchAll(String entityName) {        
        return sessionFactory.getCurrentSession().createQuery(" FROM " + entityName).list();        
    }
  
    @SuppressWarnings("rawtypes")
	public <T> List fetchAllByQuery(String query) {        
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();        
    }
    
    
    @SuppressWarnings("unchecked")
	public <T> T fetchById(Serializable id, String entityName) {
        return (T) sessionFactory.getCurrentSession().get(entityName, id);
    }

}
