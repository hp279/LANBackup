package com.crossover.lanbackup.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.lanbackup.entity.Folder;

public interface FolderRepository extends CrudRepository<Folder, Long> {
}
