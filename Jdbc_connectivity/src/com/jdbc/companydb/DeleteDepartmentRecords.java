package com.jdbc.companydb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DeleteDepartmentRecords {
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
				
	            System.out.println("delete a record into the departments table...");
	              stmt = conn.createStatement();
	              String query="delete from departments where department_id=100";
	  			int res = stmt.executeUpdate(query);
	  			System.out.println(res+" row delete successfully!!!");
				
	             
				
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
