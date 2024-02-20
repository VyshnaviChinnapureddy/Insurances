package com.servlet.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.servlet.encapsulatedclass.ClaimEntity;
import com.servlet.encapsulatedclass.EnrollmentEntity;
import com.servlet.encapsulatedclass.LoansEntity;
import com.servlet.encapsulatedclass.PolicyEntity;
import com.servlet.insurance.Implementation.Implementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProfServelt extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Joins triggered");
		Implementation imp=new Implementation();
		
		try {
			Map<EnrollmentEntity,Map<PolicyEntity,LoansEntity>> m=imp.Joining();
			HttpSession session=request.getSession();
	     	session.setAttribute("Profiless",m);
	     	RequestDispatcher r1=request.getRequestDispatcher("/Profiles.jsp");
	     	r1.forward(request, response);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}


