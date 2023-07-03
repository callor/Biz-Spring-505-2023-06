<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table class="main list">
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
	</tr>
	<c:forEach begin="0"  end="10"  var="INDEX">
		<c:set value="${ADDRS[INDEX]}" var="ADDR"/>
		<%
		// td를 감싸고 있는 tr 요소에
		// 현재 리스트의 주소정보의 a_id 값을 
		// data-id 속성에 세팅하기
		// data 는 tag 의 속성이고 -변수 형식으로 만든다
		// id = ${ADDR.a_id} 와 같은 변수를 생성하는 것이 된다
		%>
		<tr data-id="${ADDR.a_id}">
			<td>${ADDR.a_id}</td>	
			<td>${ADDR.a_name}</td>	
			<td>${ADDR.a_tel}</td>	
			<td>${ADDR.a_addr}</td>
		</tr>		
	</c:forEach>
</table>
<div class="main pagination">
	<ul>
		<c:forEach begin="1"  end="10" var="PAGE">
			<li>${PAGE}</li>
		</c:forEach>
	</ul>
</div>
<div class="main button_box">
	<%
	// 주소 추가를 클릭하면
	// 서버에 /insert URL 로 GET request 르 보낸다
	// 		GET /insert HTTP1.0
	%>
	<a href="${rootPath}/insert">주소 추가</a>
</div>




