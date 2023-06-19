package bitcamp.myapp.vo;

public class Member {

  // 모든 인스턴스가 공유하는 값은 스태틱 필드에 보관한다.
  private static int userId = 1;

  // 상수는 스태틱 필드로 정의한다.
  // 정보를 다룰 떄는 그 정보를 갖고 있는 클래스에 그 기능을 둔다.
  // => 필드도 마찬가지다.
  // GRASP 패턴 : Information Expert
  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  public Member() {
    this.no = userId++;
  }

  // 같은 기능을 수핸하는 생성자가 위에 있다.
  // 다만 파라미터가 다를 뿐이다.
  // => "생성자 오버로딩(overriding)"
  public Member(int no) {
    this.no = no;
  }

  // Object의 equals()는 Member 인스턴스를 비교하는대 적합하지 않다.
  // 왜? Object의 equals()는 단순히 인스턴스 주소가 같은지 비교하기 떄문이다.
  // 우리가 원하는 것은 인스턴스 주소가 다르더라도
  // 두 인스턴스 안에 저장된 변수들의 값이 같다면
  // 두 인스턴스는 같은 것으로 처리하는 것이다.
  // 그렇게 하기 위해 수퍼 클래스의 equals()를 재정의 한다.
  // => 이것을 "오버라이딩(overriding)" 이라 부른단
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    // 위 조건에서 this가 가리키는 인스턴스의 클래스와
    // 파라미터 obj가 가리키는 인스턴스의 클래스가
    // 깉디고 결론이 났기 떄믄에 다음과 같이
    // obj를 Member타입으로 형변환한다.

    Member m = (Member) obj;
    if (this.getNo() != m.getNo()) {
      return false;
    }

    // if (this.getName() != null && !this.getName().equals(m.getName())) {
    // return false;
    // }
    //
    // if (this.getEmail() != null && !this.getEmail().equals(m.getEmail())) {
    // return false;
    // }
    //
    // if (this.getPassword() != null &&
    // !this.getPassword().equals(m.getPassword())) {
    // return false;
    // }
    //
    // if (this.getGender() != (m.getGender())) {
    // return false;
    // }

    return true;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

}
