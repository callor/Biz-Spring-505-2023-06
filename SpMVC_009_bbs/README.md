# Spring MVC + Spring Security 프로젝트
* 이 프로젝트에서는 dependencies 의 version 관리를 BOM(Bill of Materials)를 사용하여 dependenciesManagement를 통해서 실행한다.

- pom.xml 에 다음 항목을 설정한다
```xml
<dependencyManagement>
	<dependencies>
	
	</dependencies>
</dependencyManagement>
```
- Management 항목에 Spring Framework BOM 과 Spring Security BOM 을 추가한다
- 완성된 Management
```xml
<dependencyManagement>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-framework-bom -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-framework-bom</artifactId>
			<version>${org.springframework-version}</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-bom -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-bom</artifactId>
			<version>5.3.13.RELEASE</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
```	