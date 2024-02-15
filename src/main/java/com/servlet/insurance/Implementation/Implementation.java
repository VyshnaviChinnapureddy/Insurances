package com.servlet.insurance.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.servlet.encapsulatedclass.EnrollmentEntity;
import com.servlet.jdbc.Jdbc;

public class Implementation {

	Connection con;
    PreparedStatement prep;
    
	public Implementation() {
		con=Jdbc.getinstance();
	}
	
	public int Enrollment(EnrollmentEntity entity) throws SQLException {
		int result=0;
		System.out.println("method triggered in enrollment");
		String query="insert into Enrollment values(?,?,?,?,?,?,?)";
		prep=con.prepareStatement(query);
		prep.setInt(1,entity.getSno());
		prep.setString(2,entity.getFirstname());
		prep.setString(3,entity.getLastname());
		prep.setString(4,entity.getDateofBirth());
		prep.setString(5,entity.getGmailid());
		prep.setString(6,entity.getAddress());
		prep.setString(7,entity.getPackagename());
		result=prep.executeUpdate();
		return result;
	}
}
