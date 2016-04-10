package com.crossover.lanbackup.service;

import com.crossover.lanbackup.dto.ClientDTO;
import com.crossover.lanbackup.entity.Client;

public interface ClientService extends DTOConvertable<ClientDTO, Client, Integer> {
    public Client enable(int id);
    public Client disable(int id);
    public Client getByIpAddress(String ipAddress);
}
