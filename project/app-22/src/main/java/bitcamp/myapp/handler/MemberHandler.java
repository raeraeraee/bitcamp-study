package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.List;
import bitcamp.util.MenuPrompt;

public class MemberHandler implements Handler {

  private List list;
  private MenuPrompt prompt;
  private String title;

  public MemberHandler(MenuPrompt prompt, String title, List list) {
    this.prompt = prompt;
    this.title = title;
    this.list = list;
  }

  public void execute() {

    prompt.appendBreadcrumb(this.title, getMenu());

    prompt.printMenu();

    while (true) {
      String menuNo = prompt.inputMenu();
      switch (menuNo) {
        case "0": prompt.removeBreadcrumb(); return;
        case "1": this.inputMember(); break;
        case "2": this.printMembers(); break;
        case "3": this.viewMember(); break;
        case "4": this.updateMember(); break;
        case "5": this.deleteMember(); break;
      }
    }
  }

  private static String getMenu() {
    StringBuilder menu = new StringBuilder();
    menu.append("1. 등록\n");
    menu.append("2. 목록\n");
    menu.append("3. 조회\n");
    menu.append("4. 변경\n");
    menu.append("5. 삭제\n");
    menu.append("0. 메인\n");
    return menu.toString();
  }

  private void inputMember() {
    Member m = new Member();
    m.setName(this.prompt.inputString("이름? "));
    m.setGit_push(inputGit_push((char) 0));
    m.setProgrammers(inputProgrammers((char) 0));

    this.list.add(m);
  }

  private void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 깃 잔디, 프로그래머스");
    System.out.println("---------------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d, %s, %s, %s\n",
          m.getNo(), m.getName(),
          toGit_pushString(m.getGit_push()),
          toProgrammerString(m.getProgrammers()));
    }
  }

  private void viewMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("깃 잔디: %s\n", toGit_pushString(m.getGit_push()));
    System.out.printf("프로그래머스: %s\n", toProgrammerString(m.getProgrammers()));
  }
  
  private static String toGit_pushString(char git_push) {
    return git_push == 'Y' ? "했다" : "안 했다";
  }

  private static String toProgrammerString(char programmers) {
    return programmers == 'Y' ? "했다" : "안 했다";
  }

  private void updateMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
    m.setGit_push(inputGit_push(m.getGit_push()));
    m.setProgrammers(inputProgrammers(m.getProgrammers()));
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
    if (!this.list.remove(new Member(this.prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }

  private Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

}
