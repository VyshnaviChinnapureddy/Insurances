<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator.jsp</title>
</head>
<body>
<style>
table,th,td{
border:1px black solid;
border-collapse:collapse;
color:Black;
width: 50%;
text-align: left;
padding: 8px;
}
tr:nth-child(odd) {
  background-color: #D6EEEE;
}
.a{
display:inline;
padding:10px;
margin:auto;
}
.button{
background-color:powderBlue;
color: white;
padding: 20px;
text-align: center;
text-decoration: none;
font-size: 16px;
margin: 4px 2px;
cursor: pointer;
}
.button1 {border-radius: 6px;}
</style>
<body>
<% if(request.getMethod().equals("POST")) {
        float principal_amount = Float.parseFloat(request.getParameter("principal_amount"));
        float interest_rate = Float.parseFloat(request.getParameter("interest_rate"));
        int tenure = Integer.parseInt(request.getParameter("tenure"));
        
        float ip = interest_rate / 100; // Interest rate as percentage
        float r = ip / 12; // Monthly interest rate
        double emi = (principal_amount * r * Math.pow(1 + r, tenure)) / (Math.pow(1 + r, tenure) - 1);
        String formattedEmi = String.format("%.2f", emi);
        %>
        
        <i><b><h1 style="color:blue">EMI: <%= formattedEmi %></h1></b></i>
        <h2>Amortization Schedule:</h2>
        <table border="1">
            <tr>
                <th>Month</th>
                <th>Opening Balance</th>
                <th>Monthly Interest</th>
                <th>Monthly Repayment</th>
                <th>Closing Balance</th>
            </tr>
            <% 
                double opening_balance = principal_amount;
                DecimalFormat df = new DecimalFormat("#.##");
                for(int i = 1; i <= tenure; i++) {
                    double monthly_interest = opening_balance * r;
                    double monthly_repayment = emi - monthly_interest;
                    double closing_balance = opening_balance - monthly_repayment;
            %>
            <tr>
                <td><%= i %></td>
                <td><%= df.format(opening_balance) %></td>
                <td><%= df.format(monthly_interest) %></td>
                <td><%= df.format(monthly_repayment) %></td>
                <td><%= df.format(closing_balance) %></td>
            </tr>
            <% 
                    opening_balance = closing_balance;
                }
            %>
        </table>
<% } %>
</body>
</html>
