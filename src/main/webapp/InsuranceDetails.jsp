<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.servlet.encapsulatedclass.Insuranceentity" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View All</title>
    <style>
        table, th, td {
            border: 1px solid black;
            color: black;
            padding: 10px;
        }
    </style>
</head>
<body>
<img src="https://tse1.mm.bing.net/th?id=OIP.X6AvRjlbCpR2vXUkP7rZIwHaBz&pid=Api&P=0&h=180" width="150" aligin="left"><br>
<img src="https://img.freepik.com/premium-photo/businessman-two-hands-protecting-family-wooden-model-insurance-assurance-life-concept_50039-3830.jpg?size=626&ext=jpg" width="1500" height="300"><br>
    <h2>The details in your database are as follows</h2>

    <table>
        <%
            Object obj = session.getAttribute("InsuranceDetails");
            if (obj == null) {
                out.print("No records found:");
            } else {
                List<Insuranceentity> entity = (ArrayList<Insuranceentity>) obj;
                
        %>
        <tr>
            <th>Policy Code:</th>
            <th>Policy Name:</th>
            <th>Policy Type:</th>
            <th>Policy Subtype:</th>
            <th>Annual Premium Range:</th>
            <th>Eligibility Age:</th>
            <th>Key Benefits:</th>
            
        </tr>
        <%   for (Insuranceentity c : entity) { %>
        <tr>
            <td><%= c.getPolicycode() %></td>
            <td><%= c.getPolicyname() %></td>
            <td><%= c.getPolicytype() %></td>
            <td><%= c.getPolicysubtype() %></td>
            <td><%= c.getAnnualpremiumrange() %></td>
            <td><%= c.getEligiblityage() %></td>
            <td><%= c.getKeybenefits() %></td>
             </tr>
        <% } } %>
    </table>
    <button><a href="Fetch.html">Back</a></button>
    <button><a href="Index.html">Back to Homepage</a></button>
    
</body>
</html>