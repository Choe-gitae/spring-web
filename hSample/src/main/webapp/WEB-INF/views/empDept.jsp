<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empDept.jsp</title>
</head>
<body>
<h2>부서정보</h2>
<table>
	<c:forEach var="map" items="${ result }">
	<tr>
		<td>${ map.EMPNO }</td>
		<td>${ map.ENAME }</td>
		<td>${ map.DNAME }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>