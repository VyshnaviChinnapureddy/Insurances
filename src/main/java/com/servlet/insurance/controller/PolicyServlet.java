package com.servlet.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.servlet.encapsulatedclass.PolicyEntity;
import com.servlet.insurance.Implementation.Implementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PolicyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public PolicyServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get method triggered in fetch");
		Implementation imp=new Implementation();
		try {
			List<PolicyEntity> r= imp.Fetch();
			HttpSession session= request.getSession(); 
			session.setAttribute("Policy", r);
			RequestDispatcher r1= request.getRequestDispatcher("/Policy.jsp");
			r1.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
