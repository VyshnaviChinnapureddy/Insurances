<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import= "com.servlet.encapsulatedclass.ClaimEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim.jsp</title>
</head>
<style>
table,th,td{
border:1px solid black;
color:Black;
padding:10px;
}
.button {
  background-color:darkblue;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  margin-right:320px;
  transition-duration: 0.4s;
  cursor: pointer;
}
.button2 {
  background-color: powderblue; 
  color: white; 
  border: 2px solid darkblue;
}

.button2:hover {
  background-color:darkblue;
  color: white;
}
#grad1 {
  height: 1000px;
  background-image: linear-gradient(to right, rgba(0,0,255,0), rgba(0,0,255,1));
}
</style>
<div id="grad1">
<body>
<img src="https://tse1.mm.bing.net/th?id=OIP.X6AvRjlbCpR2vXUkP7rZIwHaBz&pid=Api&P=0&h=180" width="150" aligin="left"><br>
<img src="https://tse2.mm.bing.net/th?id=OIP.zJKAx-2ahUF81gl1lLXifwHaDb&pid=Api&P=0&h=180" width="1500" height="300">
<form action="ClaimServlet" method="Get">
<button class="button button2"><input type="submit" value="CLAIM HERE"></button>
<h1 style="color:#4000ff">STATUS FOR THE MONTH OF FEBRAURY</h1>
<table style="50%" align="center">
<%
Object obj=session.getAttribute("Claim");
if(obj==null){
	out.print("No records are found");
}else{
	List<ClaimEntity> entity=(ArrayList<ClaimEntity>) obj;
	%>
	<tr>
	<th><b>CLIENT NAME</b></th> <th><b>POLICY NAME</b> <th><b>DATE CREATED</b></th> <th><b>STATUS</b></th> 
	</tr>
	<%
	for(ClaimEntity c:entity){
	%>
	<tr>
	<td><%=c.getClientname() %></td>
	<td><%=c.getPolicyname()%></td>
	<td><%=c.getDatecreated()%></td>
	<td><%=c.getStatus()%></td>
	</tr>
	<%}} %>
	</table>
	<button class="button button2"><a href="Claiming.html">Go Back to HomePage</a></button>
</form>
</body>
</div>
</html>