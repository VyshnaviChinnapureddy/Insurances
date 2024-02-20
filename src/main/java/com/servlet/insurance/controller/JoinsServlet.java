package com.servlet.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import com.servlet.encapsulatedclass.ClaimEntity;
import com.servlet.encapsulatedclass.EnrollmentEntity;
import com.servlet.encapsulatedclass.PolicyEntity;
import com.servlet.insurance.Implementation.Implementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class JoinsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public JoinsServlet() {
		super();
		
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Joins triggered");
		Implementation imp=new Implementation();
		
		try {
			Map<EnrollmentEntity,Map<PolicyEntity,ClaimEntity>> m=imp.Joins();
			HttpSession session=request.getSession();
	     	session.setAttribute("Joins",m);
	     	RequestDispatcher r1=request.getRequestDispatcher("/Claims.jsp");
	     	r1.forward(request, response);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
