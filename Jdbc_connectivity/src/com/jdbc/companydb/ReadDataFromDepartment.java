package com.jdbc.companydb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ReadDataFromDepartment {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost:3306/company_db";

	    static final String USER = "root";
	    static final String PASS = "root";
	    public static void main(String[] args) {
	    	
	    	 Connection conn = null;
	          Statement stmt = null;
			try {
				Class.forName(JDBC_DRIVER);
				
				System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
	            System.out.println("Retrieve data from departments table...");
	              stmt = conn.createStatement();
	              String query="select * from departments";
	  			
	  			ResultSet res = stmt.executeQuery(query);
	  			while(res.next()) {
	  				int department_id = res.getInt("department_id");
	  				String department_name = res.getString("department_name");
	  				int employee_id = res.getInt("employee_id");
	  				
	  				System.out.println("[ department_id :"+department_id+", department_name :"+department_name+", employee_id :"+employee_id+" ]");
	  				}
	             
				
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
