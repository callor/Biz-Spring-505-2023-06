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
	<a href="${rootPath}/insert">주소 추가</a>
</div>




