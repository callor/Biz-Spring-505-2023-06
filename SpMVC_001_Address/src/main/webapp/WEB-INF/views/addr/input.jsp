<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="POST" class="main input">
	<fieldset>
		<legend>주소 추가</legend>
		<div><label>ID</label><input name="a_id"/></div>
		<div class="message a_id">
			<label></label><span></span>
		</div>
		<div><label>이름</label><input name="a_name"/></div>
		<div><label>전화번호</label><input name="a_tel"/></div>
		<div><label>주소</label><input name="a_addr"/></div>
		<div><label></label>
			<button class="button list" type="button">리스트로</button>
			<button class="button input" type="button">추가하기</button>
		</div>
	</fieldset>
</form>

