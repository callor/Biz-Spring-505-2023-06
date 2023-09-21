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
