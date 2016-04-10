package com.crossover.lanbackup.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.lanbackup.dto.ClientDTO;
import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.entity.ConfigLog;
import com.crossover.lanbackup.entity.UpdateType;
import com.crossover.lanbackup.repository.ClientDaoRepository;
import com.crossover.lanbackup.service.ClientService;
import com.crossover.lanbackup.service.ConfigLogService;
import com.crossover.lanbackup.validator.IPAddressValidator;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    protected final Log logger = LogFactory.getLog(getClass());
    protected final ModelMapper modelMapper = new ModelMapper();

    public ClientServiceImpl() {
        System.out.println("ClientServiceImpl()");
    }

    @Autowired
    private ClientDaoRepository clientDaoRepository;

    @Autowired
    private ConfigLogService configLogService;
    
    @Autowired
    private IPAddressValidator ipAddressValidator;

    @Override
    public Client save(Client entity) {
        if (!ipAddressValidator.validate(entity.getIpAddress())) {
            throw new IllegalArgumentException("Bad IP address");
        }
        
        if (entity.getCreateDate() == null) {
            entity.setCreateDate(new Date());
        }
        
        entity.setLastUpdateDate(new Date());

        Client newClient = clientDaoRepository.save(entity);

        ConfigLog configLog = new ConfigLog();
        configLog.setClientIpAddress(newClient.getIpAddress());
        configLog.setUpdateType(UpdateType.CREATE);
        configLog.setDescription("Client was created");
        configLog.setActivityDate(new Date());

        configLogService.save(configLog);

        return newClient;
    }

    @Override
    public Client update(Client entity) {
        Client updClient = clientDaoRepository.save(entity);

        ConfigLog configLog = new ConfigLog();
        configLog.setClientIpAddress(updClient.getIpAddress());
        configLog.setUpdateType(UpdateType.UPDATE);
        configLog.setDescription("Client was updated");
        configLog.setActivityDate(new Date());

        configLogService.save(configLog);

        return updClient;
    }

    @Override
    public void delete(Integer id) {
        Client entity = clientDaoRepository.findOne(id);

        String ipAddress = entity.getIpAddress();

        clientDaoRepository.delete(id);

        ConfigLog configLog = new ConfigLog();
        configLog.setClientIpAddress(ipAddress);
        configLog.setUpdateType(UpdateType.DELETE);
        configLog.setDescription("Client was deleted");
        configLog.setActivityDate(new Date());

        configLogService.save(configLog);
    }

    @Override
    public List<Client> getAll() {
        List<Client> entityList = (List<Client>) clientDaoRepository.findAll();
        return entityList;
    }

    @Override
    public Client get(Integer id) {
        Client entity = clientDaoRepository.findOne(id);
        return entity;
    }

    @Override
    public Client enable(int id) {
        Client entity = clientDaoRepository.findOne(id);
        if (entity != null) {
            entity.setEnabled(true);
            entity = clientDaoRepository.save(entity);

            ConfigLog configLog = new ConfigLog();
            configLog.setClientIpAddress(entity.getIpAddress());
            configLog.setUpdateType(UpdateType.ENABLE);
            configLog.setDescription("Client was enabled");
            configLog.setActivityDate(new Date());

            configLogService.save(configLog);
        }
        return entity;
    }

    @Override
    public Client disable(int id) {
        Client entity = clientDaoRepository.findOne(id);
        if (entity != null) {
            entity.setEnabled(false);
            entity = clientDaoRepository.save(entity);

            ConfigLog configLog = new ConfigLog();
            configLog.setClientIpAddress(entity.getIpAddress());
            configLog.setUpdateType(UpdateType.DISABLE);
            configLog.setDescription("Client was disabled");
            configLog.setActivityDate(new Date());

            configLogService.save(configLog);
        }

        return entity;
    }
    
    @Override
    public Client getByIpAddress(String ipAddress) {
        return clientDaoRepository.getByIpAddress(ipAddress);
    }

    @Override
    public ClientDTO toDTO(Client entity) {
        return modelMapper.map(entity, ClientDTO.class);
    }

    @Override
    public List<ClientDTO> toDTO(List<Client> entityList) {
        List<ClientDTO> dtoList = new ArrayList<ClientDTO>();

        for (Client entity : entityList) {
            ClientDTO dto = modelMapper.map(entity, ClientDTO.class);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Client fromDTO(ClientDTO dto) {
        return modelMapper.map(dto, Client.class);
    }

    @Override
    public List<Client> fromDTO(List<ClientDTO> dtoList) {
        List<Client> entityList = new ArrayList<Client>();

        for (ClientDTO dto : dtoList) {
            Client entity = modelMapper.map(dto, Client.class);
            entityList.add(entity);
        }

        return entityList;
    }    
    
}
