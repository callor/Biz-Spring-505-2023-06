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
   <style>
   		ul {
   			list-style: none;
   			display: flex;
   			flex-wrap: wrap;
   		}
   		
   		li {
   			width: 120px;
   			height: 200px;
   			padding:20px 15px; 
   		}
   		
   		span.thumb {
   			padding:10px;
   			display: flex;
   			flex-direction: column;
   			align-items: center;
   			background-color: #ccc;
   			
   			height: 120px;
   			position: relative;
   		}
   		
   		span.thumb em {
   			position: absolute;
   			top:0;
   			left :0;
   			width: 100%;
   			height: 100%;
   			line-height:120px;
   			text-align: center;
   			background-color:rgba(0,0,0,0.5);
   			opacity: 0;
   			transition: all 0.3s;
   		}
   		
   		span.thumb em:hover {
   			opacity: 1;
   		}
   		
   		
   </style>
</head>
<body>
<h1>사진 겔러리</h1>
	<ul>
	<c:forEach items="${BBS_LIST}" var="BBS">
		<li>
		<a href="${rootPath}/detail?b_seq=${BBS.b_seq}">
			<span class="thumb">
				<img src="${rootPath}/upload/${BBS.b_image}" width="100px"/>
				<em>View</em>
			</span>
			<strong>${BBS.b_title}</strong>
		</a>
		</li>
	</c:forEach>
	</ul>
	<a href="${rootPath}/insert">겔러리 작성</a>
</body>
</html>



