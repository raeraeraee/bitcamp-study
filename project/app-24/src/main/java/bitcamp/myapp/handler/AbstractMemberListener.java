package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public abstract class AbstractMemberListener implements ActionListener {

  protected List list;

  public AbstractMemberListener(List<Member> list) {
    this.list = list;
  }

  protected static String toGit_pushString(char git_push) {
    return git_push == 'Y' ? "했다" : "안 했다";
  }

    protected static String toProgrammerString(char programmers) {
    return programmers == 'Y' ? "했다" : "안 했다";
  }

  protected Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  protected char inputGit_push(char git_push, BreadcrumbPrompt prompt) {
    String label;
    if (git_push == 0) {
      label = "깃 잔디?\n";
    } else {
      label = String.format("깃 잔디(%s)?\n", toGit_pushString(git_push));
    }

    while (true) {
      String menuNo = prompt.inputString(label +
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

    protected char inputProgrammers(char programmers, BreadcrumbPrompt prompt) {
    String label;
    if (programmers == 0) {
      label = "프로그래머스?\n";
    } else {
      label = String.format("프로그래머스(%s)?\n", toProgrammerString(programmers));
    }

    while (true) {
      String menuNo = prompt.inputString(label +
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
}


