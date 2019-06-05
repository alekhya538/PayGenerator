<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Pay Details</title>
<style>

tr, td {
	padding: 10px;
  	border: 1px solid black;
}
table {
  table-layout: fixed;
  width: 100%;
  border-collapse: collapse;
  border: 1px solid purple;
}
.error{
	color:red;
	font-weight:bold;
}
</style>
</head>
<body><br/><br/>
<p align="center"><img src="/PayGenerator/images/myobLogo.jpg" /></p><br/><br/>

<h3><font color="#231D75">Employee Income Details:</font></h3>

<table border=1 align=center>
<tr bgcolor="#DAFAFA">
<td><b>Employee Name</b></td>
<td><b>Pay Period</b></td>
<td><b>Gross Income</b></td>
<td><b>Income Tax</b></td>
<td><b>Net Income</b></td>
<td><b>Super Annuation</b></td>
</tr>

<% List empList = (List)request.getAttribute("employeeList");
   if(empList.size() == 0) { %>
<tr>
<td colspan=6 class="error">The given input file is either not found or is empty. Please check.
</tr>
<%} else {%>
<c:forEach items="${employeeList}" var="employee">
<tr>
	<td>${employee.firstName} ${employee.lastName}</td>
	<td>${employee.payMonth}</td>
	<td>${employee.grossMonthlyIncome}</td>
	<td>${employee.incomeTax}</td>
	<td>${employee.netMonthlyIncome}</td>
	<td>${employee.superAnnuation}</td>
</tr>
</c:forEach>
<%} %>
</table>
<br/><br/>
<p align="center"><font size=2.5>Copyright © 2019 <u>MYOB Technology</u>u> Pty Ltd. All rights reserved.</font></p><br/><br/>
</body>
</html>