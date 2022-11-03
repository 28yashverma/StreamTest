package com.first;

import java.util.HashMap;
import java.util.Map;

public class Second {
	
	private String s;
	Second(String s) {
		this.s = s;
	}
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		String str1 = new String("Java!");
		String str2 = new String("Java");
		map.put(str1, new Integer(10));
		map.put(str2, new Integer(20));
		
		Map<Second, Integer> map1 = new HashMap<>();
		Second str3 = new Second(str1);
		Second str4 = new Second(str2);
		
		map1.put(str3, new Integer(10));
		map1.put(str4, new Integer(20));
		
		System.out.println(map.get(str1));
		System.out.println(map1.get(str3));
	}

}
