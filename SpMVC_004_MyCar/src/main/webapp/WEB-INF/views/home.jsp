<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY CAR</title>
<link href="${rootPath}/static/css/main.css"  rel="stylesheet">
<link href="${rootPath}/static/css/input.css"  rel="stylesheet">

<script src="${rootPath}/static/js/main_input.js"></script>
<script src="${rootPath}/static/js/main_input_validation.js"></script>
</head>
<body>
	<header class="main">
		<h1>my car</h1>
		<p>MY CAR MANAGER 2023</p>
	</header>
	<nav class="main">
		<ul>
			<li>Home</li>
			<li>내차등록</li>
			<li>차량운행</li>
			
			<li>로그인</li>
			<li>회원가입</li>
	
			<li>로그아웃</li>
			<li>마이페이지</li>		
		</ul>
	</nav>
	<section class="main">
		<%@ include file="/WEB-INF/views/car/input.jsp" %>
	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com All Right Reserved</address>
	</footer>
</body>
</html>



