package com.levelup.myfunds.Allocation;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;

import com.levelup.mutualfunds.rest.BankRestApi;

public class allocation {
	private int age;
	private double contribution;
	public double contriEquity;
	public double contriBonds;
	private double totalWealth;
	private int upperAge;
	private int lowerAge;
	public String Frankie_ID;
	public String Frankie_DDA;
	public String Frankie_SDA;
	public boolean isRegProfile;
	public double wealthEquity;
	public double wealthBonds;
	
	public allocation(int age, double sdaBalance) {
		this.age = age;
		this.contribution = 0;
		this.totalWealth = sdaBalance;
		this.wealthEquity = totalWealth/2.0;
		this.wealthBonds = totalWealth - wealthEquity;
		
		this.upperAge = 65;
		this.lowerAge = 20;
		this.isRegProfile= true;
		this.Frankie_ID = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_e8ec148b-e09c-4e79-8c02-b7dfd5aed06d";
		this.Frankie_DDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_46d45c9c-18f0-41f4-86eb-491a15e4fac1";
		this.Frankie_SDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_edab1b18-7403-4085-ad8d-0d58b43ebeb2";
	}
	
	
	public double calcTotalExpenses(HashMap<String, Double> reqTransactions) {
		double totalExpenses= 0;
		
		
		
		return totalExpenses;
	}
	
	// this is the method that ties together other method calls in this class
	public void processTransactions(double currBalance, double debits) {
		double transfer_amt;
		
		transfer_amt = currBalance - debits;
		
		
		// call community bank API to POST the transfer
		try {
			initiateTransfer(transfer_amt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double smartAllocation() {
		double ce;
		
		if(isRegProfile) {
			if(age <= lowerAge) {
				ce = contribution;
			}
			else if( age > upperAge) {
				ce = 0;
			}
			else {
				ce = contribution - 1;
			}
			
			return ce;
		}
		else {
		//the risk adverse profile
			return ce = 0;
		}
	}
	
	public boolean initiateTransfer(double amount) throws Exception {
		//call community bank POST transfer API here
		//from DDA to SDA investment account
		BankRestApi apiObj = new BankRestApi();
		String amtString = Double.toString(amount);
		apiObj.transfer(amtString, Frankie_DDA, Frankie_SDA);
		return true;
	}

}
