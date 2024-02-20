package com.servlet.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.servlet.encapsulatedclass.ClaimEntity;
import com.servlet.insurance.Implementation.Implementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ClaimServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
  public  ClaimServlet() {
	  super();
  }
  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	  
	  System.out.println("Get method triggered in fetch1");
		Implementation imp=new Implementation();
		try {
			List<ClaimEntity> r= imp.Fetch1();
			HttpSession session= request.getSession(); 
			session.setAttribute("Claim", r);
			RequestDispatcher r1= request.getRequestDispatcher("/Claim.jsp");
			r1.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
