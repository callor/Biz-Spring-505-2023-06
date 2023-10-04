<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다</h1>
	
	<p>
	Spring Security 에서 logout 은 반드시 POST form 으로 구현해야 한다
	또한  POST form 으로 서버에 요청을 전달할때는 csrf_token 을 반드시 같이
	전송해야 한다. 
	이러한 코드를 간소화하게 구현하기 위해 spring form tag 를 사용한다
	</p>
	<sec:authorize access="isAuthenticated()">
		<form:form action="${rootPath}/logout">
			<button>로그 아웃</button>
		</form:form>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href="${rootPath}/login">로그인</a>
	</sec:authorize>
	
</body>
</html>