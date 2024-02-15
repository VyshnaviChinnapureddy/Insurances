package com.servlet.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import com.servlet.encapsulatedclass.EnrollmentEntity;
import com.servlet.insurance.Implementation.Implementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EnrollmentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post method triggered in Enrollment");
		String sno=request.getParameter("sno");
		int fsno=0;
		try {
			fsno=Integer.parseInt(sno);
		}catch(Exception e) {
			fsno=0;
		}
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String DateofBirth=request.getParameter("DateofBirth");
		String gmailid=request.getParameter("gmailid");
		String Address=request.getParameter("Address");
		String packagename=request.getParameter("packagename");
		
		EnrollmentEntity entity=new EnrollmentEntity();
		entity.setSno(fsno);
		entity.setFirstname(firstname);
		entity.setLastname(lastname);
		entity.setDateofBirth(DateofBirth);
		entity.setGmailid(gmailid);
		entity.setAddress(Address);
		entity.setPackagename(packagename);
		
		
		Implementation imp=new Implementation();
	    int result=0;
			 try {
				 result=imp.Enrollment(entity);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 HttpSession session=request.getSession();
				session.setAttribute("enroll", entity);
				RequestDispatcher success=request.getRequestDispatcher("/Success.html");
				RequestDispatcher fail=request.getRequestDispatcher("Failure.html");
					if(result>0) {
						success.forward(request, response);
					}else {
						fail.forward(request, response);
					}
			 
				
			
		
		
	} 

}
