package com.crossover.lanbackup.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dao.ClientDao;
import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.service.ClientService;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public ClientServiceImpl() {
		System.out.println("ClientServiceImpl()");
	}
	
    @Autowired
    private ClientDao clientDao;

	@Override
	public int create(Client Client) {
		 return clientDao.create(Client);
	}

	@Override
	public Client update(Client client) {
		return clientDao.update(client);
	}

	@Override
	public void delete(int id) {
		clientDao.delete(id);
	}

	@Override
	public List<Client> getAll() {
		return clientDao.getAll(); 
	}

	@Override
	public Client get(int id) {
		return clientDao.get(id); 
	}

   
}
