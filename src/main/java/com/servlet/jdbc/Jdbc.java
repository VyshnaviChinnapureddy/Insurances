package com.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

	static Jdbc mysql=new Jdbc();
	static Connection con;
	
	private Jdbc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lifeinsurance","root","Vamsi123");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	public static Connection getinstance() {
		 return mysql.con;
	}

	public static void main(String[] args) {
		System.out.print(Jdbc.getinstance());

	}

}
