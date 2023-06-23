<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
		<div><input name="username" placeholder="USERNAME"/></div>
		<div><input name="password" type="password" 
				placeholder="PASSWORD"/></div>
		<div><button>로그인</button></div>
		<%
		/*
		a tag 를 사용하여 서버에 Request 를 요청할때는 context(서비스) Path가
		혼동되어 잘 링크가 연결되지 않는 경우가 많다
		이때는 링크 주소 앞에  ${pageContext.request.contextPath} 를 부착하면
		링크가 혼동되지 않고 원할이 연결 된다
		*/
		%>
		<div><a href="${pageContext.request.contextPath}/user/join">회원가입</a></div>
	</form>
</body>
</html>




