## Time CM project
### 프로젝트 설명
- CMDummyEvent를 사용하여 간단한 Time 클라이언트와 서버를 구현한다.
- 클라이언트는 서버로 현재 시간 정보를 요청하는 CMDummyEvent를 전송한다.
- 서버는 요청을 받으면 현재 날짜와 시간 정보를 CMDummyEvent로 클라이언트한테 전송한다.
- 클라이언트는 서버로부터 받은 현재 날짜와 시간 정보를 화면에 출력한다.

### 프로젝트 세부 설명
- 기존 CM Project의 라이브러리를 사용하되 클라이언트와 서버 코드, 각각에 해당하는 핸들러는 새로 작성하였다.
- __TimeClient.java__
  - 서버에 로그인할 때에는 사용자로부터 입력받지 않고 코드 상에서 지정한 아이디와 비밀번호로 로그인하도록 구현했다.
  - 사용자로부터 "time"이라는 단어를 입력받으면 더미이벤트를 만들어 서버로 전송되도록 한다.
- __ServerHandler.java__
  - 클라이언트로부터 받은 더미이벤트의 내용이 "time"인 경우 시간 데이터를 만든다.
  - 만든 시간 데이터를 더미이벤트 내용에 담아 클라이언트로 다시 보낸다.

### 실행 화면
- Client

![image](https://user-images.githubusercontent.com/39904216/90329413-b1170b80-dfdf-11ea-84ae-6d0a6592b6be.png)

- Server

![image](https://user-images.githubusercontent.com/39904216/90329416-b70cec80-dfdf-11ea-99a8-7070307e40f2.png)
