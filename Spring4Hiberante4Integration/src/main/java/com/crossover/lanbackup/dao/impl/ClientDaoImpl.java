package com.crossover.lanbackup.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dao.ClientDao;
import com.crossover.lanbackup.entity.Client;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ClientDaoImpl extends GenericDAOImpl<Client, Integer> implements ClientDao {

	public ClientDaoImpl() {
    	System.out.println("ClientDaoImpl");
    }
	
	@Override
	protected String getEntityName() {
		return this.getClass().getName();
	}

	@Override
	public Client getByIpAddress(String clientIpAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
