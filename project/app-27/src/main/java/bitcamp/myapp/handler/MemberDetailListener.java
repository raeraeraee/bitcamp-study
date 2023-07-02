package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class MemberDetailListener extends AbstractMemberListener {

  public MemberDetailListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("깃 잔디: %s\n", toGit_pushString(m.getGit_push()));
    System.out.printf("프로그래머스: %s\n", toProgrammerString(m.getProgrammers()));
  }
}
