package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class MemberUpdateListener extends AbstractMemberListener {

  public MemberUpdateListener(List<Member> list) {
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

    m.setName(prompt.inputString("이름(%s)? ", m.getName()));
    m.setPassword(prompt.inputString("새암호? "));
    m.setGit_push(inputGit_push(m.getGit_push(), prompt));
    m.setProgrammers(inputProgrammers(m.getProgrammers(), prompt));
  }

}
