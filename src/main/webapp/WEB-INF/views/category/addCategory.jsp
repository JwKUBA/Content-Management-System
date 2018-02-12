<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h1>Add Categories</h1>
	<%@include file="/WEB-INF/views/header.jsp"%>


	<form:form method="post" modelAttribute="category">
  <form:input path="name" placeholder="Name"/><form:errors path="name"/><br>
  <form:textarea path="description" placeholder="Description..."/><br>
  <input type="submit"/>
 </form:form>


</body>
</html>