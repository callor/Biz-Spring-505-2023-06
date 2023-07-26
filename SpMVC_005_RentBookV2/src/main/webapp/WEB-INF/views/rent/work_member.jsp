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
	<h1>회원검색</h1>
	<div>
		<p>도서코드:${RENT_WORK.rent_bcode}, 
			도서명:${RENT_WORK.b_name}, 
			출판사:${RENT_WORK.b_comp}</p>
	</div>
	<form:form action="${rootPath}/rent/member" modelAttribute="RENT_WORK">
		<div><label>회원명</label><form:input path="m_name" /></div>
		<div><label>회원코드</label><form:input path="rent_mcode" /></div>
		<div><label>전화번호</label><form:input path="m_tel" /></div>
		<div><button>다음 >> </button></div>
	</form:form>
</body>
</html>



