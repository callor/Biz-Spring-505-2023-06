<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>나의 홈페이지</title>
</head>
<body>
<h1>사진 겔러리</h1>
	<table>
		<tr>
			<td>SEQ</td>
			<td>제목</td>
		</tr>
		<c:forEach items="${BBS_LIST}" var="BBS">
			<tr>
				<td>${BBS.b_seq}</td>
				<td><a href="${rootPath}/detail?b_seq=${BBS.b_seq}">${BBS.b_title}</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${rootPath}/insert">겔러리 작성</a>
</body>
</html>



