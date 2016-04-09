package com.crossover.lanbackup.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crossover.lanbackup.dto.ClientDTO;
import com.crossover.lanbackup.service.ClientService;

@Controller
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestService {
   
    @Autowired
	private ClientService clientService;

	@GET
	@Path("/ping")
	public Response ping() {
		String output = "ClientDTO service";
		return Response.status(200).entity(output).build();
	}

	@GET
	public Response getClients() {
	    List<ClientDTO> clientDTOList = clientService.getAll();
		return Response.status(Status.OK).entity(new GenericEntity<List<ClientDTO>>(clientDTOList) {}).build();
	}

	/*@GET
	public Response getClient() {
		String output = "ClientDTO service";
		return Response.status(200).entity(output).build();
	}*/

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
	public Response deleteClient() {
		String output = "ClientDTO service";
		return Response.status(200).entity(output).build();
	}

}
