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
	<h1>도서대여 처리</h1>
	<table class="rent">
		<tr>
			<th>도서코드</th>
			<th>도서명</th>
			<th>출판사</th>
			
			<th>회원코드</th>
			<th>회원명</th>
			<th>전화번호</th>
			
			<th>대출일</th>
			<th>반납예정일</th>
			<th>도서반납여부</th>
			<th>대여금액</th>
			
			<th>포인트</th>
		</tr>
		<c:forEach items="${RBOOKS}" var="RB">
			<tr>
				<td>${RB.rent_bcode}</td>
				<td>${RB.b_name}</td>
				<td>${RB.b_comp}</td>
				
				<td>${RB.rent_mcode}</td>
				<td>${RB.m_name}</td>
				<td>${RB.m_tel}</td>
				
				<td>${RB.rent_date}</td>
				<td>${RB.rent_return_date}</td>
				<td>${RB.rent_return_yn == 'Y' ? '반납' : '미반납' }</td>
				<td>${RB.rent_price}</td>
				<td>${RB.rent_point}</td>
			</tr>
		</c:forEach>
		
		
	</table>
	<div>
		<a href="${rootPath}/rent/insert">도서대여</a>
		<a href="${rootPath}/rent/return">도서반납</a>
	</div>
</body>
</html>





