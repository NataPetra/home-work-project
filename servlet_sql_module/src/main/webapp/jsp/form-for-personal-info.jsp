<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta content="text/html">
<title>Registration Form</title>
</head>
<body>
<h1>Register Form</h1>
<div>
    <form action="../registration" method="post">
		<table style="with: 50%">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><input type="text" name="contact" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>