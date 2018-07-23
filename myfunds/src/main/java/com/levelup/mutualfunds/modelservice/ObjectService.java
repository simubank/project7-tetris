package com.levelup.mutualfunds.modelservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.levelup.mutualfunds.model.Objects;


public class ObjectService {

	private static Map<Long, Objects> messages = new HashMap<>();
	
	public static Map<Long, Objects> getObjects() {
		return messages;
	}
	
	public List<Objects> getAll(){
		Objects obj1 = new Objects("Config1 ", "mutual funds1 ", 1L);
		Objects obj2 = new Objects("Config2 ", "mutual funds2 ", 2L);
		Objects obj3 = new Objects("Config3 ", "mutual funds3 ", 2L);	
		List<Objects> objList = new ArrayList<>();
		objList.add(obj1);
		objList.add(obj2);
		objList.add(obj3);		
		return objList;
	}
	public Objects getObj(long id) {
		return messages.get(id);
	}
	
	public Objects addObj(Objects obj) {
		obj.setId(messages.size() + 1);
		messages.put(obj.getId(), obj);
		return obj;
	}
	
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
	
}
