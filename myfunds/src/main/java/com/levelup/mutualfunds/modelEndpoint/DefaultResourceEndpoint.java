package com.levelup.mutualfunds.modelEndpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levelup.mutualfunds.model.Objects;

/**
 * Root resource (exposed at "" path)
 */
@Path("myresource")
public class DefaultResourceEndpoint {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	Objects obj = new Objects();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }
}
