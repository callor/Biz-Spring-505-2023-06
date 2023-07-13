# Spring Project 의 Servlet
- 현재 Project 에서 사용하는 WAS(Web Application Server) 는 Tomcat 9이다
- Tomcat 버전이 9.x 까지는 하위 호환을 유지하고 있어서 버전에 따른 문제가 거의 없었다
- Tomcat 버전이 10.x 가 되면서 내부 스팩이 완전히 변경된다.
- Tomcat 9.x JavaEE 스펙이었는데, Tomcat 10.x JakartaEE 스펙으로 변경되었다.
- Project 에서 사용하는 Tomcat 은 9.x 버전이지만, 이 버전은 하위 호환이 되기 때문에 Servlet version 과 크게 상관없이 작동된다.
- 단 Tomcat 10.x 을 사용하려면 Project 를 상당히 많이 변경해야 하고, 변경하는 과정에서 여러 문제를 일으킬수 있다.

## 입력 form 만들기 주의사항
- 입력화면은 반드시 form 으로 감싸고 있어야 한다.
- 특별한 경우가 아니면 method는 POST 로 지정한다.
- action 은 서버로 데이터를 보낼때 사용할 URL(URI) 이다
- 만약 action 을 생략하면, 입력화면을 보여줄때 사용한 URI가 자동으로 설정된다
- form 으로 감싼 button 은 자동으로 submit event 가 설정된다. submit : 입력화면에서 입력한 데이터를 서버로 전송하는 event 이다.

