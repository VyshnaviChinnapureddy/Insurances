package com.servlet.insurance.controller;

import java.io.IOException;

import com.servlet.encapsulatedclass.Insuranceentity;
import com.servlet.insurance.Implementation.InsuranceImplementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public DeleteServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("Delete Servlet Class Get Method Triggered");
		 String policycode = request.getParameter("policycode");
		 Insuranceentity entity = new  Insuranceentity();
		 String code = policycode.toLowerCase();
		 entity.setPolicycode(code);;
		 
		 InsuranceImplementation imp = new InsuranceImplementation();
		 int result = imp.delete(entity);
		 
		 RequestDispatcher success = request.getRequestDispatcher("/Success.html");
		 RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
		 
		 if(result>0) {
			 success.forward(request, response);
		 }else {
			 failure.forward(request, response);
		 }
		 
		 
	}
}
