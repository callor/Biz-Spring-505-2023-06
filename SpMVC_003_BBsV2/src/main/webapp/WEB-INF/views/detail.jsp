<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		prefix="c" %>
<c:set value="${pageContext.request.contextPath}"  
		var="rootPath"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p.image_list {
		width: 60%;
		margin:10px auto;
		display: flex;
	}
</style>
</head>
<body>
	<p>${BBS.b_seq}
	<p>${BBS.b_date}
	<p>${BBS.b_time}
	<p>${BBS.b_username}
	<p>${BBS.nickname}
	<p>${BBS.b_subject}
	<p>${BBS.b_content}
	<p>
	<c:if test="${empty BBS.b_image }">
		<img src="${rootPath}/static/no_image.png" width="200px" /> 
	</c:if>
	<c:if test="${not empty BBS.b_image}">
		<img src="${rootPath}/files/${BBS.b_image}" width="200px" /> 
	</c:if>

	<c:if test="${not empty FILES }">
		<p class="image_list">
			<c:forEach items="${FILES}" var="FILE">
				<img src="${rootPath}/files/${FILE.i_uploadName}" 
				width="100px"  />
				<span>&times;</span>
			</c:forEach>
		</p>		
	</c:if>			
</body>
</html>

