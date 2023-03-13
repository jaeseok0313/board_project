1.프로젝트 구성
프로젝트 목표: crud가능한 게시판
개발인원:2명
개발기간::2~3월
구현 기능
게시판:crud, 조회수,페이징처리, 검색기능, 글 추천, 첨부파일 다운로드 및 등록
사용자:spring security 로그인,회원정보 수정, 사용자 권한정보
댓글: crud기능,ajax를 이용한 비동기 형식
rest api: 유저정보,게시판 crud
개발 언어: java 8
개발환경: spring boot 2.7.8, maven, mybatis, spring security ,aws ec2
데이터베이스: oracle db
형상관리 :git
 2. 요구사항
1.회원가입 페이지

유효성검사
전화번호는 숫자만 입력가능
비밀번호는 8~20사이의 문자와 숫자 특수문자를 최소 1개는 가지고 있어야하며 조건을 만족하지못하면 조건을 설명하는 메시지를 띄움
중복 검사
데이터베이스에 존재하는 중복되는 아이디가 있으면 버튼 완료버튼 비활성화 및 ‘아이디가 중복됩니다’ 라는 팝업 띄워주기 
모든 조건을 만족하면 홈으로 복귀

2.메인 페이지
-로그인을 하지 않은경우
-회원가입 페이지
-게시글 목록 조회 페이지
-게시글 상세보기 페이지
-게시글 검색 기능
-그 외 경로는 선택시 로그인 페이지로 이동 또는 선택지 숨김처리
로그인 검사
-아이디와 비밀번호 정보 확인
-검사 통과시 기본 페이지로 이동


 3.회원정보 수정
-회원정보 수정(아이디,이름,이메일,주소) 
-중복 아이디 체크 가능
-비밀번호 수정시 현재 비밀번호 검사
4.게시글
-게시글 작성시 공백 내용 검사
-내가 작성한 게시글만 수정 삭제 가능
-로그인하지 않으면 게시글 작성버튼 누를시 팝업 생성
-이미 추천한 글에는 추천 불가능
5.댓글
-로그인한 사용자만 댓글 작성 가능
-등록된 댓글은 해당 댓글 작성자만 수정 삭제 가능
-게시글 삭제시 댓글 데이터도 같이 삭제
-로그인하지 않으면 팝업 생성
6.권한
-권한별 사용페이지 분리(권한신청,권한관리)
-권한 신청 페이지를 통해 권한신청

7.REST API
-유저 가입 수정 삭제 조회  가능 
-게시판의 작성 수정 삭제 조회 가능 
-rest api는 권한을 가진 사용자만 가능
-유저 api게시판 api
 3. DB설계

유저관리 테이블

게시판 정보 테이블

게시판 추천 테이블


파일관리 테이블

댓글 테이블

권한관리 테이블



구현 코드:https://github.com/jaeseok0313/board_project

