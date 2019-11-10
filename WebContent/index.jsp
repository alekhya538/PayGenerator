<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MYOB Payroll</title>
<style>

.button {
	width:175px;
	height:30px;
	background:blue;
	color:white;
	border-radius: 25px;
	font-weight:bold;
}
table {
	width:100%;
	height:100%;
}
h2 {
	color:#231D75;
}
.inputFileTextBox {
	width:600px; 
	height:20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
function isValidFileFormat(e) {	
	var filePath = $("#inputFile").val();
	var alertError = false;
	var extension = null;
	var i = filePath.lastIndexOf(".");
	if (i > 0) {
	    extension = filePath.substring(i+1);
	    if("csv" != extension) {
	    	alertError = true;
	    }
	} else {
		alertError = true;
	}
	if(alertError) {
		e.preventDefault();
		alert("Invalid file format. Please upload a valid CSV file (*.csv)");
		return false;
	}
	return true;
}
</script>
</head>
<body><br/><br/>
<p align="center"></p><br/><br/>
<table border=3><tr><td align="center">
<h2>Welcome to Payroll System</h2>
<br/><br/> 
<form method="post" action="generatePayslips" onsubmit="return isValidFileFormat(event)">
	<font size=4>Input file with employee details: </font><br/><br/>
	<input type="text" name="inputFile" id="inputFile" value="C:\dev\myob\PayGenerator\input\empList.csv" class="inputFileTextBox"> <br/><br/>
	<input type="submit" value="Generate Pay Details" class="button""/>
</form>

<br/><br/>
<font size=2.5>Copyright © 2019 <u>MYOB Technology</u> Pty Ltd. All rights reserved.</font><br/><br/>
</td>
</tr>
</table>
</body>
</html>
