package com.levelup.mutualfunds.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.levelup.mutualfunds.modelEndpoint.angularEP1;
import com.levelup.mutualfunds.modelservice.ObjectService;

public class testHTTPS {
	
	
	
	public static void main(String[] args) throws Exception {
		//tests
		BankRestApi apiCaller = new BankRestApi();
		ObjectService service = new ObjectService();
		apiCaller.printToScreen(apiCaller.getAccount("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_9a019dd1-767b-4617-a179-0efb57a5b55b"));
		
		apiCaller.printToScreen(apiCaller.getAllCustomerTransactions("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_64931a95-66cc-48f8-b7c0-8b6909e3f7ba"));
	
		apiCaller.printToScreen(apiCaller.transfer("1", "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_5d55ea3e-7432-4749-a700-86ffd7e4ae61", "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_5d55ea3e-7432-4749-a700-86ffd7e4ae61"));
	
		//prints age example:
		System.out.println("Age: " + service.returnAttribute(apiCaller.getCustomer("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_e8ec148b-e09c-4e79-8c02-b7dfd5aed06d"), "age"));		
		//prints SDA example:
		System.out.println("SDA: " + service.returnAttribute(apiCaller.getAccount(angularEP1.Frankie_SDA), "balance"));
		//prints DDA example:
		System.out.println("DDA: " + service.returnAttribute(apiCaller.getAccount(angularEP1.Frankie_DDA), "balance"));
		//prints most recent transaction currency amount:
		System.out.println("transaction ammount: " + service.returnAttribute(apiCaller.getAllTransactions(angularEP1.Frankie_DDA), "currencyAmount"));
		System.out.println("DATE: " + service.returnAttribute(apiCaller.getAllTransactions(angularEP1.Frankie_DDA), "postDate"));
		
		
		//testing the lists:
		getAllPostDateOccurences("postDate");
		getAllTransactionAmounts("currencyAmount");
	}
	
	
	
	
	public static List<String> getAllPostDateOccurences(String subString1) throws IllegalStateException, IOException, Exception {
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
		    System.out.println(">"+match1+"<");
		   		    
		    reqTransactionsDates.add(match1);
		}
		return reqTransactionsDates;
	}
	
	public static List<String> getAllTransactionAmounts(String subString1) throws IllegalStateException, IOException, Exception {
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
		    System.out.println(">"+match1+"<");
		   		    
		    reqTransactionsDates.add(match1);
		}
		return reqTransactionsDates;
	}
	
	
	
}