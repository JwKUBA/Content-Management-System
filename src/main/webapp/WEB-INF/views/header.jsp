<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<body>
 <a href="${pageContext.request.contextPath}/">Home</a>
 <a href="${pageContext.request.contextPath}/categories">Categories</a>
 <a href="${pageContext.request.contextPath}/authors">Authors</a>
 <a href="${pageContext.request.contextPath}/articles">Articles</a>
 <a href="${pageContext.request.contextPath}/drafts">Drafts</a>
</body>

</body>
</html>