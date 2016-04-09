package com.crossover.lanbackup.service;

import java.util.List;


import com.crossover.lanbackup.dto.ClientDTO;
import com.crossover.lanbackup.entity.Client;

public interface ClientService {
	public Client save(Client Client);
    public Client update(Client client);
    public void delete(int id);
    public List<ClientDTO> getAll();
    public Client get(int id);	
}
