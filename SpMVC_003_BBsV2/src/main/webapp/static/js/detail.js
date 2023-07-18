document.addEventListener("DOMContentLoaded", () => {
  const image_box = document.querySelector("div.image_list");

  const image_delete = (e) => {
    const btn_delete = e.target;
    if (btn_delete.tagName === "SPAN") {
      const seq = e.target.dataset.seq;
      if (confirm(`${seq} 사진을 삭제할까요?`)) {
        document.location.href = `${rootPath}/image_delete?seq=${seq}`;
      }
    }
  };
  image_box.addEventListener("click", image_delete);
  // JS 코드 변경하기
  alert("Hello");
});
