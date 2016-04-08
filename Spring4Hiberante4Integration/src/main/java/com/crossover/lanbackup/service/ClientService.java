package com.crossover.lanbackup.service;

import java.util.List;

import com.crossover.lanbackup.entity.Client;

public interface ClientService {
	public int create(Client Client);
    public Client update(Client client);
    public void delete(int id);
    public List<Client> getAll();
    public Client get(int id);	
}
