package com.crossover.lanbackup.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dao.BackupActivityLogDao;
import com.crossover.lanbackup.entity.BackupActivityLog;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class BackupActivityLogDaoImpl extends GenericDAOImpl<BackupActivityLog, Long> implements BackupActivityLogDao {
	
	public BackupActivityLogDaoImpl() {
    	System.out.println("BackupActivityLog");
    }

	@Override
	protected String getEntityName() {
		return this.getClass().getName();
	}
}
