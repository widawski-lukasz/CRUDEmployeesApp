<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD Employees App</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="save" method="post">
<table>
<tr><td>First name:</td><td><input type="text" name="namein"/></td></tr>
<tr><td>Last name:</td><td><input type="text" name="lnamein"/></td></tr>
<tr><td>Email:</td><td><input type="text" name="emailin" /></td></tr>
<tr><td>Country:</td><td><select name="Country" style="width:150px">
<option>POLAND</option>
<option>USA</option>
<option>GERMANY</option>
<option>OTHER</option>
</select></td></tr>
<tr><td colspan="2"><input type="submit" value="Save Employee"/></td>
<td colspan="2"><a href="view"><input type="button" value="Show table of employees" /></a></td></tr>
</table>
</form>
</body>
</html>