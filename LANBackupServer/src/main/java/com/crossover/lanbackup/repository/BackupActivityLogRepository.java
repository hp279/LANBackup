package com.crossover.lanbackup.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.lanbackup.entity.BackupActivityLog;
import com.crossover.lanbackup.entity.ConfigLog;

public interface BackupActivityLogRepository extends CrudRepository<BackupActivityLog, Long> {
}
