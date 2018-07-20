package com.levelup.mutualfunds.modelEndpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levelup.mutualfunds.model.Objects;
import com.levelup.mutualfunds.modelservice.ObjectService;

@Path("/objects")
public class ObjectEndpoint {
	ObjectService objService = new ObjectService();
	    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Objects> getObjects(){
		return objService.getAll();
	}
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public String postObj(Objects obj) {
		return "Post worked  ";    	
    }
    
    @GET
    @Path("/{MethodID}")
    //map dynamic value
    @Produces(MediaType.TEXT_PLAIN)
    public String MapMethod(@PathParam("MethodID")String MethodID) {
    	return "Method Mapped under /objects, ID: " + MethodID;
    }
}
