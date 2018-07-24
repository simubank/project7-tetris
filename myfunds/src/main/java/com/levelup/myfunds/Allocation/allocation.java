package com.levelup.myfunds.Allocation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public boolean isRegProfile;
	public double wealthEquity;
	public double wealthBonds;
	public UserScore savingsScore;
	
	public String Frankie_ID;
	public String Frankie_DDA;
	public String Frankie_SDA;
	
	public allocation(int age, double sdaBalance) {
		this.age = age;
		this.contribution = 0;
		this.totalWealth = sdaBalance;
		this.wealthEquity = totalWealth/2.0;
		this.wealthBonds = totalWealth - wealthEquity;
		savingsScore = new UserScore();
		
		
		this.upperAge = 65;
		this.lowerAge = 20;
		this.isRegProfile= true;
		this.Frankie_ID = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_e8ec148b-e09c-4e79-8c02-b7dfd5aed06d";
		this.Frankie_DDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_46d45c9c-18f0-41f4-86eb-491a15e4fac1";
		this.Frankie_SDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_edab1b18-7403-4085-ad8d-0d58b43ebeb2";
	}
	
	
	public void runAllocation(double ddaBalance, ArrayList<Double> reqTransactions) {
		double transfer_amt = 0;
		
		//calculate appropriate transfer amount
		
		
		processTransactions(transfer_amt);
	}
	
	// this is the method that ties together other allocation method calls in this class
	public void processTransactions(double transfer_amt) {
		
		// call community bank API to POST the transfer
		try {
			initiateTransfer(transfer_amt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("account transfer POST request failed");
		}
		
		//update user savings score
		savingsScore.updateMaxScore(transfer_amt);
		
		//update contribution, and calculate investment allocation
		contribution = transfer_amt;
		smartAllocation();
		
	}
	
	//determine and allocate transferred amount into investment options
	//no return values, modify var in class
	public void smartAllocation() {
		
		if(isRegProfile) {
		//regular risk appetite profile
			if(age < lowerAge) {
				//teen users
				this.contriEquity = contribution;
				this.contriBonds = 0;
			}
			else if( age > upperAge) {
				//retiree users
				this.contriEquity = 0;
				this.contriBonds = contribution;
			}
			else {
				this.contriBonds = Math.max(Math.min(contriBonds, contribution), 0);
				this.contriEquity = contribution - this.contriBonds;
			}
		
		}
		else {
		//the risk adverse profile
			if(age > upperAge) {
				this.contriEquity = 0;
				this.contriBonds = contribution;
			}
			else {
				this.contriBonds = Math.max(Math.min(contriBonds, contribution), 0);
				this.contriEquity = contribution - this.contriBonds;
			}
		}
		
		//update existing wealth allocation figures, in future read/write to a database
		//for now, write to a temp file
		wealthBonds = wealthBonds + contriBonds;
		wealthEquity = wealthEquity + contriEquity;
		
		File f;
		try{
		    f = File.createTempFile("wealthTracker", ".txt");
		    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		    bw.write("Bonds:"+ wealthBonds + "\n" + "Equity:"+ wealthEquity);
		    bw.close();
		  } catch (IOException e){
		     e.printStackTrace();
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
