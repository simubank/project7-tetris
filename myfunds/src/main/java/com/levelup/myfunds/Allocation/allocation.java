package com.levelup.myfunds.Allocation;

import org.apache.http.HttpResponse;

import com.levelup.mutualfunds.rest.BankRestApi;

public class allocation {
	private int age;
	private double c;
	private double w;
	private int upperAge;
	private int lowerAge;
	public String Frankie_ID;
	public String Frankie_DDA;
	public String Frankie_SDA;
	public double currBalance;
	
	public allocation(int age, double c, double w) {
		this.age = age;
		this.c = c;
		this.w = w;
		this.upperAge = 65;
		this.lowerAge = 20;
		this.currBalance = 0;
		this.Frankie_ID = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_e8ec148b-e09c-4e79-8c02-b7dfd5aed06d";
		this.Frankie_DDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_46d45c9c-18f0-41f4-86eb-491a15e4fac1";
		this.Frankie_SDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_edab1b18-7403-4085-ad8d-0d58b43ebeb2";
		
	}
	
	public double processMonthlyExpense() {
		double debits = 500;
		// call http request for all DDA transfer in the future to populate total monthly debits value
		return debits;
	}
	
	public double processTransactions(double debits) {
		double transfer_amt;
		
		transfer_amt = currBalance - debits;
		
		//safety to proctect against account overdraft
		if(transfer_amt > currBalance)
			transfer_amt = 0;
		
		return transfer_amt;
	}
	
	public double smartAllocation(boolean isRegProfile) {
		double ce;
		
		if(isRegProfile) {
			if(age <= lowerAge) {
				ce = c;
			}
			else if( age > upperAge) {
				ce = 0;
			}
			else {
				ce = c - 1;
			}
			
			return ce;
		}
		else {
			return ce = 0;
		}
	}
	
	public boolean initiateTransfer() throws Exception {
		double amount = processTransactions(processMonthlyExpense());
		
		//call community bank POST transfer API here
		//from DDA to investment account
		BankRestApi apiObj = new BankRestApi();
		String amtString = Double.toString(amount);
		apiObj.transfer(amtString, Frankie_DDA, Frankie_SDA);
		return true;
	}

}
