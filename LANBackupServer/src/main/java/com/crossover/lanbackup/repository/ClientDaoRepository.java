package com.crossover.lanbackup.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.lanbackup.entity.Client;

public interface ClientDaoRepository extends CrudRepository<Client, Integer> {
	Client getByIpAddress(String clientIpAddress);
}
