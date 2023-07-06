<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 TODO List</title>
<link href="${rootPath }/static/css/main.css?2023-07-06-008" 
		rel="stylesheet">
</head>
<body>
	<header>
		<h1>반갑습니다</h1>
	</header>
	<section class="main">
		<form>
			<input placeholder="작성일자"/>
			<input placeholder="작성시각"/>
			<input placeholder="할일"/>
		</form>
		<table>
			<tr>
				<td>2023-07-06</td>
				<td>14:20:00</td>
				<td>팀프로젝트</td>
			</tr>
		</table>
	</section>
</body>
</html>