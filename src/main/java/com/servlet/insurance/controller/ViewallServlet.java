package com.servlet.insurance.controller;

import java.io.IOException;

import java.util.List;

import com.servlet.encapsulatedclass.Insuranceentity;
import com.servlet.insurance.Implementation.InsuranceImplementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewallServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewallServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Get is triggered");
        
        String policytype = request.getParameter("policytype");
        String sortBy = request.getParameter("sortby");
        // Assuming you retrieve policy types from request parameters
       // String policyType1 = request.getParameter("policyType1");
        //String policyType2 = request.getParameter("policyType2");

        InsuranceImplementation implementation = new InsuranceImplementation();
        List<Insuranceentity> result;
        if(sortBy.equalsIgnoreCase("Choose")) {
			result = implementation.fetch(policytype);
		} else {
			result = implementation.sort(policytype, sortBy);
		}
        HttpSession session = request.getSession();
        session.setAttribute("InsuranceDetails", result);

        RequestDispatcher req = request.getRequestDispatcher("/InsuranceDetails.jsp");
        try {
            req.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
