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
<h1>Add/Edit Draft</h1>
<%@include file="/WEB-INF/views/header.jsp"%>

<form:form method="post" modelAttribute="article">
  <form:input path="title" placeholder="Title"/><form:errors path="title"/><br>
  
  <label for="content">Content</label><br>
  <form:textarea path="content" id="content"/><form:errors path="content"/><br>
   <form:input path="draft" type="hidden" value="true"/>
  <input type="submit"/>
 </form:form>

</body>
</html>