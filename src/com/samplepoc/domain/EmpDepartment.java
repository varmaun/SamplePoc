package com.samplepoc.domain;

public class EmpDepartment {

	private String id;
	private String depName;

	public EmpDepartment() {

	}

	public EmpDepartment(String id, String depName) {
		this.id = id;
		this.depName = depName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

}
