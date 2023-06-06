package bitcamp.myapp;

public class App {
    public static void main(String[] args) {
        System.out.println("나의 할 일 관리 시스템");
        System.out.println("----------------------------------");

        int no = 10;
        String name = "홍길동";
        boolean git_push = true;
        char programmers = 'Y';

        System.out.printf("번호: %d\n", no);
        System.out.printf("이름: %s\n", name);
        System.out.printf("깃 잔디: %b\n", git_push);
        System.out.printf("프로그래머스(했다(Y), 안 했다(N)): %c\n", programmers);
    }
}
