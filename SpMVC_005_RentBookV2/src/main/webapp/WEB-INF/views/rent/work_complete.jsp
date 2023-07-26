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
	<h1>검색된 내용 확인</h1>
	<div>
		도서코드:${RENT_WORK.rent_bcode},
		도서명:${RENT_WORK.b_name},
		출판사:${RENT_WORK.b_comp }
	</div>
	<div>
		회원코드:${RENT_WORK.rent_mcode},
		회원명:${RENT_WORK.m_name},
		전화번호:${RENT_WORK.m_tel}
	</div>
	
	<form:form action="${rootPath}/rent/insert" modelAttribute="RENT_WORK">
		<div><label>대여일자: </label><form:input path="rent_date" /></div>
		<div><label>반납예정일자: </label><form:input path="rent_return_date" /></div>
		<div><label>대여금액: </label><form:input path="rent_price" /></div>
		<div><button>대여실행</button></div>
	</form:form>

</body>
</html>


