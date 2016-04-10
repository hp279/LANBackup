package com.crossover.lanbackup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crossover.lanbackup.entity.ConfigLog;

public interface ConfigLogDaoRepository extends CrudRepository<ConfigLog, Long> {
    List<ConfigLog> findByClientIpAddress(String clientIpAddress);
}
