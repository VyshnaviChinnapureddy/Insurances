<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claiming jsp</title>
</head>
<style>
body{
background-image: url(https://img.freepik.com/free-photo/white-cloud-blue-sky_74190-7709.jpg?size=626&ext=jpg);
background-repeat: no-repeat;
		background-position: center bottom;
		background-size:  100%;
		background-attachment: fixed;
}
table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	padding: 10px;
}

.a {
	
	border: none;
	color: black;
	padding: 16px 32px;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	opacity: 0.6;
	transition: 0.3s;
	display: inline-block;
	text-decoration: none;
	cursor: pointer;
	padding-right: 210px;
}

.a:hover {
	opacity: 1
}

.a {
	display: inline;
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
			src="https://tse3.mm.bing.net/th?id=OIP.3To-z7pvM4ygJquhzgirtAHaFU&pid=Api&P=0&h=180"
			width="1500" height="300">
		<h1 align="center">CLAIMING STATUS</h1>
		<h2>
			<b>CHOOSE POLICY</b>
		</h2>
		<button class="a">Natural Death-80%</button>
		<button class="a">Accident-80%</button>
		<button class="a">
			Hospitalization-50%</a>
		</button>
		<button class="a">Sudden death-100%</button>
		<div>
			<form action="Claiming.jsp" method="post">
				<h2>Enter Principle Amount</h2>
				<input type="text" name="principal_amount" placeholder="Enter Principle Amount"class="a">
				
				<h2>Select from above by choosing category accordingly</h2>
				<h2>Enter Interest Rate: </h2><input type="text" name="interest_rate" placeholder="Enter Interest Rate"
					class="a">&nbsp;&nbsp;&nbsp;&nbsp;<button>SUBMIT</button>
				
				
				    
			</form>
		</div>
		<%
		if (request.getMethod().equals("POST")) {
			float principal_amount = Float.parseFloat(request.getParameter("principal_amount"));
			float interest_rate = Float.parseFloat(request.getParameter("interest_rate"));
			float ip = interest_rate / 100;
			float cm = (principal_amount * ip);
			float mp = principal_amount - cm;
		%>
		<br>
		<table align="center">
			<tr>
				<th><b>CLAIMED MONEY</b></th>
				<th><b>REMAINING MONEY</b></th>
			</tr>
			<tr>
				<td><%=cm%></td>
				<td><%=mp%></td>
			</tr>

			<%
			}
			%>
		</table>
		<button class="button button1">
			<a href="Claiming.html">Go Back to Main Page</a>
		</button>
		<br><br><br>
		<button class="button button1">
			<a href="Index.html">Go Back to HomePage</a>
		</button>
</div>
</body>
</html>