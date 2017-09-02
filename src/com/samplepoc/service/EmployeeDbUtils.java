package com.samplepoc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.samplepoc.domain.Employee;

public class EmployeeDbUtils {

	public static void createEmployee(Connection conn, Employee employee)
			throws SQLException {
		String sql = "Insert into Employee(emp_id,emp_name,emp_phone_no,emp_email_id,password) values (?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getEmpId());
		pstm.setString(2, employee.getEmpName());
		pstm.setInt(3, employee.getEmpPhoneNo());
		pstm.setString(4, employee.getEmpEmailId());
		pstm.setString(5, employee.getPassword());
		pstm.setInt(6, employee.getEmpSalary());
		pstm.executeUpdate();
	}

	public static List<Employee> getEmployeeList(Connection conn)
			throws SQLException {
		String sql = "Select * from Employee";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			String id = rs.getString("id");
			String empId = rs.getString("emp_id");
			String empName = rs.getString("emp_name");
			String empEmailId = rs.getString("emp_email_id");
			Integer phoneNo = rs.getInt("emp_phone_no");
			String password = rs.getString("password");
			Integer empSalary = rs.getInt("emp_salary");
			Employee employee = new Employee();
			employee.setId(id);
			employee.setEmpId(empId);
			employee.setEmpName(empName);
			employee.setEmpEmailId(empEmailId);
			employee.setEmpPhoneNo(phoneNo);
			employee.setPassword(password);
			employee.setEmpSalary(empSalary);
			list.add(employee);
		}
		return list;
	}

	public static Employee findEmployee(Connection conn, String id)
			throws SQLException {
		String sql = "Select e.* from Employee e where e.id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String empId = rs.getString("emp_id");
			String empName = rs.getString("emp_name");
			Integer empPhoneNo = rs.getInt("emp_phone_no");
			String empEmailId = rs.getString("emp_email_id");
			String password = rs.getString("password");
			Integer empSalary = rs.getInt("emp_salary");

			Employee employee = new Employee(empId, empName, empPhoneNo,
					empEmailId, password, empSalary);
			return employee;
		}
		return null;
	}

	public static void updateEmployee(Connection conn, Employee employee)
			throws SQLException {
		String sql = "Update Employee set emp_id=?, emp_name =?, emp_phone_no=? ,emp_email_id=? ,password=? where id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getEmpId());
		pstm.setString(2, employee.getEmpName());
		pstm.setInt(3, employee.getEmpPhoneNo());
		pstm.setString(4, employee.getEmpEmailId());
		pstm.setString(5, employee.getPassword());
		pstm.setInt(6, employee.getEmpSalary());
		pstm.executeUpdate();
	}

	public static void deleteEmployee(Connection conn, String id)
			throws SQLException {
		String sql = "Delete Employee where id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, id);

		pstm.executeUpdate();
	}

}
