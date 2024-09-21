package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.model.EmployeeDetails;

@Component
public class EmployeeDetailsMapping implements RowMapper<EmployeeDetails> {

	@Override
	//By using RowMapper we mapping ResultSet object value with our custom bean object value
	public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setEmpNo(rs.getInt(1));
		empDetails.setEmpName(rs.getString(2));
		empDetails.setEmpJob(rs.getString(3));
		empDetails.setEmpMgr(rs.getInt(4));
		empDetails.setEmpHireDate(rs.getDate(5));
		empDetails.setEmpSal(rs.getFloat(6));
		empDetails.setEmpComm(rs.getFloat(7));
		empDetails.setEmpDeptNo(rs.getInt(8));
		return empDetails;
	}

}
