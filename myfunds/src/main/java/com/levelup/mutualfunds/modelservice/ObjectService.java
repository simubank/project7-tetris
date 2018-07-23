package com.levelup.mutualfunds.modelservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.levelup.mutualfunds.model.Objects;


public class ObjectService {

	
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
	
	
}
