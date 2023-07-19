const ERROR_MESSAGE = {
  CARNUM: "* 차량번호를 입력하세요",
  QTY: "* 업무명을 입력하세요",
  USERNAME: "* 사용자명을 입력하세요",
  SDATE: "* 시작일자를 입력하세요",
  STIME: "* 시작시간을 입력하세요",
  SKM: "* 출발 Km 를 입력하세요",
};

document.addEventListener("DOMContentLoaded", () => {
  const input_carnum = document.querySelector("#c_carnum");
  const input_qty = document.querySelector("#c_qty");
  const input_username = document.querySelector("#c_username");
  const input_sdate = document.querySelector("#c_sdate");
  const input_stime = document.querySelector("#c_stime");
  const input_skm = document.querySelector("#c_skm");

  const btn_save = document.querySelector("#btn_save");

  const err_box_list = document.querySelectorAll("div.error");
  const err_carnum = document.querySelector("div.error.c_carnum");
  const err_qty = document.querySelector("div.error.c_qty");
  const err_username = document.querySelector("div.error.c_username");

  const err_sdate = document.querySelector("div.error.c_sdate");
  const err_stime = document.querySelector("div.error.c_stime");
  const err_skm = document.querySelector("div.error.c_skm");

  const err_clear = () => {
    for (let box of err_box_list) {
      box?.classList.remove("on");
    }
  };

  // input box 에 focus() 를 설정하고 입력된 Text 가 있으면
  // Text 전체를 블럭으로 설정하라
  input_carnum.select();
  input_carnum?.addEventListener("blur", async () => {
    err_clear();
    // 값이 있는지 검사
    if (
      !err_message(input_carnum, err_carnum, ERROR_MESSAGE.CARNUM)
    ) {
      return false;
    }

    // 차량번호 서버에 조회요청
    const carnum = input_carnum.value;
    const res = await fetch(`${rootPath}/car_check?carnum=${carnum}`);
    const json = await res.json();
    if (json.c_carnum === "NOT") {
      err_carnum.classList.add("on");
      err_carnum.innerHTML = "* 한번도 사용하지 않은 차량번호 입니다";
      input_skm.value = "";
    } else {
      input_skm.value = json.c_ekm;
    }
  });

  input_qty?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_qty, err_qty, ERROR_MESSAGE.QTY)) {
      return false;
    }
  });

  input_username?.addEventListener("blur", () => {
    err_clear();
    if (
      !err_message(
        input_username,
        err_username,
        ERROR_MESSAGE.USERNAME
      )
    ) {
      return false;
    }
  });

  input_sdate?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_sdate, err_sdate, ERROR_MESSAGE.SDATE)) {
      return false;
    }
  });
  input_stime?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_stime, err_stime, ERROR_MESSAGE.STIME)) {
      return false;
    }
  });

  btn_save.addEventListener("click", () => {
    err_clear();
    if (
      err_message(input_carnum, err_carnum, ERROR_MESSAGE.CARNUM) &&
      err_message(input_qty, err_qty, ERROR_MESSAGE.QTY) &&
      err_message(
        input_username,
        err_username,
        ERROR_MESSAGE.USERNAME
      ) &&
      err_message(input_sdate, err_sdate, ERROR_MESSAGE.SDATE) &&
      err_message(input_stime, err_stime, ERROR_MESSAGE.STIME)
    ) {
      document.querySelector("form.main").submit();
    }
    return false;
  });
});
