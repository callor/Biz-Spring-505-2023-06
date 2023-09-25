# SpringMVC + Spring Security 프로젝트
- SpringMVC 프로젝트에 Spring Security 를 적용하여 보안 서버 프로젝트 구현하기
- 로그인 관련하여 상당부분의 기능을 Security 가 담당하여 대신 처리 해 준다.
- pom.xml 에 SpringSecurity Dependencies 등록
```xml
<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-core</artifactId>
	<version>${org.springsecurity-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-web</artifactId>
	<version>${org.springsecurity-version}</version>
</dependency>
```		

## Spring Security 에서 login 수행하기
- 기본적으로 Spring Security 에서는 security-context.xml 에 지정된 intercept-url 에 따라 로그인이 되어있는가를 검사한다
- 만약 intercept-url에 설정된 항목중에 로그인이 필요한 URL 이 있으면, login 정보를 검사하고, 만약 로그인이 되어 있지 않으면 자체 지원하는 login화면을 보여준다
- 자체적으로 security 에서 지원하는 login 화면이 아닌 custom login 화면을 만들수 있다.
- security-context.xml 파일의 다음 항목에 `login-page` 에 custom login 화면을 여는 URL 을 설정해 놓으면, 자체 login 화면이 아닌 사용자정의(custom) login 화면을 보여줄수 있다
- userController 에 해당 URL 을 처리하는 method 를 만들어 두면 접근자에게 사용자정의 login 화면을 보여줄수 있다.
- 또한 `login-processing-url` 을 login-page URL 과 같이 만들어 둠으로써, login 화면에서 action 을 사용하지 않아도 된다
- 실제로 프로젝트에서 `POST: /user/login` 은 존재하지 않지만, 이 URL 은 Spring Security 가 자체적으로 캡춰하여 처리한다.
```xml
<sec:form-login 
		username-parameter="username"
		password-parameter="password" 
		login-page="/user/login"
		login-processing-url="/user/login"
/>

```

## login 한 사용자에게 권한 부여하기
- Spring Security 에서는 로그인과 함께 권한을 검사하는 기능이 포함되어 있다.
- login 한 사용자의 Token 을 발행할때 `ROLE_권한` 을 포함하여
특정한 URL 에 대하여 권한을 검사할수 있다. 권한이 부여되지 않은 URL 에 사용자가 접근을 시도하면 `403 FORBIDDEN` 오류를 발생한다
- Security를 사용하면 특정한 URL 에 권한을 세밀하게 부여하여 Login 한 사용자 별로 화면을 보여줄수 있다.


## DB 연결정보 암호화 하기
- DataSource 에 설정된 username 과 password 는 github 등에 프로젝트가 업로드 되면, 외부에 노출이 되고,  외부에 노출이 되면 보안에 치명적인 문제를 일으킬수 있다.
- dataSource 정보를 github 에 업로드 되지 않도록 .gitignore 에 등록하면될 것이다.
- Spring security 프로젝트에서는 username 과 password 를 암호화 하여 사용한다.