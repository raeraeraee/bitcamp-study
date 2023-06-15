package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

// MemberHandler는 Handler 규칙에 따라 메서드를 구현했다.
// 즉 Handler 인터페이스에 선언된 메서드를 모두 정의했다.
public class MemberHandler implements Handler {

  private static final int MAX_SIZE = 100;

  private Prompt prompt;
  private Member[] members = new Member[MAX_SIZE];
  private int length;
  private String title;

  public MemberHandler(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  // Handler 인터페이스에 선언된 대로 메서드를 정의했다.
  // => "Handler 인터페이스를 구현했다."라고 표현한다.
  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("%s> ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputMember();
      } else if (menuNo.equals("2")) {
        this.printMembers();
      } else if (menuNo.equals("3")) {
        this.viewMember();
      } else if (menuNo.equals("4")) {
        this.updateMember();
      } else if (menuNo.equals("5")) {
        this.deleteMember();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  private static void printMenu() {
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 메인");
  }

  private void inputMember() {
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

  private void printMembers() {
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

  private void viewMember() {
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

  private void updateMember() {
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

  private void deleteMember() {
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
