<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:form modelAttribute="BBS" enctype="multipart/form-data">
		<f:input placeholder="제목" path="b_title"/>
		<f:input placeholder="내용" path="b_content"/>
		
		<input placeholder="대표이미지" name="b_file" type="file" accept="image/*"/>
		<input placeholder="이미지들"   accept="image/*"
			name="b_files" type="file" multiple="multiple"/>
		<button>저장</button>
	</f:form>

</body>
</html>