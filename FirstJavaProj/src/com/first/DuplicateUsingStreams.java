package com.first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateUsingStreams {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = Arrays.asList(2, 3, 4, 8, 4, 2, 6, 7, 6);

		// using set
		System.out.println("Using set");
		list.stream().filter(elem -> !set.add(elem)).forEach(System.out::println);

		// using group by
		System.out.println("Using group by");
		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(val -> val.getValue() > 1).map(Map.Entry::getKey).forEach(System.out::println);
	}

}
