package com.samplepoc.domain;

public class EmpSalary {

	private String id;
	private Integer empSalary;

	public EmpSalary() {

	}

	public EmpSalary(String id, Integer empSalary) {
		this.id = id;
		this.empSalary = empSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

}
