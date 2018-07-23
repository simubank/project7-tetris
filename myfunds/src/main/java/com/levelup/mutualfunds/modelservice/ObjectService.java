package com.levelup.mutualfunds.modelservice;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.levelup.mutualfunds.rest.BankRestApi;


public class ObjectService {

	BankRestApi api = new BankRestApi();
	
	//this section get fetch customer demographics from com.bank API
	//getting customer name
	public String getCustomerByID(String customerToken) {
		String custName = "Frankie Karaffa";
		
		//custName = http request here
		
		return custName;
		
	}
	//getting customer age
	public int getCustomerAge(String customerToken) {
		int age = 24;
		
		//age = http request here
		
		return age;
	}
	//getting customer current balance in DDA
	public double getBalanceDDA(String customerToken) {
		double currBalance = 1;
		
		// currBalance = http request here		
		return currBalance;
	}	
	
	
	public String returnAttribute(HttpResponse response, String subString) {
		String str = null;
		try {
			str = EntityUtils.toString(response.getEntity());
		} catch (ParseException | IOException e) {
		}		
		return StringUtils.substringBetween(str, "\""+ subString + "\":", ",");		
	}
	
}
