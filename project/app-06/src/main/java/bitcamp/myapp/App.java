package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("나의 할 일 관리 시스템");
        System.out.println("----------------------------------");

        // 키보드 스캐너 준비
        Scanner scanner = new Scanner(System.in);

        final int MAX_SIZE = 100;
        int userId = 1;
        int length = 0;

        int[] no = new int[MAX_SIZE];
        String[] name = new String[MAX_SIZE];
        char[] git_push = new char[MAX_SIZE];
        char[] programmers = new char[MAX_SIZE];

        // 회원정보 등록
        for (int i = 0; i < MAX_SIZE; i++) {

            System.out.print("이름? ");
            name[i] = scanner.next();

            loop: while (true) {
                System.out.println("깃 잔디: ");
                System.out.println("  1. 했다");
                System.out.println("  2. 안 했다");
                System.out.print("> ");
                String menuNo = scanner.next();

                switch (menuNo) {
                    case "1":
                        git_push[i] = 'Y';
                        break loop;
                    case "2":
                        git_push[i] = 'N';
                        break loop;
                    default:
                        System.out.println("무효한 번호입니다.");
                }
            }

            loop: while (true) {
                System.out.println("프로그래머스: ");
                System.out.println("  1. 했다");
                System.out.println("  2. 안 했다");
                System.out.print("> ");
                String menuNo = scanner.next();

                // if (menuNo.equals("1")) {
                // gender[i] = 'M';
                // break;
                // } else if (menuNo.equals("2")) {
                // gender[i] = 'W';
                // break;
                // } else {
                // System.out.println("무효한 번호입니다.");
                // }

                switch (menuNo) {
                    case "1":
                        programmers[i] = 'Y';
                        break loop;
                    case "2":
                        programmers[i] = 'N';
                        break loop;
                    default:
                        System.out.println("무효한 번호입니다.");
                }
            }

            no[i] = userId++;

            length++;

            System.out.print("계속 하시겠습니까?(Y/n) ");
            scanner.nextLine(); // 이전에 next()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.
            String response = scanner.nextLine();
            if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.println("---------------------------------------");

        System.out.println("번호, 이름, 깃 잔디, 프로그래머스");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %s, %c\n", no[i], name[i], git_push[i], programmers[i]);
        }
        scanner.close();
    }
}
