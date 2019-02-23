<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <title>Employee Registration Form</title>
 
</head>
 
<body>
 
    <h3>Registration Form</h3>
  
    <form:form method="POST" modelAttribute="Employee" action="employee/add">
        <table style=" font-family:serif; font-size:medium; border-width:2px; border-color:#ccc ">
        
            <tr>
                <td>Employee ID</td>
                <td><input type="text" name="id" id="id"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" id="country"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"/></td>
            </tr>                                 
        </table>	
    </form:form>
    <br/>
    <p style=" font-family: serif; ; font-size:medium; ; border: thin;">
 <a href="<c:url value='/employees' />">List of All Employees</a>
 </p>
</body>
</html>