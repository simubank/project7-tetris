package com.levelup.mutualfunds.modelEndpoint;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levelup.mutualfunds.rest.BankRestApi;

@Path("/angular")
public class angular1Endpoint {

	BankRestApi apiObj = new BankRestApi();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String returnString() throws Exception {
		return apiObj.responseToJsonString(apiObj.getAccount("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_9a019dd1-767b-4617-a179-0efb57a5b55b"));
		//return "WebConfig reached";
	}
}


