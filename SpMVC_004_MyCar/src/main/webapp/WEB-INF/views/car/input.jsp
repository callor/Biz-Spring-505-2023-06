<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<form method="POST">
	<div><input placeholder="차량번호" value="${CAR.c_carnum}"/></div>
	<div><input placeholder="업무구분"  value="${CAR.c_qty}"/></div>
	<div><input placeholder="사용자"  value="${CAR.c_username}"/></div>
	<div><input placeholder="시작일자"  value="${CAR.c_sdate}"/></div>
	<div><input placeholder="시작시간" value="${CAR.c_stime}"/></div>
</form>