package com.crossover.lanbackup.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.crossover.lanbackup.dao.GenericDao;
import com.crossover.lanbackup.util.HibernateUtil;


public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@Autowired
    private HibernateUtil hibernateUtil;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	protected abstract String getEntityName();
	
	@SuppressWarnings("unchecked")
	@Override
	public PK create(T entity) {
		return (PK) hibernateUtil.create(entity);
	}

	@Override
	public T update(T entity) {
		return hibernateUtil.update(entity);
	}

	@Override
	public void delete(PK id) {
        hibernateUtil.delete(id, getEntityName());
	}

	@Override
	public T get(PK id) {
		return hibernateUtil.fetchById(id, getEntityName());
	}

	@Override
	public List<T> getAll() {
		 return hibernateUtil.fetchAll(getEntityName());
	}
	

}