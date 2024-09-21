package com.spring.jdbc.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class EmployeeDetails implements Serializable {
	private int empNo;
	private String empName;
	private String empJob;
	private int empMgr;
	private Date empHireDate;
	private float empSal;
	private float empComm;
	private int empDeptNo;
}
