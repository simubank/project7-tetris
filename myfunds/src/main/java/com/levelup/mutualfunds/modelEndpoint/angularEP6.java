package com.levelup.mutualfunds.modelEndpoint;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levelup.mutualfunds.rest.BankRestApi;

@Path("/angular")
public class angularEP6 {

	public final static String Frankie_ID = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_e8ec148b-e09c-4e79-8c02-b7dfd5aed06d";
	public final static String Frankie_DDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_46d45c9c-18f0-41f4-86eb-491a15e4fac1";
	public final static String Frankie_SDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_edab1b18-7403-4085-ad8d-0d58b43ebeb2";
	
	BankRestApi apiObj = new BankRestApi();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String returnString() throws Exception {
		return apiObj.responseToJsonString(apiObj.getAccount("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_9a019dd1-767b-4617-a179-0efb57a5b55b"));
		//return "WebConfig reached";
	}
}


