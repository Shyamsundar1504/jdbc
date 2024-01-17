package com.jdbc.companydb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateDb {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost:3306/";

	    static final String USER = "root";
	    static final String PASS = "root";
	    public static void main(String[] args) {
	    	  Connection conn = null;
	          Statement stmt = null;

	          try {
	            
	              Class.forName(JDBC_DRIVER);

	             
	              System.out.println("Connecting to database...");
	              conn = DriverManager.getConnection(DB_URL, USER, PASS);

	            
	              System.out.println("Creating database...");
	              stmt = conn.createStatement();
	              String createDB = "CREATE DATABASE IF NOT EXISTS company_db";
	              stmt.executeUpdate(createDB);
	              System.out.println("Database created successfully.");

	              
	              String useDB = "USE company_db";
	              stmt.executeUpdate(useDB);

	             
	              String createEmployeesTable = "CREATE TABLE IF NOT EXISTS employees ("
	                      + "employee_id INT PRIMARY KEY,"
	                      + "employee_name VARCHAR(255),"
	                      + "employee_salary DOUBLE)";
	              stmt.executeUpdate(createEmployeesTable);
	              System.out.println("Employees table created successfully.");

	             
	              String createDepartmentsTable = "CREATE TABLE IF NOT EXISTS departments ("
	                      + "department_id INT PRIMARY KEY,"
	                      + "department_name VARCHAR(255),"
	                      + "employee_id INT,"
	                      + "FOREIGN KEY (employee_id) REFERENCES employees(employee_id))";
	              stmt.executeUpdate(createDepartmentsTable);
	              System.out.println("Departments table created successfully.");

	          } catch (Exception e) {
	              e.printStackTrace();
	          } finally {
	              try {
	                  if (stmt != null) stmt.close();
	                  if (conn != null) conn.close();
	              } catch (Exception e) {
	                  e.printStackTrace();
	              }
	          }
		}
}
