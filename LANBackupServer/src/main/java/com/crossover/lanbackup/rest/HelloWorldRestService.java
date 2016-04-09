package com.crossover.lanbackup.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldRestService {

	@GET
	@Path("/say/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
	}
	
	@GET
    @Path("/check")
    public Response checkMonitor() {
        throw new RuntimeException("Monitor not available");
    }
}
