<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
</head>
<body>
<h3>
	Update Employee Details:
</h3>

<c:url var="addAction" value="/Employee/update" ></c:url>

<form:form action="${addAction}" commandName="employee">
<table style=" font-family:serif; font-size:medium; border-width:2px; border-color:#ccc; ">
	<c:if test="${!empty employee.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="Employee ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>
	</tr>
	<tr>
	<td>
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
		</td>
		<td></td>
	</tr>
</table>	
</form:form>
<br>

</body>
</html>