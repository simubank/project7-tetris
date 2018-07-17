package com.levelup.mutualfunds.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class testHTTPS {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		

		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/accounts/self");
		//header:
		request.addHeader(BankRestApiModel.getHeaderKey(), BankRestApiModel.getHeaderValue());
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();

		BufferedReader rd = new BufferedReader
			    (new InputStreamReader(
			    entity.getContent()));
				// use org.apache.http.util.EntityUtils to read json as string
				String jsonString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
				System.out.println("HTTPS RESPONSE: " + jsonString);							
	}
}
