document.addEventListener("DOMContentLoaded", () => {
  const main_nav = document.querySelector("nav.main");
  const navClickHandler = (e) => {
    const nav_item = e.target;
    if (nav_item.tagName === "LI") {
      const nav_class = nav_item.className;
      if (nav_class === "home") {
        document.location.href = `${rootPath}/`;
      } else if (nav_class === "login") {
        document.location.href = `${rootPath}/user/login`;
      } else if (nav_class === "join") {
        document.location.href = `${rootPath}/user/join`;
      } else if (nav_class === "logout") {
        document.location.href = `${rootPath}/user/logout`;
      } else if (nav_class === "mypage") {
        document.location.href = `${rootPath}/user/mypage`;
      } else if (nav_class === "admin") {
        document.location.href = `${rootPath}/admin`;
      }
    }
  };
  main_nav?.addEventListener("click", navClickHandler);
});
