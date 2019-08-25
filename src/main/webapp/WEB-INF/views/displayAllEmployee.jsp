<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Serif, sans-serif;font-size:15px;padding:6px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Serif, sans-serif;font-size:15px;font-weight:normal;padding:6px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h3>All Employee Details</h3>
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="90">Employee ID</th>
		<th width="120">Employee Name</th>
		<th width="120">Employee Country</th>
		<th width="40">Edit</th>
		<th width="40">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="emp">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.country}</td>
			<td><a href="<c:url value='/employee/${emp.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/employee/remove/${emp.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<br/><br>
   <a href="http://localhost:8080/portal/add" class="tg">Add New Employee</a>  
</body>
</html>
