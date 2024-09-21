package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.model.EmployeeDetails;

@Component("empDao")
public class EmployeeDao {
	private final String INSERT_QUERY = "INSERT INTO EMP VALUES (?,?,?,?,?,?,?,?)";
	private final String UPDATE_QUERY = "UPDATE EMP SET ENAME = ? WHERE EMPNO = ?";
	private final String DELETE_QUERY = "DELETE FROM EMP WHERE EMPNO = ?";
	private final String SELECT_QUERY = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE EMPNO = ?";
	private final String SELECT_ALLRECORD = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP";

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insertEmployee(EmployeeDetails emp) {
		int insertVal = jdbcTemplate.update(INSERT_QUERY, emp.getEmpNo(), emp.getEmpName(), emp.getEmpJob(),
				emp.getEmpMgr(), emp.getEmpHireDate(), emp.getEmpSal(), emp.getEmpComm(), emp.getEmpDeptNo());
		return insertVal;
	}

	public int updateEmployee(EmployeeDetails emp) {
		int updateVal = jdbcTemplate.update(UPDATE_QUERY, emp.getEmpName(), emp.getEmpNo());
		return updateVal;
	}

	public int deleteEmployee(int empId) {
		int deleteVal = jdbcTemplate.update(DELETE_QUERY, empId);
		return deleteVal;
	}

	public EmployeeDetails retrieveEmployee(int empId) {
		EmployeeDetails empDetails = null;
		try {
			RowMapper<EmployeeDetails> rowMapper = new EmployeeDetailsMapping();
			/* Here for RowMapper we are using a separated class for mapping. We achieve
			this with out using separate class as shown retrieveAllEmployee() method. */
			empDetails = jdbcTemplate.queryForObject(SELECT_QUERY, rowMapper, empId);
			// Here we are using .queryForObject(-,-,-) predefined method to get only ONE
			// row details.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return empDetails;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EmployeeDetails> retrieveAllEmployee() {
		List<EmployeeDetails> allEmpDetails = null;
		try {
			//Here we with out using separate class for RowMapper mapping using anonymous concept.
			allEmpDetails = jdbcTemplate.query(SELECT_ALLRECORD, new RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
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
				
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allEmpDetails;
	}
}
