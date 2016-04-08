package com.crossover.lanbackup.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dao.ConfigLogDao;
import com.crossover.lanbackup.entity.ConfigLog;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ConfigLogDaoImpl extends GenericDAOImpl<ConfigLog, Long> implements ConfigLogDao {
	
	public ConfigLogDaoImpl() {
    	System.out.println("ConfigLogDaoImpl");
    }

	@Override
	protected String getEntityName() {
		return this.getClass().getName();
	}
}
