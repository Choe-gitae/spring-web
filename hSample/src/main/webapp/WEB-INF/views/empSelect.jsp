<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>empSelect.jsp</title>
</head>
<body>

<h2>사원정보 목록보기</h2>
<table>
	<c:forEach var="empVO" items="${ empList }">
	<tr>
		<td>${ empVO.empno }</td>
		<td>${ empVO.ename }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>