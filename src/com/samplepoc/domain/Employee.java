package com.samplepoc.domain;

public class Employee {

	private String id;
	private String empName;
	private Integer empPhoneNo;
	private String empEmailId;
	private String password;

	public Employee() {

	}

	public Employee(String empName, String empEmailId, Integer empPhoneNo, String password) {
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.empPhoneNo = empPhoneNo;
		this.password = password;
	}

	public Employee(String id, String empName, String empEmailId, Integer empPhoneNo, String password) {
		this.id = id;
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.empPhoneNo = empPhoneNo;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpPhoneNo() {
		return empPhoneNo;
	}

	public void setEmpPhoneNo(Integer empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
