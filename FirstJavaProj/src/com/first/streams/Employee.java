package com.first.streams;

public class Employee {

	public Employee() {
	}

	public Employee(Integer id, String name, String address, String department, String gender, Double salary) {
		this.employeeId = id;
		this.name = name;
		this.address = address;
		this.department = department;
		this.gender = gender;
		this.salary = salary;
	}

	private Integer employeeId;
	private String name;
	private String address;
	private String department;
	private String gender;
	private Double salary;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + ", department="
				+ department + ", gender=" + gender + ", salary=" + salary + "]";
	}

}
