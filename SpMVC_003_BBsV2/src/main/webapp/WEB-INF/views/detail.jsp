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
</head>
<body>
	<p>${BBS.b_seq}
	<p>${BBS.b_date}
	<p>${BBS.b_time}
	<p>${BBS.b_username}
	<p>${BBS.nickname}
	<p>${BBS.b_subject}
	<p>${BBS.b_content}
	<p><img src="${rootPath}/files/${BBS.b_image}"  
			width="200px" /> 
</body>
</html>

