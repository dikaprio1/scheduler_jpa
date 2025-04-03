# 스케줄러 프로그램 (Scheduler JPA)

## 1. 프로젝트 개요
이 프로젝트는 Spring Boot와 JPA를 기반으로 하는 스케줄러 프로그램입니다. 
사용자가 할 일을 등록하고 삭제하고 수정하도록 지원합니다.

## 2. 주요 기능
- 작업 예약 (스케줄 등록/수정/삭제)
- 실행 로그 기록

## 3. 프로젝트 구조
```
src/
├── main/
│   ├── java/com/example/scheduler_jpa/
│   │   ├── auth/          # 로그인 인증/인가 패키지
│   │   ├── config/        # 로그인 필터
│   │   ├── filter/        # 로그인 필터
│   │   ├── schedules/     # 스케줄 crud 패키지
│   │   ├── user/          # 유저 crud 패키지
│   │   ├── SchedulerApplication.java  # 메인 애플리케이션 실행 파일
│   ├── resources/
│   │   ├── application.properties  # 환경설정 파일
│   │   ├── data.sql  # 초기 데이터
└── test/  # 테스트 코드
```

## 4. 개별 환경 설정
- `application.properties` 파일을 수정하여 데이터베이스 및 애플리케이션 환경을 설정할 수 있습니다.

## 5. 요구 사항
- **Java 17+**
- **Gradle 7+**
- **Spring Boot 3+**
- **데이터베이스 MySQL**

## 6. 코드 구조
### 6.1 주요 클래스
- **SchedulerApplication.java**: Spring Boot 애플리케이션 실행 진입점
- **ScheduleService.java**: 스케줄 등록을하는 서비스 클래스
- **ScheduleController.java**: REST API를 제공하는 컨트롤러
- **ScheduleRepository.java**: JPA 기반의 데이터 액세스 레이어
- **Schedule.java**: 스케줄 작업을 저장하는 JPA 엔티티
- **UserService.java**: 유저 등록을하는 서비스 클래스
- **UserController.java**: REST API를 제공하는 컨트롤러
- **UserRepository.java**: JPA 기반의 데이터 액세스 레이어
- **User.java**: 유저을 저장하는 JPA 엔티티

## 7. 데이터베이스 설정
- `src/main/resources/application.properties`에서 데이터베이스 설정을 변경할 수 있습니다.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/scheduler
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

## 8. 기여 방법
1. 이슈를 확인하고 작업할 항목을 선택하세요.
2. 새로운 브랜치를 생성하여 개발을 진행하세요.
3. 변경사항을 커밋하고 PR을 생성하세요.

## 9. ERD
![스케줄러 ERD.PNG](%EC%8A%A4%EC%BC%80%EC%A4%84%EB%9F%AC%20ERD.PNG)


## 10. API 명세서
https://documenter.getpostman.com/view/43316803/2sB2cSfiSe