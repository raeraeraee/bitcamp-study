package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Iterator;
import bitcamp.util.List;

public class MemberListListener extends AbstractMemberListener {

  public MemberListListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 깃 잔디, 프로그래머스");
    System.out.println("---------------------------------------");

    // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
    Iterator<Member> iterator = list.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s\n",
          m.getNo(), m.getName(),
          toGit_pushString(m.getGit_push()),
          toProgrammerString(m.getProgrammers()));
    }
  }

}
