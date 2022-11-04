package com.first.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCalculation {

	private static List<Employee> listOfEmployees;

	static {
		listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Employee(3, "Yeshendra", "Lucknow", "IT", "M", 160000D));
		listOfEmployees.add(new Employee(1, "Prabhjeet", "Pune", "Excel", "M", 150000D));
		listOfEmployees.add(new Employee(5, "Sumati", "Lucknow", "IT", "F", 5000D));
		listOfEmployees.add(new Employee(2, "Manish", "Pune", "IT", "M", 250000D));
		listOfEmployees.add(new Employee(4, "Rishikesh", "Bangalore", "Computers", "M", 220000D));
	}

	public static void main(String[] args) {
		System.out.println("Show all employees");
		listOfEmployees.stream().forEach(System.out::println);

		System.out.println("Grouping on the basis of gender");
		listOfEmployees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
				.forEach((k, v) -> {
					System.out.println(k + " " + v);
				});

		System.out.println("Sorting on the basis of name");
		listOfEmployees.stream().sorted(new NameComparator()).forEach(System.out::println);

		System.out.println("Multiple comparators");
		Comparator<Employee> multiple = new IDComparator();
		multiple.thenComparing(new NameComparator());
		listOfEmployees.stream().sorted(multiple).forEach(System.out::println);

		System.out.println("Filtering on the basis of salary");
		listOfEmployees.stream().filter(e -> e.getSalary() > 30000).forEach(System.out::println);

		System.out.println("Iterating maps");
		Map<Integer, List<Employee>> map = new HashMap<>();
		map.put(1, listOfEmployees);
		map.entrySet().stream().forEach(m -> {
			System.out.print("Key : " + m);
			System.out.println("Values : " + m.getValue());
		});

		System.out.println("Using map function");
		listOfEmployees.stream().map(new MappingEmployee()).forEach(System.out::println);

		System.out.println("Using FlatMap");
		listOfEmployees.stream().flatMap(new FlatMappingStream()).forEach(System.out::println);

	}

}

class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}

class IDComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getEmployeeId().compareTo(o2.getEmployeeId());
	}

}

class MappingEmployee implements Function<Employee, String> {

	@Override
	public String apply(Employee t) {
		return t.getName();
	}

}

class FlatMappingStream implements Function<Employee, Stream<Integer>> {

	@Override
	public Stream<Integer> apply(Employee t) {
		return Stream.of(t.getEmployeeId());
	}

}
