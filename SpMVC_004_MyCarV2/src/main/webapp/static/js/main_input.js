document.addEventListener("DOMContentLoaded", () => {
  const input_carnum = document.querySelector("#c_carnum");
  const input_sdate = document.querySelector("#c_sdate");
  const input_stime = document.querySelector("#c_stime");
  const input_qty = document.querySelector("#c_qty");
  const input_skm = document.querySelector("#c_skm");

  const err_carnum = document.querySelector("div.error.c_carnum");
  const err_qty = document.querySelector("div.error.c_qty");
  const err_sdate = document.querySelector("div.error.c_sdate");
  const err_stime = document.querySelector("div.error.c_stime");
  const err_skm = document.querySelector("div.error.c_skm");

  // input box 에 focus() 를 설정하고 입력된 Text 가 있으면
  // Text 전체를 블럭으로 설정하라
  input_carnum.select();

  input_carnum?.addEventListener("blur", (e) => {
    err_message(err_carnum, e.target, "* 차량번호를 입력하세요");
  });
});
