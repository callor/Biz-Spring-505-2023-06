<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<article class="detail data">
	<div>
		<strong>ID</strong><span>${ADDR.a_id}</span>
	</div>
	<div>
		<strong>이름</strong><span>${ADDR.a_name}</span>
	</div>
	<div>
		<strong>전화번호</strong><span>${ADDR.a_tel}</span>
	</div>
	<div>
		<strong>주소</strong><span>${ADDR.a_addr}</span>
	</div>
</article>
<article class="detail button">
	<div>
		<button class="detail list">리스트로</button>
		<button class="detail update" data-id="${ADDR.a_id}">수정</button>
		<button class="detail delete" data-id="${ADDR.a_id}">삭제</button>
	</div>
</article>






