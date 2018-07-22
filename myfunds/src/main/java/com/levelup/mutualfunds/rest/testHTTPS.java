package com.levelup.mutualfunds.rest;

public class testHTTPS {
	

	public static void main(String[] args) throws Exception {
		//tests
		BankRestApi apiCaller = new BankRestApi();
		
		apiCaller.printToScreen(apiCaller.getAccount("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_9a019dd1-767b-4617-a179-0efb57a5b55b"));
		
		apiCaller.printToScreen(apiCaller.getAllCustomerTransactions("c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_64931a95-66cc-48f8-b7c0-8b6909e3f7ba"));
	
		apiCaller.printToScreen(apiCaller.transfer("1", "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_5d55ea3e-7432-4749-a700-86ffd7e4ae61", "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_5d55ea3e-7432-4749-a700-86ffd7e4ae61"));
	
		System.out.println((apiCaller.getJsonString(apiCaller.transfer("1", "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_5d55ea3e-7432-4749-a700-86ffd7e4ae61", "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_5d55ea3e-7432-4749-a700-86ffd7e4ae61"), "transferCompleted")));
	}
}
