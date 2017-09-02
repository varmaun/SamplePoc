package com.samplepoc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.samplepoc.domain.Employee;

public class EmployeeDbUtils {

	public static void createEmployee(Connection conn, Employee employee) throws SQLException {
		String sql = "Insert into Employee(emp_name,emp_phone_no,emp_email_id,password) values (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, employee.getEmpName());
		pstm.setInt(2, employee.getEmpPhoneNo());
		pstm.setString(3, employee.getEmpEmailId());
		pstm.setString(4, employee.getPassword());
		pstm.executeUpdate();
	}

	public static List<Employee> getEmployeeList(Connection conn) throws SQLException {
		String sql = "Select * from Employee";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			String empName = rs.getString("emp_name");
			String empEmailId = rs.getString("emp_email_id");
			int phoneNo = rs.getInt("emp_phone_no");
			String password = rs.getString("password");
			Employee employee = new Employee();
			employee.setEmpName(empName);
			employee.setEmpEmailId(empEmailId);
			employee.setEmpPhoneNo(phoneNo);
			employee.setPassword(password);
			list.add(employee);
		}
		return list;
	}

	public static Employee findEmployee(Connection conn, String id) throws SQLException {
		String sql = "Select e.* from Employee e where e.id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String empName = rs.getString("emp_name");
			Integer empPhoneNo = rs.getInt("emp_phone_no");
			String empEmailId = rs.getString("emp_email_id");
			String password = rs.getString("password");

			Employee product = new Employee(empName, empEmailId, empPhoneNo, password);
			return product;
		}
		return null;
	}

	public static void updateEmployee(Connection conn, Employee employee) throws SQLException {
		String sql = "Update Employee set emp_name =?, emp_phone_no=? ,emp_email_id=? ,password=? where id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, employee.getEmpName());
		pstm.setInt(2, employee.getEmpPhoneNo());
		pstm.setString(3, employee.getEmpEmailId());
		pstm.setString(4, employee.getPassword());
		pstm.executeUpdate();
	}

	public static void deleteEmployee(Connection conn, String id) throws SQLException {
		String sql = "Delete Employee where id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, id);

		pstm.executeUpdate();
	}

}
