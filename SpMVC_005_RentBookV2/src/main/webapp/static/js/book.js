document.addEventListener("DOMContentLoaded", () => {
  const input_bname = document.querySelector("input#b_name");
  const input_bcode = document.querySelector("input#rent_bcode");
  const input_bcomp = document.querySelector("input#b_comp");
  const result_list = document.querySelector("div.search.list");

  const result_listClickHandler = (e) => {
    const book_item = e.target;
    if (book_item.tagName !== "DIV") {
      return false;
    }
    input_bcode.value = book_item.dataset.bcode;
    input_bcomp.value = book_item.dataset.bcomp;
    input_bname.value = book_item.dataset.bname;
    result_list.style.display = "none";
  };
  result_list?.addEventListener("click", result_listClickHandler);

  const bnameSearch = async (e) => {
    const bname = e.target.value;

    // 입력된 글자가 2개 미만이면 반응 하지 말라
    if (bname.length < 2) {
      result_list.style.display = "none";
      return false;
    }
    result_list.style.display = "block";
    // ?변수=값 으로 보내는 데이터 : queryString 방식의 요청
    const url = `${rootPath}/book/name/search?b_name=${bname}`;
    const response = await fetch(url);
    const result = await response.json();

    // 결과 list clear
    result_list.innerHTML = "";
    // result 배열(List) 전체를 반복 순회 하면서
    // 각각의 요소를 book 에 담아 내부의 함수로 전달하라
    result.forEach((book) => {
      console.table(book);

      // div tag 를 새로 생성하기
      const book_item = document.createElement("div");
      // 새로 생성된 div 의 innerHTML 속성을 통하여 문자열 보이기
      const text = `${book.b_name} : ${book.b_comp} : ${book.b_auther}`;

      book_item.innerHTML = text.replaceAll(
        `${bname}`,
        `<span class="search-item">${bname}</span>`
      );

      // 도서코드, 도서명, 출판사를 div 에 dataset 으로 추가하기
      // data-bcode=${book.b_code}
      book_item.dataset.bcode = book.b_code;

      book_item.dataset.bname = book.b_name;

      // data-bcomp=${book.b_comp}
      book_item.dataset.bcomp = book.b_comp;

      // result_list 의 child 로 추가하기
      result_list.appendChild(book_item);
    });
  };
  /*
  키보드 관련 event
  keydown : 키가 눌리는 순간
        Enter, Esc 등 특수키값을 Capture 할수 있다
  keypress : keydown 거의 유사
  keyup : 키보드에서 손이 떼어지는 순간 
        숫자, 영문자 등 키보드에 표시된 문자들 Capture

  */
  input_bname?.addEventListener(
    "keyup",
    debounce((e) => {
      bnameSearch(e);
    })
  );
});
