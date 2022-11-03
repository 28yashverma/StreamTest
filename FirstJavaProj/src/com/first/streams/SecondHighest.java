package com.first.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondHighest {

	public static void main(String[] args) {
		int whichHighest = 3;
		List<Integer> list = Arrays.asList(2, 3, 4, 6, 8, 5, 1, 0);
		list.stream().sorted(Collections.reverseOrder()).limit(whichHighest).skip(whichHighest - 1)
				.forEach(System.out::println);

		int whichLowest = 4;
		list.stream().sorted().limit(whichLowest).skip(whichLowest - 1).forEach(System.out::println);
	}

}
