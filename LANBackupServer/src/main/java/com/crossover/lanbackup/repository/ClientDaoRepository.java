package com.crossover.lanbackup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crossover.lanbackup.entity.Client;

@Repository("clientDaoRepository")
public interface ClientDaoRepository extends CrudRepository<Client, Integer> {
	Client getByIpAddress(String clientIpAddress);
}
