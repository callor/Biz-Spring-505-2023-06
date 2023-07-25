<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  
		prefix="form"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서검색</h1>
	<form:form action="${rootPath}/rent/book" modelAttribute="RENT_WORK">
		<div><label>도서명</label><form:input path="b_name" /></div>
		<div><label>도서코드</label><form:input path="rent_bcode" /></div>
		<div><label>도서출판사</label><form:input path="b_comp" /></div>
		<div><button>다음 >> </button></div>
	</form:form>
</body>
</html>



