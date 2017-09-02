package com.samplepoc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.samplepoc.domain.EmpSalary;

public class EmpSalaryUtils {
	public static void createEmpSalary(Connection conn, EmpSalary empSalary)
			throws SQLException {
		String sql = "Insert into EmpSalary(emp_salary) values (?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, empSalary.getEmpSalary());
		pstm.executeUpdate();
	}

	public static List<EmpSalary> getEmpSalaryList(Connection conn)
			throws SQLException {
		String sql = "Select * from EmpSalary";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<EmpSalary> list = new ArrayList<EmpSalary>();
		while (rs.next()) {
			String id = rs.getString("id");
			Integer empSalary = rs.getInt("emp_salary");
			EmpSalary empSal = new EmpSalary();
			empSal.setId(id);
			empSal.setEmpSalary(empSalary);
			list.add(empSal);
		}
		return list;
	}

	public static EmpSalary findEmpSalary(Connection conn, String id)
			throws SQLException {
		String sql = "Select e.* from EmpSalary e where e.id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			Integer empSalary = rs.getInt("emp_salary");

			EmpSalary empSal = new EmpSalary(id, empSalary);
			return empSal;
		}
		return null;
	}

	public static void updateEmpSalary(Connection conn, EmpSalary empsalary)
			throws SQLException {
		String sql = "Update EmpSalary set emp_salary=? where id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, empsalary.getEmpSalary());
		pstm.executeUpdate();
	}

	public static void deleteEmpSalary(Connection conn, String id)
			throws SQLException {
		String sql = "Delete EmpSalary where id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, id);

		pstm.executeUpdate();
	}

}
