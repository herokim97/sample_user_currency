# 제목 : 환전 요청 프로그램

### Description 
 - 한국 원을 기준으로 특정 통화 환전이 가능한 프로그램
 - 사용기술
    1) Restful API
    2) jpql
    3) GlobalExceptionHandler
 - 추가적으로 로그인 기능과 해당 사용자의 계좌 테이블을 추가하여, 잔고를 관리하는 부분을 구현 목표.

### Install Process
**- build.gradle**
  1) JavaLanguageVersion = 17
  2) dependecies
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.mysql:mysql-connector-j'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
**- application.properties**
  1) hibernate, mySQL 설정 진행.
  2) CurrencyUserApplication - 실행

### Use Process - 형식 : .json
  1) 요청 사용자 생성(id, name, email)
  2) 환율 테이블 통화 등록(currencyName, exchangeRate, symbol)
  3) 환전 요청(userId, amountInKrw, toCurrencyId)
  4) 특정 사용자 환전 건수 조회(/exchanges?userId={userId})
  5) 특정 환전 건 상태 값 변경(status : "cancle")
  6) 사용자 삭제(users/{userId})
  7) 특정 사용자 환전 요청 건수 조회(/exchanges/count?userId={userId})

### 프로젝트 기여자
1. 기획 : 김영웅
2. 개발 : 김영웅, 박진상, 박성원
3. 검토 : 황석규
4. gitHub 관리 : 김영웅

## ERD
![image](https://github.com/user-attachments/assets/07dc41b7-6dd3-4047-9e3b-fdd77ebd91aa)

## API 명세서
![image](https://github.com/user-attachments/assets/fc4d6fee-ee71-4949-9b2e-f711839fc196)

## 트러블슈팅 TIL
#### URL : https://redbull97.tistory.com/23

