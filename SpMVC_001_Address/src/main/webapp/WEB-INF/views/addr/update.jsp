<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="POST" class="main update">
	<fieldset>
		<legend>주소 변경</legend>
		<div>
		
		<label>ID</label>
		<input name="a_id" value="${ADDR.a_id}" readonly="readonly"/>
		
		</div>
		<div class="message a_id">
			<label></label><span></span>
		</div>
		
		<div><label>이름</label>
		<input name="a_name" value="${ADDR.a_name}"/></div>
		<div class="message a_name">
			<label></label><span></span>
		</div>
		
		<div><label>전화번호</label>
		<input name="a_tel" value="${ADDR.a_tel}"/></div>
		<div class="message a_tel">
			<label></label><span></span>
		</div>
		
		<div><label>주소</label>
		<input name="a_addr" value="${ADDR.a_addr}"/></div>
		<div class="message a_id">
			<label></label><span></span>
		</div>
		
		<div><label></label>
			<button class="button list" type="button">리스트로</button>
			<button class="button input" type="button">수정하기</button>
		</div>
	</fieldset>
</form>

