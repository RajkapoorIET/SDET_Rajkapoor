package com.jdbcConnection;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

public class SQLExecutor {	
	private final String url;
	private final String userName;
	private final String password;
	
	public SQLExecutor(String className, String url, String userName,String password) throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName(className);
		this.url=url;
		this.userName = userName;
		this.password = password;
	}
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,userName,password);
		
	}
	
	private void printMetaData(Connection connection) throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		String format = "\nDatabase metadata\n"
				      +"Database name :%s\n"
				+"Database version :%s\n"
				      +"Database driverName :%s\n"
				+"Database driver version :%s\n\n";
		System.out.printf(format, metaData.getDatabaseProductName(),
				                    metaData.getDatabaseProductVersion(),
				                    metaData.getDriverName(),
				                    metaData.getDriverVersion());
		
	}
	public void executeFile(String path) throws SQLException, FileNotFoundException, IOException {
		try(FileReader reader = new FileReader(path);
				BufferedReader br = new BufferedReader(reader);
				
				Connection connection = getConnection();
				Statement st = connection.createStatement();){
			printMetaData(connection);
			System.out.println("Executing command at :"+path);
			
			StringBuilder sb = new StringBuilder();
			String line;
			int lineNumber = 0;
			int count =0;
			while ((line=br.readLine())!=null) {
				lineNumber +=1;
				line = line.trim();
				if(line.isEmpty() || line.startsWith("-"))
					continue;
				sb.append(line);
				
				if(line.endsWith(";"))
					try {
						st.execute(sb.toString());
						System.out.println(++count+"Command Successfully Executed: "+sb.substring(0,Math.min(sb.length(),15)) +" ...");
						sb.setLength(0);
					}
				catch(SQLException e) {
					System.err.println("At line "+lineNumber+ ":"+e.getMessage()+"\n");
					return;
				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("**** Welcome to SQL file executor ****\n");
		System.out.println("Enter Class name");
		String className=sc.nextLine();
		System.out.println("Enter Connection String url");
		String url=sc.nextLine();
		System.out.println("Enter Database user name");
		String user=sc.nextLine();
		System.out.println("Enter database passowrd");
		String password=sc.nextLine();
		try {
			SQLExecutor executor =  new SQLExecutor(className,url, user, password);
			System.out.println("Enter the file Path");
			executor.executeFile(sc.nextLine());
			sc.close();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}
	
	

}
