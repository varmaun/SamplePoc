package com.samplepoc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.samplepoc.domain.EmpDepartment;

public class EmpDepartmentUtils {

	public static void createEmpDepartment(Connection conn,
			EmpDepartment empDepartment) throws SQLException {
		String sql = "Insert into EmpDepartment(dep_name) values (?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, empDepartment.getDepName());
		pstm.executeUpdate();
	}

	public static List<EmpDepartment> getEmpDepartmentList(Connection conn)
			throws SQLException {
		String sql = "Select * from EmpDepartment";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<EmpDepartment> list = new ArrayList<EmpDepartment>();
		while (rs.next()) {
			String id = rs.getString("id");
			String depName = rs.getString("dep_name");
			EmpDepartment empDepartment = new EmpDepartment();
			empDepartment.setId(id);
			empDepartment.setDepName(depName);
			list.add(empDepartment);
		}
		return list;
	}

	public static EmpDepartment findEmpDepartment(Connection conn, String id)
			throws SQLException {
		String sql = "Select e.* from EmpDepartment e where e.id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String depName = rs.getString("dep_name");

			EmpDepartment empDepartment = new EmpDepartment(id, depName);
			return empDepartment;
		}
		return null;
	}

	public static void updateEmpDepartment(Connection conn,
			EmpDepartment empDepartment) throws SQLException {
		String sql = "Update EmpDepartment set dep_name=? where id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, empDepartment.getDepName());
		pstm.executeUpdate();
	}

	public static void deleteEmpDepartment(Connection conn, String id)
			throws SQLException {
		String sql = "Delete EmpDepartment where id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, id);

		pstm.executeUpdate();
	}

}
