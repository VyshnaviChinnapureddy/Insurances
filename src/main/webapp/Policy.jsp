<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.servlet.encapsulatedclass.PolicyEntity"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy details</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	color: Black;
	padding: 10px;
}

.button {
	background-color: darkblue;
	border: none;
	color: white;
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	margin-right: 320px;
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: powderblue;
	color: white;
	border: 2px solid darkblue;
}

.button1:hover {
	background-color: darkblue;
	color: white;
}

#grad1 {
	height: 1000px;
	background-image: linear-gradient(to right, rgba(0, 0, 255, 0),
		rgba(0, 0, 255, 1));
}
</style>
<div id="grad1">
	<body>
		<img
			src="https://tse1.mm.bing.net/th?id=OIP.X6AvRjlbCpR2vXUkP7rZIwHaBz&pid=Api&P=0&h=180"
			width="150" aligin="left">
		<br>
		<br>
		<img
			src="https://thumbs.dreamstime.com/z/life-insurance-claim-form-wooden-surface-life-insurance-claim-form-wooden-surface-near-leather-wallet-fountain-pen-blue-112432936.jpg?w=992"
			width="1500" height="300">
		<form action="PolicyServlet" method="Get">
			<button class="button button1">
				<input type="submit">
			</button>
			<table style="" align="center">
				<%
				Object obj = session.getAttribute("Policy");
				if (obj == null) {
					out.print("No records are found");
				} else {
					List<PolicyEntity> entity = (ArrayList<PolicyEntity>) obj;
				%>
				<tr>
					<th><b>POLICY ID</b></th>
					<th><b>POLICY NAME</b></th>
					<th><b>PREMIUM RANGE</b></th>
					<th><b>CLAIM</b></th>
					<th><b>ENTRY AGE</b></th>
					<th><b>END AGE</b></th>
				</tr>
				<%
				for (PolicyEntity c : entity) {
				%>
				<tr>
					<td><%=c.getPolicyid()%></td>
					<td><%=c.getPolicyname()%></td>
					<td><%=c.getPremiumrange()%></td>
					<td><%=c.getClaim()%></td>
					<td><%=c.getEntryage()%></td>
					<td><%=c.getEndage()%></td>
				</tr>
				<%
				}
				}
				%>
			</table>
			<button class="button button1">
				<a href="Claiming.html">Go Back to Main Page</a>
			</button><br>
			<button class="button button1">
				<a href="Index.html">Go Back to HomePage</a>
			</button>
	</body>
</div>
</html>