package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static char[] git_push = new char[MAX_SIZE];
  static char[] programmers = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char Yes = 'Y';
  static final char No = 'N';

  public static void inputMember() {
    name[length] = Prompt.inputString("이름? ");

    loop: while (true) {
      String menuNo = Prompt.inputString("깃 잔디:\n" + 
      "  1. 했다\n" + 
      "  2. 안 했다\n" + 
      "> ");

      switch (menuNo) {
        case "1":
        git_push[length] = Yes;
          break loop;
        case "2":
        git_push[length] = No;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    loop: while (true) {
      String menuNo = prompt("프로그래머스:\n" +
              "  1. 했다\n" +
              "  2. 안 했다\n" +
              "> ");

      switch (menuNo) {
          case "1":
              programmers[length] = Yes;
              break loop;
          case "2":
              programmers[length] = No;
              break loop;
          default:
              System.out.println("무효한 번호입니다.");
      }
  }
    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 깃허브, 프로그래머스");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], git_push[i], programmers[i]);
    }
  }

  public static boolean available() {
    return length < MAX_SIZE;
  }
}
