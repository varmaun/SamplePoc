package com.samplepoc.domain;

public class Employee {

	private String id;
	private String empId;
	private String empName;
	private Integer empPhoneNo;
	private String empEmailId;
	private String password;
	private Integer empSalary;
	private EmpDepartment empDepartment;

	public Employee() {

	}

	public Employee(String id,String empId, String empName, Integer empPhoneNo,
			String empEmailId, String password, Integer empSalary,
			EmpDepartment empDepartment) {
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.empPhoneNo = empPhoneNo;
		this.password = password;
		this.empSalary = empSalary;
		this.empDepartment = empDepartment;
	}

	public Employee(String empId, String empName, Integer empPhoneNo, String empEmailId,
			String password, Integer empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.empPhoneNo = empPhoneNo;
		this.password = password;
		this.empSalary = empSalary;
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

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

	public EmpDepartment getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(EmpDepartment empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
