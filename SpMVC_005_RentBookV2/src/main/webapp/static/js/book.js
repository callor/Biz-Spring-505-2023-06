const debounce = (cback, timeout = 300) => {
  let timer;
  return (...args) => {
    clearTimeout(timer);
    timer = setTimeout(() => {
      cback();
    }, timeout);
  };
};

document.addEventListener("DOMContentLoaded", () => {
  const input_bname = document.querySelector("input#b_name");
  const div_search_list = document.querySelector("div.search.list");

  const bnameSearch = (e) => {
    const bname = e.target.value;

    // 입력된 글자가 2개 미만이면 반응 하지 말라
    if (bname.length < 2) {
      div_search_list.style.display = "none";
      return false;
    }
    div_search_list.style.display = "block";
    // ?변수=값 으로 보내는 데이터 : queryString 방식의 요청
    const url = `${rootPath}/book/name/search?b_name=${bname}`;
    fetch(url);
  };
  /*
  키보드 관련 event
  keydown : 키가 눌리는 순간
        Enter, Esc 등 특수키값을 Capture 할수 있다
  keypress : keydown 거의 유사
  keyup : 키보드에서 손이 떼어지는 순간 
        숫자, 영문자 등 키보드에 표시된 문자들 Capture

  */
  input_bname?.addEventListener("keyup", bnameSearch);
});
