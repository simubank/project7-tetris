package com.levelup.mutualfunds.modelservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.levelup.mutualfunds.modelEndpoint.angularEP1;
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
	public List<String> getAllPostDateOccurences(String subString1) throws IllegalStateException, IOException, Exception {
		BankRestApi apiCaller = new BankRestApi();
		List<String>reqTransactionsDates = new ArrayList<>();
		
		String strToSearch = apiCaller.getJsonString(apiCaller.getAllTransactions(angularEP1.Frankie_DDA));	
		Matcher matcher1 = Pattern.compile(
		                            Pattern.quote("\"" + subString1 + "\":")
		                            + "(.*?)"
		                            + Pattern.quote(",")
		                   ).matcher(strToSearch);
/*		Matcher matcher2 = Pattern.compile(
				Pattern.quote("\"" + subString2 + "\":")
                + "(.*?)"
                + Pattern.quote(",")
       ).matcher(strToSearch);*/
		
		while(matcher1.find()){
		    String match1 = matcher1.group(1);
		    //System.out.println(">"+match1+"<");	   		    
		    reqTransactionsDates.add(match1);
		}
		return reqTransactionsDates;
	}
	
	public List<Double> getAllTransactionAmounts(String subString1) throws IllegalStateException, IOException, Exception {
		BankRestApi apiCaller = new BankRestApi();
		List<Double>reqTransactionAmounts = new ArrayList<>();
		
		String strToSearch = apiCaller.getJsonString(apiCaller.getAllTransactions(angularEP1.Frankie_DDA));	
		Matcher matcher1 = Pattern.compile(
		                            Pattern.quote("\"" + subString1 + "\":")
		                            + "(.*?)"
		                            + Pattern.quote(",")
		                   ).matcher(strToSearch);
/*		Matcher matcher2 = Pattern.compile(
				Pattern.quote("\"" + subString2 + "\":")
                + "(.*?)"
                + Pattern.quote(",")
       ).matcher(strToSearch);*/
		
		while(matcher1.find()){
		    String match1 = matcher1.group(1);
		    //System.out.println(">"+match1+"<"); 
		    reqTransactionAmounts.add(Double.parseDouble(match1));
		}
		return reqTransactionAmounts;
	}
	
}
