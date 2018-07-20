package com.levelup.mutualfunds.rest;

import org.apache.http.HttpResponse;

public abstract class BankRestApiModel {

	/*
	 * Makes communityBanking REST calls:
	 */
	private static String headerKey = "Authorization";
	private static String headerValue = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzc3NyIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiYzllZDUyMmUtMTNhNi00MjcyLWE3ZjMtMmI2ZGQ3OWIzM2JjIn0.lnKH6rIFFqaIBwNCqzH1FNPH-BsPgRp69izIedVsA1g";
	private String simulantID;
	private int currentBalance;
	
	public static String getHeaderAuthKey() {
		return "Authorization";
	}
	public static String getHeaderAuthValue() {
		//token:
		return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzc3NyIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiYzllZDUyMmUtMTNhNi00MjcyLWE3ZjMtMmI2ZGQ3OWIzM2JjIn0.lnKH6rIFFqaIBwNCqzH1FNPH-BsPgRp69izIedVsA1g";
	}

	
	
	
	//account ----------------------------------------------------------------------------------------------------------------------------
	public abstract HttpResponse getAccount(String AccountID) throws Exception;
	public abstract HttpResponse getAllTransactions(String AccountID) throws Exception;


	
	//customer ----------------------------------------------------------------------------------------------------------------------------
	public abstract HttpResponse getCustomer(String CustomerID) throws Exception; 
	public abstract HttpResponse getAllCustomerAccounts(String CustomerID) throws Exception;
	public abstract HttpResponse getAllCustomerTransactions(String CustomerID) throws Exception;
	
	
	//transaction----------------------------------------------------------------------------------------------------------------------------
	public abstract HttpResponse getTransaction(String ID) throws Exception;
	
	//transfer----------------------------------------------------------------------------------------------------------------------------
	public abstract HttpResponse transfer(String amount, String fromID, String toID) throws Exception;
/*	POST
 * 			{
			  "amount": 0,
			  "currency": "CAD",
			  "fromAccountID": "string",
			  "receipt": "string",
			  "toAccountID": "string"
			}	*/
	public abstract HttpResponse getTransferReceipt(String ID) throws Exception;	
	
	
	
	//misc--------------------------------------------------------------------------------------------------------------------------------------
	public String getSimulantID() {
		return simulantID;
	}
	public void setSimulantID(String simulantID) {
		this.simulantID = simulantID;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	
}
