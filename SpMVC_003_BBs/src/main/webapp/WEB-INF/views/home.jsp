<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 겔러리</title>
<link href="${rootPath }/static/css/main.css?2023-07-11-001" rel="stylesheet">

</head>
<body>
	<header class="main">
	<h1>이미지 겔러리</h1>
	</header>
	<table class="main">
		<tr>
			<th>SEQ</th>
			<th>작성시각</th>
			<th>작성일자</th>
			<th>닉네임</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
		<c:forEach begin="1" end="10" var="INDEX">
			<tr>
				<td>${INDEX}</td>
				<td>작성시각</td>
				<td>작성일자</td>
				<td>닉네임</td>
				<td>제목</td>
				<td>조회수</td>
			</tr>
		</c:forEach>	
	</table>

</body>
</html>