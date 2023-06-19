package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberHandler {

  private static final int MAX_SIZE = 100;
  // variable initializer(변수초기화 문장) => static 블록으로 이동
  // 단 final 변수는 static 블록에서 값을 할당하지 않고 그냥 상수로 취급한다.

  private Prompt prompt;

  private Member[] members = new Member[MAX_SIZE];
  // variable initializer(변수초기화 문장) => 생성자로 이동

  private int length;

  // 생성자: 인스턴스를 사용할 수 있도록 유효한 값으로 초기화시키는 일을 한다.
  // => 필요한 값을 외부에서 받고 싶으면 파라미터를 선언하라.
  public MemberHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void inputMember() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(this.prompt.inputString("이름? "));
    m.setGit_push(inputGit_push((char) 0));
    m.setProgrammers(inputProgrammers((char) 0));

    this.members[this.length++] = m;
  }

  public void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 깃 잔디, 프로그래머스");
    System.out.println("---------------------------------------");

    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      System.out.printf("%d, %s, %s, %s\n",
          m.getNo(), m.getName(),
          toGit_pushString(m.getGit_push()),
          toProgrammerString(m.getProgrammers()));

    }
  }

  public void viewMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("깃 잔디: %s\n", toGit_pushString(m.getGit_push()));
        System.out.printf("프로그래머스: %s\n", toProgrammerString(m.getProgrammers()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGit_pushString(char git_push) {
    return git_push == 'Y' ? "했다" : "안 했다";
  }

  public static String toProgrammerString(char programmers) {
    return programmers == 'Y' ? "했다" : "안 했다";
  }

  public void updateMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
        m.setGit_push(inputGit_push(m.getGit_push()));
        m.setProgrammers(inputProgrammers(m.getProgrammers()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private char inputGit_push(char git_push) {
    String label;
    if (git_push == 0) {
      label = "깃 잔디?\n";
    } else {
      label = String.format("깃 잔디(%s)?\n", toGit_pushString(git_push));
    }
    while (true) {
      String menuNo = this.prompt.inputString(label +
          "  1. 했다\n" +
          "  2. 안 했다\n" +
          "> ");

      switch (menuNo) {
        case "1":
          return Member.Yes;
        case "2":
          return Member.No;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private char inputProgrammers(char programmers) {
    String label;
    if (programmers == 0) {
      label = "프로그래머스?\n";
    } else {
      label = String.format("프로그래머스(%s)?\n", toProgrammerString(programmers));
    }
    while (true) {
      String menuNo = this.prompt.inputString(label +
          "  1. 했다\n" +
          "  2. 안 했다\n" +
          "> ");

      switch (menuNo) {
        case "1":
          return Member.Yes;
        case "2":
          return Member.No;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public void deleteMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }

    this.members[--this.length] = null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
