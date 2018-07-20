package com.levelup.myfunds.allocation;

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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}

}
