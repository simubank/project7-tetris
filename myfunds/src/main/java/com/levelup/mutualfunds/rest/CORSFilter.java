package com.levelup.mutualfunds.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

		MultivaluedMap<String, Object> headers = responseContext.getHeaders();

		headers.add("Access-Control-Allow-Origin", "*"); 
		//headers.add("Access-Control-Allow-Origin", "http://localhost:4200"); //enable to allows CORS requests only coming from listed URI		
		
		//indicates that GET, POST, DELETE, PUT methods are allowed when accessing the resource
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");	//cross origin allowed to use such HTTP methods		
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-MyFunds");
		System.out.println("CORSFilter reached---------------------------------");
	}
}
