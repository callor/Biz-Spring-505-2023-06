// HTML DOM 기반의 JS 코드 시작점
document.addEventListener("DOMContentLoaded", () => {
  // DOM 객체(tag 객체)
  const addr_input = document.querySelector("form.input");
  const btn_input = document.querySelector("button.input");
  const btn_list = document.querySelector("button.list");

  // inline 익명(무명) 함수로 click event 설정
  btn_list?.addEventListener("click", (e) => {
    // alert("리스트 버튼 클릭");
    // 현재 화면에 보여줄 페이지 요청하기
    document.location.href = `${rootPath}`;
  });

  // event call 함수를 선언하고
  const inputButtonClickHandler = (e) => {
    // alert("추가 버튼 클릭");
    // JS 코드에서 form 에 포함된 button 을 클릭했을때
    // Server 로 데이터를 전송하라
    addr_input?.submit();
  };
  // 선언된 event call 함수를 사용하여 click evetn 선언
  btn_input?.addEventListener("click", inputButtonClickHandler);
});
