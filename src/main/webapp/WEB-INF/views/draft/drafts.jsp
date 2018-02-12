<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Draft</title>
</head>
<body>
 <h1>Draft</h1>
 <%@include file="/WEB-INF/views/header.jsp"%>
 
 <table border="1">
  <tr>
   <th scope="col">Title</th>
   <th scope="col">Created</th>
   <th scope="col">Updated</th>
   <th colspan="2">Actions</th>
  </tr>
  <c:forEach var="a" items="${draftAll}">
   <tr>
    <td>${a.title}</td>
      <td>${a.created}</td>
      <td>${a.updated}</td>
    <td><a href="${pageContext.request.contextPath}/drafts/edit/${a.id}">Edit</a></td>
    <td><a href="${pageContext.request.contextPath}/drafts/delete/${a.id}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
 <a href="${pageContext.request.contextPath}/drafts/add">Add new drafts</a>
 

</body>
</html>