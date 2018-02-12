<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<h1>Category: ${category.name}</h1>
 <c:forEach var="cat" items="${categoryArticles}">
 <p>Title: ${cat.title} : Author: ${cat.author.firstName}</p>
 <a href="${pageContext.request.contextPath}/articles/show/${cat.id}">Show</a>
 </c:forEach>



</body>
</html>