package com.first.streams;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

	public static void main(String[] args) {
		Employee emp = new Employee(2, "Manish", "Lucknow", "IT", "M", 12000D);
		Optional<Employee> optionalEmp = Optional.ofNullable(emp);

		System.out.println(optionalEmp.orElseGet(new SupplyEmp()));

	}

}

class SupplyEmp implements Supplier<Employee> {

	@Override
	public Employee get() {
		return new Employee(1, "Yeshendra", "Lucknow", "IT", "M", 12000D);
	}

}
