package bitcamp.myapp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_SIZE = 100;
        int userId = 1;
        int length = 0;

        int[] no = new int[MAX_SIZE];
        String[] name = new String[MAX_SIZE];
        char[] git_push = new char[MAX_SIZE];
        char[] programmers = new char[MAX_SIZE];

        printTitle();

        for (int i = 0; i < MAX_SIZE; i++) {
            inputMember(scanner, i, name, git_push, programmers, no, userId++);
            length++;
            if (!promptContinue(scanner)) {
                break;
            }
        }

        printMembers(length, no, name, git_push, programmers);

        scanner.close();
    }

    static void printTitle() {
        System.out.println("나의 할 일 관리 시스템");
        System.out.println("----------------------------------");
    }

    static void inputMember(Scanner scanner, int i,
            String[] name, char[] git_push, char[] programmers, int[] no, int userId) {

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
            String menuNo = scanner.next(); // 입력 값(token)을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.

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

        no[i] = userId;
    }

    static boolean promptContinue(Scanner scanner) {
        System.out.print("계속 하시겠습니까?(Y/n) ");
        String response = scanner.nextLine();
        if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
            return false;
        }
        return true;
    }

    static void printMembers(int length, int[] no, String[] name, char[] git_push, char[] programmers) {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %s, %c\n", no[i], name[i], git_push[i], programmers[i]);
        }
    }
}
