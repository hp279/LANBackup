package com.crossover.lanbackup.dao;

import com.crossover.lanbackup.entity.Client;

public interface ClientDao extends GenericDao<Client, Integer> {
	Client getByIpAddress(String clientIpAddress);
}
