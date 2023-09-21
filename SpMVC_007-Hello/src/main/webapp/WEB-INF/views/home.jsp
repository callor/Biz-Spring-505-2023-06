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
	<h1>반갑습니다</h1>
	
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