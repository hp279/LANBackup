package com.crossover.lanbackup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.entity.Folder;

public interface FolderDaoRepository extends CrudRepository<Folder, Long> {
    Folder getByClientAndPath(Client client, String path);
    List<Folder> getByClientAndBackuped(Client client, boolean backuped); 
    List<Folder> getByClient(Client client); 
}
