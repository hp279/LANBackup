package com.crossover.lanbackup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dto.ClientDTO;
import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.repository.ClientDaoRepository;
import com.crossover.lanbackup.service.ClientService;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    protected final Log logger = LogFactory.getLog(getClass());

    public ClientServiceImpl() {
        System.out.println("ClientServiceImpl()");
    }

    @Autowired
    private ClientDaoRepository clientDaoRepository;

    @Override
    public Client save(Client client) {
        return clientDaoRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientDaoRepository.save(client);
    }

    @Override
    public void delete(int id) {
        clientDaoRepository.delete(id);
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> entityList = (List<Client>) clientDaoRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        List<ClientDTO> dtoList = new ArrayList<ClientDTO>();

        for (Client entity : entityList) {
            ClientDTO dto = modelMapper.map(entity, ClientDTO.class);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Client get(int id) {
        return clientDaoRepository.findOne(id);
    }

}
