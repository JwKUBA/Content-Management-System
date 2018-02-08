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
<h1>Add/Edit Article</h1>

<form:form method="post" modelAttribute="article">
  <form:input path="title" placeholder="Title"/><form:errors path="title"/><br>
  <label for="author">Author</label>
  
  <form:select path="author" id="author">
   <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
  </form:select><br>
  
  <label for="category">Category</label><br>
  <form:select path="categories" multiple="true" id="category">
   <form:options items="${categories}" itemValue="id" itemLabel="name"/>
  </form:select><form:errors path="categories"/><br>
  
  <label for="content">Content</label><br>
  <form:textarea path="content" id="content"/><form:errors path="content"/><br>
  <input type="submit"/>
 </form:form>

</body>
</html>