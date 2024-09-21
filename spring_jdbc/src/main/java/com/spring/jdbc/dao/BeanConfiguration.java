package com.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.*")
public class BeanConfiguration {
	@Bean(name={"dataSource"})
	public DataSource getDBConnection() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("shankar");
		dataSource.setPassword("Shankar1234");
		return dataSource;
	}
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getJdbcTempObj() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		DataSource ds = getDBConnection();
		jdbcTemplate.setDataSource(ds);
		return jdbcTemplate;
	}
	
}























/*// Establish connection of DB and creating bean of connection obect
	private DataSource getDBConnection() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("shankar");
		dataSource.setPassword("Shankar1234");
		return dataSource;
	}

	// Storing DB Connection object in JdbcTemplate bean.
	public JdbcTemplate jdbcTempObj() {
		JdbcTemplate jt = new JdbcTemplate();
		DataSource ds = getDBConnection();
		jt.setDataSource(ds);
		return jt;
	}*/
