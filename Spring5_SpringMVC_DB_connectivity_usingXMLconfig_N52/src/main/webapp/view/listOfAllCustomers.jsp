<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information of Customers</title>
<link href="${pageContext.request.contextPath}/additional/css/beautify.css" rel="stylesheet">
</head>
<body>
<h2>List Of All Customers:-</h2>
<div style="overflow-x:auto;">
	<table>
		<tr>
			<th>Name</th>
			<th>Email Id</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>Country</th>
			<th>Language</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${listOfCustomers}" var="customer">
			<tr>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
				<td>${customer.dob}</td>
				<td>${customer.gender}</td>
				<td>${customer.country}</td>
				<td>
					<ul>
						<c:forEach items="${customer.language}" var="lang">
							<c:if test="${not empty lang}">
								<li>${lang}
							</c:if>
						</c:forEach>
					</ul>
				</td>
				<td>${customer.address}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>