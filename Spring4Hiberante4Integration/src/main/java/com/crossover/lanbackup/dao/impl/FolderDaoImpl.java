package com.crossover.lanbackup.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dao.FolderDao;
import com.crossover.lanbackup.entity.Folder;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class FolderDaoImpl extends GenericDAOImpl<Folder, Long> implements FolderDao {
	
	public FolderDaoImpl() {
    	System.out.println("FolderDaoImpl");
    }

	@Override
	protected String getEntityName() {
		return this.getClass().getName();
	}
}
