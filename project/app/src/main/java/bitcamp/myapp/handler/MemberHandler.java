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
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    name[length] = Prompt.inputString("이름? ");
    git_push[length] = inputgit_push((char) 0);
    programmers[length] = inputprogrammers((char) 0);

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 깃잔디, 프로그래머스");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s\n, %s\n",
          no[i], name[i],
          togit_pushString(git_push[i]),
      toprogrammersString(programmers[i]));

    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("깃 잔디: %s\n", togit_pushString(git_push[i]));
        System.out.printf("프로그래머스: %s\n", toprogrammersString(git_push[i]));

        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String togit_pushString(char git_push) {
    return git_push == 'Y' ? "했다" : "안 했다";
  }

  public static String toprogrammersString(char programmers) {
  return programmers == 'Y' ? "했다" : "안 했다";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
        if (no[i] == Integer.parseInt(memberNo)) {
            System.out.printf("이름(%s)? ", name[i]);
            name[i] = Prompt.inputString("");
            git_push[i] = inputgit_push(git_push[i]);
            programmers[i] = inputprogrammers(programmers[i]);
            return;
        }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
}


  private static char inputgit_push(char git_push) {
    String label;
    if (git_push == 0) {
      label = "깃잔디?\n";
    } else {
      label = String.format("깃잔디(%s)?\n", togit_pushString(git_push));
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
        label = String.format("프로그래머스(%s)?\n", new String(toprogrammersString(programmers)));
    }
    
    while (true) {
        String menuNo = Prompt.inputString(label +
                " 1. 했다\n" +
                " 2. 안 했다\n" +
                "> ");
        
        switch (menuNo) {
            case "1":
                return 'Y';
            case "2":
                return 'N';
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
      no[i] = no[i + 1];
      name[i] = name[i + 1];
      git_push[i] = git_push[i + 1];
      programmers[i] = programmers[i + 1];
    }

    no[length - 1] = 0;
    name[length - 1] = null;
    git_push[length - 1] = (char) 0;
    programmers[length - 1] = (char) 0;

    length--;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      if (no[i] == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}