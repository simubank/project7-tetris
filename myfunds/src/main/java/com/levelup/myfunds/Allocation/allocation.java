package com.levelup.myfunds.Allocation;

public class allocation {
	private int age;
	private double c;
	private double w;
	private int upperAge;
	private int lowerAge;
	
	public allocation(int age, double c, double w) {
		this.age = age;
		this.c = c;
		this.w = w;
		this.upperAge = 65;
		this.lowerAge = 20;
	}
	
	public double processTransactions(double currBalance, double debits) {
		double transfer_amt;
		
		transfer_amt = currBalance - debits;
		
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
	
	public boolean initiateTransfer(double amount) {
		//call community bank POST transfer API here
		//from DDA to investment account
		
		
		return true;
	}

}
