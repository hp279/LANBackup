package com.crossover.lanbackup.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.lanbackup.entity.BackupActivityLog;

public interface BackupActivityLogDaoRepository extends CrudRepository<BackupActivityLog, Long> {
}
