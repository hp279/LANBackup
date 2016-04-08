package com.crossover.lanbackup.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.repository.ClientDaoRepository;
import com.crossover.lanbackup.service.ClientService;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public ClientServiceImpl() {
		System.out.println("ClientServiceImpl()");
	}
	
    @Autowired
    private ClientDaoRepository repository;

	@Override
	public Client save(Client client) {
		 return repository.save(client);
	}

	@Override
	public Client update(Client client) {
		return repository.save(client);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public List<Client> getAll() {
		return (List<Client>) repository.findAll(); 
	}

	@Override
	public Client get(int id) {
		return repository.findOne(id); 
	}

   
}
