<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    
<nav class="main">
	<ul>
		<li class="home">Home</li>
		
		<c:if test="${empty USER}">
			<li class="user login">로그인</li>
			<li class="user join">회원가입</li>
		</c:if>
		
		<c:if test="${not empty USER}">
			<li class='user mypage'>My PAGE(${USER.username})</li>
			<li class='user logout'>로그아웃</li>
		</c:if>
		
		<c:if test="${USER.role == 'ROLE_ADMIN' }">
			<li class="admin">관리자</li>
		</c:if>
	</ul>
</nav>


