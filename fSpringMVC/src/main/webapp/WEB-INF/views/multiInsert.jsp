<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>multiInsert.jsp</title>
</head>
<body>
<h3>멤버 리스트</h3>
<table>
	<tr>
		<th>아이디</th><th>이름</th><th>나이</th>
	</tr>
	<c:forEach var="list" items="${ memberVOList.list }">
	<c:if test="${ list.state }">
	<tr>
		<td>${ list.id }</td>
		<td>${ list.name }</td>
		<td>${ list.age }</td>
	</tr>
	</c:if>
	</c:forEach>
</table>
</body>
</html>