<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information</title>
<link href="${pageContext.request.contextPath}/additional/css/beautify.css" rel="stylesheet">
</head>
<body>

<div class="home-refresh">
	<a href="${pageContext.request.contextPath}"><button class="home">Home</button></a>
	<a href="${pageContext.request.contextPath}/form"><button class="refresh">Refresh</button></a><br>
</div>

<p><span style="color: #f83053">Name:</span> ${customer.name}<br>
<p><span style="color: #f83053">Email Id:</span> ${customer.email}<br>
<p><span style="color: #f83053">Date Of Birth:</span> <fmt:formatDate value="${customer.dateOfBirth}" type="date"/><br>
<p><span style="color: #f83053">Gender:</span> ${customer.gender}<br>
<p><span style="color: #f83053">Country:</span> ${customer.country}<br>
<p><span style="color: #f83053">Languages:</span> 
<c:forEach items="${customer.language}" var="lang">
${lang} | 
</c:forEach><br>
<p><span style="color: #f83053">Address:</span> ${customer.address}
</body>
</html>