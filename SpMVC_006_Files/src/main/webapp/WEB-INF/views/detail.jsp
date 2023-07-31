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
	<div><strong>SEQ</strong><span>${BBS.b_seq}</span></div>
	<div><strong>제목</strong><span>${BBS.b_title}</span></div>
	<div><strong>내용</strong><span>${BBS.b_content}</span></div>
	<div><strong>대표이미지</strong>
		<img src="${rootPath}/upload/${BBS.b_image}" width="150px" 
			alt="${BBS.b_origin_image}"	/></div>

	<div><a href="${rootPath}/update?b_seq=${BBS.b_seq}">수정하기</a></div>

	<div>
	<c:if test="${not empty BBS.m_files }">
		<c:forEach items="${BBS.m_files}" var="file">
			<div>
			<img src="${rootPath}/upload/${file.f_image }"  width="100px">
			<a href="${rootPath}/img_delete?b_seq=${BBS.b_seq}&f_seq=${file.f_seq}">이미지 삭제</a>
			<a href="${rootPath}/img_top">대표이미지 설정</a>
			</div>
	</c:forEach>
	</c:if>
	</div>





</body>
</html>