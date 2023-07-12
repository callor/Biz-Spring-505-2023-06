# Spring Server Application File Upload
- HTML 에서 파일을 선택하여 Server 로 업로드를 할때, form 에서 POST 방식으로 업로드를 한다
- 원래 form 에서 Server 로 보내는 데이터는 Text 데이터이다. 이 Text Data 는 http 프로토콜의 body(payload)에 담겨서 encoding 이 되어 전송된다.
- form 에서 `type="file"` 형식의 input tag를 이용하여 BIN 파일을 업로드 하면 데이터가 body 담기고 encoding 이 되는데 이 과정에서 BIN 파일이 깨져버린다.
- 그래서 HTML 에서는 form 의 전송되는 데이터에 새로운 규격을 추가했다 Text type 의 데이터와 None Text type 데이터를 같이 묶음으로 하여 Server 로 전송할수 있도록 form 에 속성을 추가하였다
- form 에 `type="file"` 속성이 있는 input tag 가 있으면 form tag 에 `enctype="multipart/form-data"` 라는 속성을 첨가해야 한다.
- form `enctype="multipart/form-data"` 라는 속성이 첨가되어 있으면 HTML 데이터를 전송하는 http 프로토콜이 종전의 form 데이터를 전송하는 방법과 달리 작동한다.
- form 의 `enctype="multipart/form-data"`는 Text 데이터와 None Text 데이터를 하나의 프로토콜 payload 에 묶어서 보내는 Html 의 규격이

## Spring Controller 에서 multipart/form-data 받기
- Spring Controller는 form 에서 전달되는 모든 데이터를 Text 로만 인식한다.
- form 에서 아무리 `multipart/form-data` 형식으로 데이터를 보내도 Spring Controller 에서는 그러한 데이터를 수신(인식)하지 못한다
- Spring Project 에서 파일 업로드 기능을 구현하기 위해서는 다음의 2가지 Dependecies 를 설치해야 한다.

```xml
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.13.0</version>
</dependency>
```