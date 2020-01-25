<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>SSA Registration Form</h1>
	<h3 style="color:green">${succMsg}</h3>
	<h3 style="color:red"><c:out value="${errMsg}"></c:out> </h3>
<table>
	<form:form action="/register" method="post"  modelAttribute="citizen">
	<form:hidden path="cid"/>
		<tr><th>First Name::</th><td>   <form:input path="fname"/></td></tr>
		<tr><th>Last Name::</th><td>    <form:input path="lname"/></td></tr>
		<tr><th>DateOfBirth::</th><td>  <form:input type="date" path="dob"/></td></tr>
		<tr><th >Gender::</th></tr>
		<tr>
		<td> <form:radiobutton path="gender" value="male"/>Male</td>
		<td><form:radiobutton path="gender" value="female"/>Female</td>
		</tr>
		<tr><th>State::</th><td>
		<form:select path="stateCode">
			<form:option value="">---Select A State---</form:option>
			<form:options  items="${states}"/>		
		</form:select></td></tr>
		<tr><th><input type="submit" value="Register"/></th></tr>
	</form:form>
</table>
</body>
</html>