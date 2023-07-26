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
	<%
	/*
	현재 member/input.jsp 는 /member/insert 와 /member/update 에서
	사용하는 form 입력화면이다
	insert 에서는 MEMBER 객체를 새로만들어(데이터가 모두 blank) input.jsp 에 
	보내고 있으며, update 에서는 bcode 를 가지고 findById() method 호출하여
	데이터를 SELECT 하고 그 데이터를 input.jsp 로 보내고 있다
	
	MEMBER.m_code 데이터는 insert 일때는 empty(blank) 이고 update 일때는 아니다
	
	*/
	%>
	<h1>회원정보 ${empty MEMBER.m_code ? '추가' : '수정' }</h1>
	<c:if test="${not empty MESSAGE && MESSAGE == 'NAME_TEL' }">
		<h2>* 이름과 전화번호 데이터가 이미 등록되어 있습니다</h2>
	</c:if>
	<form:form modelAttribute="MEMBER">
		<div><label>전화번호</label><form:input path="m_tel" /></div>
		<div><label>이름</label><form:input path="m_name"/></div>
		<div><label>주소</label><form:input path="m_addr"/></div>
		<div>
			<a href="${rootPath}/member">리스트로</a>
			<button type="submit">저장하기</button>
			<button type="reset">새로작성</button>
		</div>	
	</form:form>
</body>
</html>

