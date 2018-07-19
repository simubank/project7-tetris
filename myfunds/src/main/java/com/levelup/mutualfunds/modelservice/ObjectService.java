package com.levelup.mutualfunds.modelservice;

import java.util.ArrayList;
import java.util.List;

import com.levelup.mutualfunds.model.Objects;


public class ObjectService {

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
}
