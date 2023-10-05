<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		width:100vw;
	}
	body * {
	  width: 60%;
	  margin:5px auto;
	}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form:form method="POST">
		<div><label>username : </label><input name="username"></div>
		<div><label>password : </label><input name="password"></div>
		<div><label>email : </label><input name="email"></div>
		<div><label>닉네임 : </label><input name="nickname"></div>
		<div><button>회원가입</button></div>
	</form:form>
</body>
</html>