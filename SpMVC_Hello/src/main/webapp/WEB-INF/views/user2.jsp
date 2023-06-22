<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul {
		display:flex;
		list-style: none; 
	}
	li {
		padding:5px;
	}
</style>
</head>
<body>
	<h1>나의 친구들</h1>
	<table>
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<tr>
			<td>${ADDRS[0].name}</td>
			<td>${ADDRS[0].age}</td>
			<td>${ADDRS[0].tel}</td>
			<td>${ADDRS[0].address}</td>
		</tr>
	</table>


	<c:forEach items="${ADDRS}" var="ADDR">
		<ul>
			<li>${ADDR.name}</li>
			<li>${ADDR.age}</li>
			<li>${ADDR.tel}</li>
			<li>${ADDR.address}</li>
		</ul>
	</c:forEach>
</body>
</html>