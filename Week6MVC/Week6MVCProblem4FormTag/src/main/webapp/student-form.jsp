<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registraton Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
    First name:<form:input path="firstName"/>
    <br/><br/>
    Last name:<form:input path="lastName"/>
    <br/><br/>
    <input type="submit" vlaue="Submit">
    </form:form>
    
</body>
</html>