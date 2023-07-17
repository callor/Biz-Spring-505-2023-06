# 다중 Table구조의 DB 프로젝트에서 PK 의 생성
- 여러개의 Table 이 서로 연동되는 프로젝트에서 1:N 의 관계인 Table 에 데이터를 Insert 할때 주 Table(1의 Table)의 PK 값을 부 테이블(N의 Table)의 칼럼에 포함하여 insert 를 해야하는 경우가 많다.
- 테이블 JOIN  하여 조회를 할 때 PK와 FK 칼럼을 서로 묶어야 하기 때문에 INSERT 를 할때 PK 값을 참조해야 한다.
1. 주 Table 에 INSERT 를 수행한다음, 주 Table 의 PK 값을 사용하여 부 Table 에 데이터를 추가하해야 한다.

2. 주 Table 의 INSERT mapper 에 `userGeneratedKeys="true"`속성과 `keyProperty="PK"` 속성을 추가 해 주어야 한다
3. INSERT 가 수행된 후 Service 코드에서 새로 추가된 PK 값을 참조할수 있다
```xml
<insert id="insert" useGeneratedKeys="true" keyProperty="b_seq">
	<selectKey databaseId="mysql" order="AFTER"
		keyColumn="b_seq" keyProperty="b_seq">
	</selectKey>		
</insert>

```

- oracle DB 에서는 AUTO INCREMENT 를 사용하지 않고 SEQUENCE를 사용하기 때문에, 먼저 SEQUENCE 를 사용하여 새로운 키를 만들고(SEQ_BBS.NEXTVAL) 그 키값을 PK 칼럼(b_seq)에 세팅하는 절차가 필요하다.
- `order="BEFORE"` : INSERT 를 실행하기 전에 먼저(BEFORE)키를 만들어라

```xml
<selectKey databaseId="oracle" order="BEFORE" 
		keyColumn="b_seq" keyProperty="b_seq" >
	SELECT SEQ_BBS.NEXTVAL FROM DUAL
</selectKey>
```





