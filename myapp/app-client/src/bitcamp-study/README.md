# 실습 프로젝트

## 1. 자바 프로젝트 준비하기

- Gradle 빌드 도구를 이용하여 프로젝트 폴더를 구성하는 방법
  - `init` task 실행
- Gradle로 프로젝트를 빌드하고 실행하는 방법
  - `build`, `run` task 실행

## 2. 리터럴을 사용하여 데이터 출력하기

- 리터럴을 사용하는 방법

## 3. 변수를 사용하여 데이터를 저장하기

- 변수를 사용하는 방법

## 4. 키보드로 값을 입력 받기

- 키보드로 값을 입력 받는 방법

## 5. 배열과 반복문을 이용하여 여러 개의 데이터를 입력 받기

- 배열 활용
- 반복문 활용
- 상수 활용

## 6. 조건문을 활용하여 실행 흐름을 제어하기

- if ~ else ~ 조건문 활용
- switch 활용
- break 활용 
- while 활용

## 7. 기능 단위로 명령문 묶기 : 메서드 사용법

- static 메서드를 정의하고 호출하는 방법 

## 8. 메서드 간에 변수 공유하기 : 스태틱 변수 사용법

- static 변수를 정의하고 사용하는 방법
- 리팩토링
  - 사용자에게서 입력 받는 기능을 메서드로 분리하여 정의(메서드 문법 활용)
  - 남, 녀 식별 값을 상수로 선언(final 문법 활용)

## 9. 메서드를 역할에 따라 분류하기 : 클래스 및 패키지 사용법

- 클래스 및 패키지 사용법(스태틱 클래스)
- import 명령문 사용법
- public 접근 제어 사용법
- 스태틱 변수가 생성되고 제거되는 시점, 메모리 영역
 
## 10. 메뉴 구성 및 CRUD 구현

- 회원정보를 다루는 메뉴 구성하기
- 회원정보 조회 및 변경, 삭제 구현하기

## 11. 사용자 정의 데이터 타입 만들기

- 클래스 문법을 이용하여 데이터 타입을 정의하는 방법
- 클래스를 이용하여 만든 데이터 타입의 메모리를 준비하는 방법: new 명령
- 클래스 배열 사용법
- 인스턴스와 인스턴스 필드, 힙(heap) 메모리의 관계

## 12. 생성자, 셋터, 겟터 도입하기

- 인스턴스 필드를 초기화시키는 방법: 생성자
- 인스턴스 필드에 직접 접근하는 것을 막는 방법: private
- 인스턴스 필드에 값을 저장하고 꺼내는 방법: setter/getter
- 스태틱 필드 및 생성자 활용
- 스태틱 상수 필드 활용 + GRASP 패턴의 Information Expert 

## 13. 복사/붙여넣기를 이용한 CRUD 구현

- 게시글 CRUD 기능 추가
- Value Object, Handler 클래스 추가
- Prompt 클래스 리팩토링

## 14. 스태틱 필드의 한계 확인

- BoardHandler 클래스를 복제하여 독서록 게시판 추가
- 클래스 코드 복제의 문제점 확인

## 15. 인스턴스 필드와 인스턴스 메서드, 생성자와 의존 객체 주입

- BoardHandler 클래스에 인스턴스 필드 및 메서드 적용
- 향후 확장성을 고려하여 MemberHandler 크래스에도 인스턴스 필드와 인스턴스 메서드를 적용
  - 그래서 실무에서는 대부분의 클래스가 인스턴스 필드와 인스턴스 메서드로 구성된다.
- 향후 확장성을 고려하여 Prompt 크래스에도 인스턴스 필드와 인스턴스 메서드를 적용
  - 생성자 도입: Scanner 사용할 입력 도구를 지정할 수 있게 한다.
- 의존 객체 주입의 개념과 구현
  - 생성자를 통해 Prompt 객체를 Handler에 주입