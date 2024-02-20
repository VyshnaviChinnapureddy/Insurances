package com.servlet.insurance.controller;

import java.io.IOException;

import com.servlet.encapsulatedclass.Insuranceentity;
import com.servlet.insurance.Implementation.InsuranceImplementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InsuranceServlets extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public InsuranceServlets() {
		super();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post method triggered in Insurancedetails");
		
		String policycode = request.getParameter("policycode");
		String policyname = request.getParameter("policyname");
		String policytype = request.getParameter("policytype");
		String policysubtype = request.getParameter("policysubtype");
		String annualpremiumrange = request.getParameter("annualpremiumrange");
		String eligiblityage = request.getParameter("eligiblityage");
		String keybenefits = request.getParameter("keybenefits");
		
		Insuranceentity entity=new Insuranceentity();
		entity.setPolicycode(policycode);
		entity.setPolicyname(policyname);
		entity.setPolicytype(policytype);
		entity.setPolicysubtype(policysubtype);
		entity.setAnnualpremiumrange(annualpremiumrange);
		entity.setEligiblityage(eligiblityage);
		entity.setKeybenefits(keybenefits);
		
		InsuranceImplementation imp=new InsuranceImplementation();
		int result=imp.AddPolicydetails(entity);
		HttpSession session=request.getSession();
		session.setAttribute("Policydetails", entity);
		RequestDispatcher success=request.getRequestDispatcher("/Success.html");
		RequestDispatcher fail=request.getRequestDispatcher("/Failure.html");
			 
					if(result>0) {
						success.forward(request, response);
					}else {
						fail.forward(request, response);
					}
			
	}
}


