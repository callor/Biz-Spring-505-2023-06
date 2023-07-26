document.addEventListener("DOMContentLoaded", () => {
  const result_list = document.querySelector("div.search.list");

  const input_mname = document.querySelector("input#m_name");
  const input_mcode = document.querySelector("input#rent_mcode");
  const input_mtel = document.querySelector("input#m_tel");

  const mNameSeach = async (e) => {
    const mName = e.target.value;

    if (mName.length < 1) {
      result_list.style.display = "none";
      return false;
    }
    const url = `${rootPath}/member/name/search?m_name=${mName}`;

    try {
      const res = await fetch(url);
      const result = await res.json();

      result_list.innerHTML = "";
      result_list.style.display = "block";

      result.forEach((member) => {
        const mem_div = document.createElement("div");
        const text = `${member.m_name}, ${member.m_tel}`;

        mem_div.innerHTML = text.replaceAll(
          `${mName}`,
          `<span class="search-item">${mName}</span>`
        );
        mem_div.dataset.mName = member.m_name;
        mem_div.dataset.mCode = member.m_code;
        mem_div.dataset.mTel = member.m_tel;
        result_list.appendChild(mem_div);
      });
    } catch (error) {
      console.log("서버 오류");
    }
  };

  input_mname.addEventListener(
    "keyup",
    debounce((e) => {
      mNameSeach(e);
    })
  );

  const memberItemClickHandler = (e) => {
    const mem_item = e.target;
    if (mem_item.tagName !== "DIV") {
      return false;
    }
    input_mcode.value = mem_item.dataset.mCode;
    input_mname.value = mem_item.dataset.mName;
    input_mtel.value = mem_item.dataset.mTel;
    result_list.style.display = "none";
  };
  result_list.addEventListener("click", memberItemClickHandler);
});
