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
import com.crossover.lanbackup.entity.Client;
import com.crossover.lanbackup.service.ClientService;
import com.crossover.lanbackup.service.ConfigLogService;

@Controller
@Path("/admin/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestService {
   
    @Autowired
	private ClientService clientService;


    @Autowired
    private ConfigLogService configLogService;

    
	@GET
	@Path("/ping")
	public Response ping() {
		String output = "ClientDTO service";
		return Response.status(200).entity(output).build();
	}

	@GET
	public Response getClients() {
	    List<ClientDTO> clientDTOList = clientService.toDTO(clientService.getAll());
		return Response.status(Status.OK).entity(new GenericEntity<List<ClientDTO>>(clientDTOList) {}).build();
	}
	
	@GET
	@Path("/{id}")
    public Response getClient(@PathParam("id") Integer id) {
	    ClientDTO clientDTO = clientService.toDTO(clientService.get(id));
	    return Response.status(clientDTO != null ? Status.OK : Status.NOT_FOUND).entity(clientDTO).build();
    }
	
	@POST
	@Path("/{id}/enable")
    public Response enableClient(@PathParam("id") Integer id) {
	    ClientDTO clientDTO = clientService.toDTO(clientService.enable(id));
        return Response.status(clientDTO != null ? Status.OK : Status.NOT_FOUND).entity(clientDTO).build();
    }
	
	@POST
    @Path("/{id}/disable")
    public Response disableClient(@PathParam("id") Integer id) {
	    ClientDTO clientDTO = clientService.toDTO(clientService.disable(id));
        return Response.status(clientDTO != null ? Status.OK : Status.NOT_FOUND).entity(clientDTO).build();
    }

	@POST
	public Response createClient() {
		String output = "ClientDTO service";
		return Response.status(200).entity(output).build();
	}

	@PUT
	public Response updateClient() {
		String output = "ClientDTO service";
		return Response.status(200).entity(output).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteClient(@PathParam("id") Integer id) {
	    clientService.delete(id);
		return Response.status(Status.OK).build();
	}
	
	@GET
    @Path("/{id}/configlog")
    public Response getConfigLogForClient(@PathParam("id") Integer id) {
	    Client client = clientService.get(id);
        List<ConfigLogDTO> configLogDTOList = configLogService.toDTO(
                configLogService.getByClientIpAddress(client.getIpAddress()));
        return Response.status(configLogDTOList != null ? Status.OK : Status.NOT_FOUND).entity(
                new GenericEntity<List<ConfigLogDTO>>(configLogDTOList) {}).build();
    }
	
	@GET
    @Path("/configlog")
    public Response getConfigLog() {
        List<ConfigLogDTO> configLogDTOList = configLogService.toDTO(configLogService.getAll());
        return Response.status(configLogDTOList != null ? Status.OK : Status.NOT_FOUND).entity(
                new GenericEntity<List<ConfigLogDTO>>(configLogDTOList) {}).build();
    }
	
/*	@POST
    @Path("/updateFolders")
    public Response updateFolders(@Context HttpServletRequest request, @Context SecurityContext context) {
	    String ip = request.getRemoteAddr();
	    //If security is enabled
	    Principal principal = context.getUserPrincipal();
	    String userName = principal.getName();
	    
	    return Response.status(Status.OK).entity(ip).build();
      //  ClientDTO clientDTO = clientService.disable(id);
       // return Response.status(clientDTO != null ? Status.OK : Status.NOT_FOUND).entity(clientDTO).build();
    }*/

}
