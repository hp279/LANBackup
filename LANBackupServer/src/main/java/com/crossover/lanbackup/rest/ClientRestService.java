package com.crossover.lanbackup.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crossover.lanbackup.dto.ClientDTO;
import com.crossover.lanbackup.dto.ConfigLogDTO;
import com.crossover.lanbackup.dto.FolderDTO;
import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.entity.Folder;
import com.crossover.lanbackup.rest.exception.BusinessException;
import com.crossover.lanbackup.service.ClientService;
import com.crossover.lanbackup.service.ConfigLogService;
import com.crossover.lanbackup.service.FolderService;

@Controller
@Path("/admin/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private FolderService folderService;

    @Autowired
    private ConfigLogService configLogService;

    @GET
    @Path("/ping")
    public Response ping() {
        String output = "ClientDTO service";
        return Response.status(Status.OK).entity(output).build();
    }

    @GET
    public Response getClients() {
        List<ClientDTO> clientDTOList = clientService
                .toDTO(clientService.getAll());
        return Response.status(Status.OK)
                .entity(new GenericEntity<List<ClientDTO>>(clientDTOList) {
                }).build();
    }

    @GET
    @Path("/{id}")
    public Response getClient(@PathParam("id") Integer id) {
        ClientDTO clientDTO = clientService.toDTO(clientService.get(id));
        return Response.status(Status.OK).entity(clientDTO).build();
    }

    @POST
    @Path("/{id}/enable")
    public Response enableClient(@PathParam("id") Integer id) {
        Client client = clientService.enable(id);
        
        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }
        
        ClientDTO clientDTO = clientService.toDTO(client);
        return Response.status(Status.OK).entity(clientDTO).build();
    }

    @POST
    @Path("/{id}/disable")
    public Response disableClient(@PathParam("id") Integer id) {
        Client client = clientService.disable(id);
        
        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }
        
        ClientDTO clientDTO = clientService.toDTO(client);
        return Response.status(Status.OK).entity(clientDTO).build();
    }

    @POST
    public Response createClient(ClientDTO clientDTO) {
        Client client = clientService.fromDTO(clientDTO);
        client = clientService.save(client);
        return Response.status(Status.OK).entity(clientService.toDTO(client)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Integer id, ClientDTO clientDTO) {
        Client client = clientService.disable(id);
        
        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }
        
        if (clientDTO.getId() != id.intValue()) {
            throw new BusinessException("Id mismathced");
        }
        
        client = clientService.fromDTO(clientDTO);
        client = clientService.save(client);
        
        return Response.status(Status.OK).entity(clientService.toDTO(client)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Integer id) {
        Client client = clientService.get(id);
        
        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }
        
        clientService.delete(id);
        return Response.status(Status.OK).build();
    }

    @GET
    @Path("/{id}/configlog")
    public Response getConfigLogForClient(@PathParam("id") Integer id) {
        Client client = clientService.get(id);
        
        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }
        
        List<ConfigLogDTO> configLogDTOList = configLogService.toDTO(
                configLogService.getByClientIpAddress(client.getIpAddress()));
        
        return Response.status(Status.OK).entity(
                new GenericEntity<List<ConfigLogDTO>>(configLogDTOList) {
                }).build();
    }

    @GET
    @Path("/configlog")
    public Response getConfigLog() {
        List<ConfigLogDTO> configLogDTOList = configLogService
                .toDTO(configLogService.getAll());
        
        return Response.status(Status.OK).entity(
                new GenericEntity<List<ConfigLogDTO>>(configLogDTOList) {
                }).build();
    }

    @GET
    @Path("/{id}/folders")
    public Response getFoldersForClient(@PathParam("id") Integer id) {
        Client client = clientService.get(id);

        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }

        List<Folder> folders = folderService.getAllForClient(client);
        List<FolderDTO> folderDTOList = folderService.toDTO(folders);
        return Response.status(Status.OK)
                .entity(new GenericEntity<List<FolderDTO>>(folderDTOList) {
                }).build();
    }

    @POST
    @Path("/{id}/folders")
    public Response updatedFoldersForClient(@PathParam("id") Integer id,
            String folderIds) {
        Client client = clientService.get(id);

        if (client == null) {
            throw new BusinessException("Client with id " + id + " not found");
        }

        try {
            String[] folderIdStrings = folderIds.split(",");
            Long[] folderIdLongs = new Long[folderIdStrings.length];
            for (int i = 0; i < folderIdStrings.length; i++) {
                String folderIdString = folderIdStrings[i];
                folderIdLongs[i] = Long.parseLong(folderIdString);
            }

            folderService.updatedFoldersForClient(client, folderIdLongs);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            throw new BusinessException("Bad folderIds param");
        }

    }

}
