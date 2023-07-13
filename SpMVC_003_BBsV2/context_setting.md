# context setting
- Spring Project 에서는 2가지 영역(scope)의 context 가 있다. `root-context` 라고 일반적으로 부르는 `context-param` 설정과 `servlet-context` 라고 부르는 설정이 있다.

## root-context(`/WEB-INF/spring/root-context.xml` 파일)
- `web.xml`의 `context-param` 에 설정된 `context.xml` 의 내용부분이다.
- 이 context 에 설정된 내용들은 Tomcat 에서 Project 로 Request 가 전달될때 여러가지 설정된 항목들이 적용되어 Project 전반에 전역적으로(global public)으로 사용되는 항목들이다.

## servlet-context(`/WEB-INF/spring/appServlet/*-context.xml` 파일)
- Dispatcher Servlet 이 실행되면서 개발자가 만든 Controller, Service, Dao 등에서 사용하든 항목이다.

C:\Users\callor\Documents\workspace\springMVC\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpMVC_003_BBsV2\files\image_1.jpg