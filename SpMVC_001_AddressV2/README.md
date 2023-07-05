# Component
- Spring MVC 프로젝트에서는 class 에 다양한 Annotation 을 부착할 수 있다.
- @Controller, @Service, @Component 등의 Annotation 을 클래스에 부착하고 이러한 Annotation 이 부착된 클래스를 `컴포넌트` 라고 부른다
- 분리된 구조적 모듈로 표현할수 있다.
- Spring MVC 프로젝트는 여러가지 다양한 Component 들이 모여서 서로 협력하며 프로젝트를 실행한다

## component-scan
- Spring MVC 프로젝트가 `Run on Server(서버에의해 실행되면)` Component Annotation 이 부착된 class 들은 자동으로 객체로 생성되고 Spring, Tomcat `Container` 에 보관된다.
- `Container`에 보관된 `Component`들은 필요한 경우 자동으로 서로 Wirering 된다
- Spring MVC 프로젝트의 `servlet-contentext.xml`파일을 확인해 보면 `component-scan` 이라는 항목이 있다
- 프로젝트가 시작되면 `servlet-contentext.xml`의 `component-scan` 항목에 설정된 대로 프로젝트의 class 들을 모두 scan 하고 Annotation 이 부착된 class를 만나면 Component 로 만들어서 Container 에 보관한다


## css, js 파일의 수정후 반영 안되는 문제
- Tomcat Server 를 Start 할때, JSP, class 파일은 자동으로 변경되는 것을 감지하고 변경된 파일을 서버에 업로드(publisher)하여 새로고침을 하면 내용을 반영한다
- 하지만 link 된 css 나 script src="" 로 설정된 js 파일은 간혹 변경된 것을 감지하지 못하고, 아무리 파일을 변경해도 반영이 안되는 경우가 자주 있다.
- 이럴때는 파일 이름에 의미없는 값을 부착하고(`?20230628-001`) 서버를 재시작한다
- 만약 파일을 변경 한 후 내용이 반영되지 않으면 값을 다른 값으로 변경해 주고 서버를 재 시작해 준다. 




