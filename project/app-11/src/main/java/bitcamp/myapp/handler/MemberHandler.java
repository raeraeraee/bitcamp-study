package bitcamp.myapp.handler;

import bitcamp.util.Prompt;
import bitcamp.myapp.vo.Member;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int userId = 1;
  static int length = 0;
  
  static final char Yes = 'Y';
  static final char No = 'N';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.name = Prompt.inputString("이름? ");
    m.git_push = inputgit_push((char)0);
    m.programmers = inputprogrammers((char)0);
    m.no = userId++;

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게 
    // 레퍼런스 배열에 담는다.
    members[length++] = m;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 깃 잔디, 프로그래머스");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n",
        m.no, m.name, 
        togit_pushString(m.git_push),
        toprogrammersString(m.programmers));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.name);
        System.out.printf("깃 잔디: %s\n", togit_pushString(m.git_push));
        System.out.printf("프로그래머스: %s\n", toprogrammersString(m.programmers));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String togit_pushString(char git_push) {
    return git_push == 'Y' ? "했다" : "안 했다";
  }

  public static String toprogrammersString(char programmers){
    return programmers == 'Y' ? "했다" : "안 했다";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)? ", m.name);
        m.name = Prompt.inputString("");
        m.git_push = inputgit_push(m.git_push);
        m.programmers = inputprogrammers(m.programmers);
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private static char inputgit_push(char git_push) {
    String label;
    if (git_push == 0) {
      label = "깃 잔디?\n";
    } else {
      label = String.format("깃 잔디(%s)?\n", togit_pushString(git_push));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label + 
      "  1. 했다\n" + 
      "  2. 안 했다\n" + 
      "> ");

      switch (menuNo) {
        case "1":
          return Yes;
        case "2":
          return No;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private static char inputprogrammers(char programmers) {
    String label;
    if (programmers == 0) {
      label = "프로그래머스?\n";
    } else {
      label = String.format("프로그래머스(%s)?\n", toprogrammersString(programmers));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label + 
      "  1. 했다\n" + 
      "  2. 안 했다\n" + 
      "> ");

      switch (menuNo) {
        case "1":
          return Yes;
        case "2":
          return No;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }


  public static void deleteMember() {
    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
