<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import= "com.servlet.encapsulatedclass.PolicyEntity" %>
    <%@page import="com.servlet.encapsulatedclass.EnrollmentEntity" %>
    <%@page import="com.servlet.encapsulatedclass.ClaimEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLaims.jsp</title>
</head>
<style>
table,th,td{
border:1px solid black;
color:Black;
padding:10px;
}
#grad1 {
  height: 1000px;
  background-image: linear-gradient(to right, rgba(0,0,255,0), rgba(0,0,255,1));
}
</style>
<div id="grad1">
<body>
<img src="https://tse1.mm.bing.net/th?id=OIP.X6AvRjlbCpR2vXUkP7rZIwHaBz&pid=Api&P=0&h=180" width="150" aligin="left"><br>
<img src="https://tse3.mm.bing.net/th?id=OIP.juZyw-IW36ftHDXMfab7HQHaCe&pid=Api&P=0&h=180" width="1500" height="300"><br>
<h1 style="color:#4000ff">DETAILS OF SUBSCRIBER</h1>
<table>
<% Object obj=session.getAttribute("Joins");
if(obj==null){
	out.println("No records are found");
}else{
	Map<EnrollmentEntity, Map<PolicyEntity,ClaimEntity>> m =(Map<EnrollmentEntity, Map<PolicyEntity,ClaimEntity>>) obj;
%>
<tr>
<th><b>FIRST NAME</b></th> <th><b>DATE OF BIRTH</b></th> <th><b>MOBILE NUMBER</b></th> 
<th><b>POLICY NAME</b></th> <th><b>POLICY ID</b></th> <th><b>PREMIUM RANGE</b></th>   
<th><b>DATE CREATED</b></th><th><b>STATUS</b></th>
</tr>
<%
for(Map.Entry<EnrollmentEntity, Map<PolicyEntity,ClaimEntity>> me:m.entrySet()) {
	 
	
	Map<PolicyEntity,ClaimEntity>mee=me.getValue();
	for(Map.Entry<PolicyEntity,ClaimEntity>meee:mee.entrySet()){
	   
%>
<tr>
<td><%=me.getKey().getFirstname()%></td>
<td><%=me.getKey().getDateofBirth()%></td>
<td><%=me.getKey().getMobilenumber()%></td>
<td><%=me.getKey().getPolicyname() %></td>
<td><%=meee.getKey().getPolicyid()%></td>
<td><%=meee.getKey().getPremiumrange() %></td>
<td><%=meee.getValue().getDatecreated() %></td>
<td><%=meee.getValue().getStatus() %></td>
<%out.println(" "); %>
</tr>
<%}}} %>
</table>
<button><a href="Claiming.html">Go Back to HomePage</a></button>
</body>
<div>
</html>