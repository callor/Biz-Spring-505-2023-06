<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>빛고을 도서 대여</title>
  <link href="${rootPath}/static/css/main.css"  rel="stylesheet">
</head>
<body>
	<header class="main">
		<h1>빛고을 도서대여</h1>
		<p>빛고을 도서대여 시스템 2023</p>
	</header>
	<nav class="main">
		<ul>
			<li class="home"><a href="${rootPath}/">Home</a></li>

			<li class="rent"><a href="${rootPath}/rent">도서대여</a></li>

			<li class="book"><a href="${rootPath}/book">도서정보</a></li>
			<li class="member"><a href="${rootPath}/member">회원정보</a></li>

			<li class="login"><a href="${rootPath}/user/login">로그인</a></li>
			<li class="admin"><a href="${rootPath}/admin">관리자</a></li>
		</ul>
	</nav>
	<section class="main">
		<tiles:insertAttribute name="main-content"/>
	</section>
	<footer>
		<address>CopyRight &copy; All Right Reserved</address>
	</footer>
</body>
</html>