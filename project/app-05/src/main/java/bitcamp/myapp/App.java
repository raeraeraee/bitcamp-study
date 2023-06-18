package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("나의 할 일 관리 시스템");
        System.out.println("----------------------------------");

        // 키보드 스캐너 준비
        Scanner scanner = new Scanner(System.in);

        final int SIZE = 10;

        int[] no = new int[SIZE];
        String[] name = new String[SIZE];
        boolean[] git_push = new boolean[SIZE];
        char[] programmers = new char[SIZE];

        for (int i = 0; i < SIZE; i++) {
            System.out.print("번호? ");
            no[i] = scanner.nextInt();

            System.out.print("이름? ");
            name[i] = scanner.next();

            System.out.print("깃 잔디(true/false)? ");
            git_push[i] = scanner.nextBoolean();

            System.out.print("프로그래머스(했다:Y, 안 했다:N)? ");
            String str = scanner.next();
            programmers[i] = str.charAt(0);
        }

        System.out.println("---------------------------------------");

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("번호: %d\n", no[i]);
            System.out.printf("이름: %s\n", name[i]);
            System.out.printf("깃 잔디: %b\n", git_push[i]);
            System.out.printf("프로그래머스(했다(Y), 안 했다(N)): %c\n", programmers[i]);
        }
        scanner.close();
    }
}
