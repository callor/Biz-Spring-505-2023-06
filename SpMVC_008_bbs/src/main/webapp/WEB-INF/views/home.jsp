<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>반갑습니다</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="${rootPath}/">Home</a></li>
			<li><a href="${rootPath}/notice">공지사항</a></li>
			<li><a href="${rootPath}/bbs">자유게시판</a></li>
			
			<sec:authorize access="isAnonymous()">
				<li><a href="${rootPath}/user/join">회원가입</a></li>
				<li><a href="${rootPath}/user/login">로그인</a></li>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<li><a href="${rootPath}/user/mypage">MyPage</a></li>
				<li><a href="${rootPath}/user/logout">로그아웃</a></li>
				<sec:authorize access="hasRole('ADMIN')">
					<li><a href="${rootPath}/admin">관리자</a></li>
				</sec:authorize>
			</sec:authorize>
		</ul>
	</nav>
	
	<sec:authorize access="isAuthenticated()">
		<form:form action="${rootPath}/logout">
			<button>로그아웃</button>
		</form:form>	

		<form action="${rootPath}/logout" method="POST">
			<p>Spring Security 에서는 form POST 로 데이터를 전송할때는
			반드시 token 을 같이 실어서 보내야 한다.</p>
			
			<input name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
			<button>로그아웃</button>
		</form>
	</sec:authorize>
	
</body>
</html>