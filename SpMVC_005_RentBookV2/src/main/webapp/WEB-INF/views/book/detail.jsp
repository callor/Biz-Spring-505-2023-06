<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>도서정보 상세보기</h1>
	<div><strong>도서코드 : </strong>${BOOK.b_code}</div>
	<div><strong>도서명 : </strong>${BOOK.b_name}</div>
	<div><strong>저자 : </strong>${BOOK.b_auther}</div>
	<div><strong>출판사 : </strong>${BOOK.b_comp}</div>
	<div><strong>구입연도 : </strong>${BOOK.b_year}</div>
	<div><strong>구입가격 : </strong>${BOOK.b_iprice}</div>
	<div><strong>대여가격 : </strong>${BOOK.b_rprice}</div>
	<div>
		<a href="${rootPath}/book/${BOOK.b_code}/update">수정하기</a>
		<a href="${rootPath}/book/${BOOK.b_code}/expire">사용중지</a>
	</div>
</body>
</html>