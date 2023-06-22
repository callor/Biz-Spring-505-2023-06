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