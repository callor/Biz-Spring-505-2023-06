document.addEventListener("DOMContentLoaded", () => {
  const inputs = document.querySelectorAll("form.main input");
  inputs[INPUT_INDEX.C_CARNUM].addEventListener("blur", (e) => {
    const value = e.target.value;
    if (!value) {
      const error_carnum = document.querySelector(
        "div.error.c_carnum"
      );
      error_carnum.classList.add("on");
      error_carnum.innerHTML = "* 차량번호는 반드시 입력하세요";
      e.target.focus();
      return false;
    }
  });
  const qty_input = document.querySelector("input[name='c_qty']");
  qty_input?.addEventListener("blur", (e) => {
    const value = e.target.value;
    if (!value) {
      const error_qty = document.querySelector("div.error.c_qty");
      error_qty.classList.add("on");
      error_qty.innerHTML = "* 업무구분은 반드시 입력해야 합니다";
      e.target.focus();
      return false;
    }
  });
});
