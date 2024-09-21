package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.BeanConfiguration;
import com.spring.jdbc.model.EmployeeDetails;
import com.spring.jdbc.service.EmployeeDetailsServiceImpl;


public class App {
	
	EmployeeDetailsServiceImpl emp = new EmployeeDetailsServiceImpl();

	public static void main(String[] args) {
		System.out.println("Basic Spring JDBC Program");
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		EmployeeDetailsServiceImpl bean = context.getBean("empServiceImpl",EmployeeDetailsServiceImpl.class);
		
		//Insert single record
		int insertEmp = bean.insertEmployee();
		System.out.println(insertEmp>0?"Record Inserted Successfully":"Record NOT inserted");
		
		//Update single record
		int updateEmp = bean.updateEmployee();
		System.out.println(updateEmp>0?"Record Updated Successfully":"Record NOT updated");
		
		//Retrieve single employee
		EmployeeDetails details = bean.retrieveEmployee();
		System.out.println(details);
		
		//Retrieve all employee
		List<EmployeeDetails> allEmp = bean.retrieveAllEmployees();
		allEmp.forEach(val->System.out.println(val));
		
		//Delete single employee
		int deleteEmp = bean.deleteEmployee();
		System.out.println(deleteEmp>0?"Record Deleted Successfully":"Record NOT deleted");
	}
}
