<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<h1>Home Page</h1>

	<h2>Last 5 Articles</h2>
	<c:forEach var="a" items="${lastArticles}">
		<table border="1">
			<tr>
				<th scope="col">Title</th>
				<th scope="col">Created
				<th>
			</tr>
			<tr>
				<td>${a.title}</td>
				<td>${a.created}</td>
			</tr>
		</table>
		<p>${a.content}</p>
	</c:forEach>
	<br></br>

	<form action="post">
		<h1>Categories</h1>
		<c:forEach items="${allCategories}" var="category">
			<c:out value="${category.name}" />
			<a href="${pageContext.request.contextPath}/categories/edit/${category.id}">Display</a>
		</c:forEach>
	</form>


</body>
</html>