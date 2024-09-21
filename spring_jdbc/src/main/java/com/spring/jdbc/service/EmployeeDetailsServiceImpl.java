package com.spring.jdbc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.model.EmployeeDetails;

@Component("empServiceImpl")
public class EmployeeDetailsServiceImpl {
	
	@Autowired
	EmployeeDao empDao;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	EmployeeDetails emp = null;

	@SuppressWarnings("deprecation")
	public int insertEmployee() {
		emp = new EmployeeDetails();
		int insertRes = 0;
		try {

			System.out.print("Enter Employee Number: ");
			int empNo = Integer.parseInt(reader.readLine());
			emp.setEmpNo(empNo);

			System.out.print("Enter Employee Name: ");
			String empName = reader.readLine();
			emp.setEmpName(empName);

			System.out.print("Enter Employee Job: ");
			String empJob = reader.readLine();
			emp.setEmpJob(empJob);

			System.out.print("Enter Employee MGR: ");
			int empMgr = Integer.parseInt(reader.readLine());
			emp.setEmpMgr(empMgr);

			System.out.print("Enter Employee Hiredate(DD-MM-YYYY): ");
			String hiredate = reader.readLine();
			emp.setEmpHireDate(new Date(hiredate));

			System.out.print("Enter Employee Salary: ");
			float empSal = Float.parseFloat(reader.readLine());
			emp.setEmpSal(empSal);

			System.out.print("Enter Employee Commission: ");
			float empComm = Float.parseFloat(reader.readLine());
			emp.setEmpComm(empComm);

			System.out.print("Enter Employee Department No: ");
			int empDept = Integer.parseInt(reader.readLine());
			emp.setEmpDeptNo(empDept);

			insertRes = empDao.insertEmployee(emp);
		} catch (IOException e) {
			System.out.println("Error in entered data: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Data insertation eception: " + e.getMessage());
		}
		return insertRes;
	}

	public int updateEmployee() {
		emp = new EmployeeDetails();
		int updateRes = 0;
		try {
			System.out.println("===Update Employee===");
			System.out.print("Enter Employee Number: ");
			int empNo = Integer.parseInt(reader.readLine());
			emp.setEmpNo(empNo);

			System.out.print("Enter Employee New Name: ");
			String empName = reader.readLine();
			emp.setEmpName(empName);

			updateRes = empDao.updateEmployee(emp);
		} catch (IOException e) {
			System.out.println("Error in enter data: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in update data: " + e.getMessage());
		}
		return updateRes;
	}

	public int deleteEmployee() {
		emp = new EmployeeDetails();
		int deleteRes = 0;
		try {
			System.out.println("===Delete Employee===");
			System.out.print("Enter Employee Number: ");
			int empNo = Integer.parseInt(reader.readLine());
			emp.setEmpNo(empNo);

			deleteRes = empDao.deleteEmployee(empNo);
		} catch (IOException e) {
			System.out.println("Error in enter data: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in delete data: " + e.getMessage());
		}
		return deleteRes;
	}

	public EmployeeDetails retrieveEmployee() {
		emp = new EmployeeDetails();
		try {
			System.out.println("===Retrieve Employee===");
			System.out.print("Enter Employee Number: ");
			int empNo = Integer.parseInt(reader.readLine());
			emp.setEmpNo(empNo);

			emp = empDao.retrieveEmployee(empNo);
		} catch (IOException e) {
			System.out.println("Error in enter data: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in delete data: " + e.getMessage());
		}
		return emp;
	}
	public List<EmployeeDetails> retrieveAllEmployees() {
		List<EmployeeDetails> allEmpDetails = new ArrayList<>();
		try {
			allEmpDetails = empDao.retrieveAllEmployee();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allEmpDetails;
	}
}
