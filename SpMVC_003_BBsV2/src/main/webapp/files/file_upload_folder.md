# Server 의 file Upload 폴더
- 프로젝트의 `webapp` 폴더 아래에 `files` 폴더를 생성했다.
- 생성된 폴더는 `webapp/files` 가 된다.
- 프로젝트 소스에서는 이 폴더에 임의의 파일을 하나 저장해 둔다.
- file Upload 에서 ResourceLoader 를 사용하여 이 폴더의 정보를 추출하고, `file.transferTO()` method 를 사용하여 이 폴더에 파일을 저장한다.
- 그러나, 프로젝트 소스에서는 이 폴더에 업로드된 파일을 확인할수 없다
- 서버가 실행되는 동안 `Tomcat`의 서버 폴더에 이 폴더가 생성되고,  그 폴더에 파일이 저장되기 때문에 소스코드에서는 확인 안되는 것이다

- 여기를 `Server Resource` 폴더라고 부른다
- `Server Resource` 폴더는 프로젝트를 clean 하거나 프로젝트를 서버에 배포(Deploy, publisher)하게 되면 모두 초기화 된다.
- 따라서 업로드된 파일들도 모두  삭제 되어 버린다.
- 업로드한 파일을 프로젝트가 진행되는 동안에 삭제가 되어 버린다.
- 실제 업로드한 파일을 client 가 볼수 있게 하려면 `servlet-context.xml` 의 `<resources mapping="/files/**" location="/files/" />` 항목에 해당 폴더정보를 등록해 주어야 한다.
- 이미지 일 경우 client web html 에서는 img tag 를 사용하여 해당 파일을 web 에 표현할수 있다.
- `<img src=/서버/files/filename.jpg` 처럼 표현







