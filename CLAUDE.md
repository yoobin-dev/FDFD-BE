## 프로젝트
프다프다(FDFD) — 프리다이빙 강습 예약 앱 백엔드
Spring Boot + JPA + MyBatis + MariaDB

## 기술스택
- Spring Boot
- JPA (단순 CRUD)
- MyBatis (복잡한 조인/동적 쿼리)
- MariaDB

## 명령어
- `./gradlew bootRun` : 개발 서버 실행
- `./gradlew build` : 빌드
- `./gradlew test` : 테스트

## DB 테이블 목록
- TBL_USER : 회원 기본 정보
- TBL_USER_CORP : 회원-업체 매핑 (MAIN_YN으로 주업체 구분)
- TBL_CORP : 업체 정보
- TBL_INSTRUCTOR : 강사 계정
- TBL_USER_INST : 수강생↔강사 매핑
- TBL_CLASS : 연습반 일정
- TBL_USER_CLASS : 수강생 연습반 신청
- TBL_CLASS_ITEM : 연습반 대여 품목
- TBL_USER_RENTAL : 수강생 대여 내역
- TBL_USER_INFO : PB 기록
- TBL_LICENSE : 자격증 정보
- TBL_DIVINGLOG : 다이빙 로그
- TBL_CODE : 공통 코드

## 폴더구조
src/main/java/com/fdfd/
├── domain/
│   ├── auth/          # 로그인, 회원가입
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── mapper/
│   │   └── dto/
│   ├── user/          # 회원 정보, PB, 자격증
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── mapper/
│   │   └── dto/
│   ├── company/       # 업체, 강사
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── mapper/
│   │   └── dto/
│   ├── schedule/      # 연습반 일정, 신청, 취소
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── mapper/
│   │   └── dto/
│   ├── log/           # 다이빙 로그
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── mapper/
│   │   └── dto/
│   └── rental/        # 대여 품목
│       ├── controller/
│       ├── service/
│       ├── repository/
│       ├── mapper/
│       └── dto/
└── global/
    ├── config/        # Security, DB 설정
    ├── exception/     # 공통 예외처리
    ├── response/      # ApiResponse<T> 래퍼
    └── util/

## ORM 사용 기준
- JPA : 단순 CRUD, 단일 테이블 조회
- MyBatis : 복잡한 조인 쿼리, 동적 쿼리

## API 설계 참고
- 홈 화면은 summary API 하나로 (일정+PB+자격증 한번에)
- 연습반 취소 시: STATUS 변경 + 알림 발송 + 정원 자동 복구
- 공통 응답 형식: ApiResponse<T> 래퍼 사용
- REST API URL 소문자 + 하이픈

## 역할 구분
- 수강생: 일정 신청/취소, 자격증/PB 등록, 업체 가입 신청
- 강사: 연습반 운영 (별도 앱)
- 업체 대표: 강사 계정 생성, 수강생 승인 (웹 어드민)