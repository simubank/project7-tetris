package com.levelup.mutualfunds.rest;

public abstract class BankRestApiModel {

	/*
	 * Makes communityBanking REST calls:
	 */
	private static String headerKey = "Authorization";
	private static String headerValue = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzc3NyIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiYzllZDUyMmUtMTNhNi00MjcyLWE3ZjMtMmI2ZGQ3OWIzM2JjIn0.lnKH6rIFFqaIBwNCqzH1FNPH-BsPgRp69izIedVsA1g";
	private String simulantID;
	private int currentBalance;


	//account ----------------------------------------------------------------------------------------------------------------------------
	public void getAccount() {
		/*
		 * generates acc data
		 */
	}
	public void updateAccountBalance(Object JSON) {
			/* PATCH
			 * {
			  "balance": 0
			}*/
	}
		
	
	public static String getHeaderKey() {
		return "Authorization";
	}
	public static void setHeaderKey(String headerKey) {
		BankRestApiModel.headerKey = headerKey;
	}
	public static String getHeaderValue() {
		return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzc3NyIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiYzllZDUyMmUtMTNhNi00MjcyLWE3ZjMtMmI2ZGQ3OWIzM2JjIn0.lnKH6rIFFqaIBwNCqzH1FNPH-BsPgRp69izIedVsA1g";
	}
	public static void setHeaderValue(String headerValue) {
		BankRestApiModel.headerValue = headerValue;
	}
	//customer ----------------------------------------------------------------------------------------------------------------------------
	public void getAllCustomerAccounts(String ID) {
		//GET
	}
	public void getAllTransactions(String ID) {
		//GET
	}
	
	
	//transaction----------------------------------------------------------------------------------------------------------------------------
	public void getTransaction(String ID) {
		/*GET*/
	}
	
	//transfer----------------------------------------------------------------------------------------------------------------------------
	public void transfer(Object JSON) {
/*	POST
 * 			{
			  "amount": 0,
			  "currency": "CAD",
			  "fromAccountID": "string",
			  "receipt": "string",
			  "toAccountID": "string"
			}	*/
	}
	public void getTransferReceipt(String ID) {
		//GET
	}
	
	
	
	
	
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
