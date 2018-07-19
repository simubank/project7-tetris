package com.levelup.mutualfunds.modelEndpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levelup.mutualfunds.model.Objects;
import com.levelup.mutualfunds.modelservice.ObjectService;

@Path("/objects")
public class ObjectEndpoint {
	ObjectService objService = new ObjectService();
	
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
	public List<Objects> getObjects(){
		return objService.getAll();
	}
}
