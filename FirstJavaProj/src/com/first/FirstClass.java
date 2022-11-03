package com.first;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstClass {

	public static void main(String[] args) {
		System.out.println("this is my first program");
		List<String> myList = new ArrayList<>();
		myList.add("Yeshendra");
		myList.add("Rini");
		myList.add("3");
		
		Iterator<String> iter = myList.iterator();
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println("val " + val);
			if(val.equalsIgnoreCase("Rini")) {
				myList.remove(2);
			}
		}
	}

}
