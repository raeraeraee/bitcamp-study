package bitcamp.myapp;

import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {

    public static void main(String[] args) {

        printTitle();

        printMenu();

        while (true) {
            String menuNo = Prompt.inputString("메인> ");
            if (menuNo.equals("6")) {
                break;
            } else if (menuNo.equals("menu")) {
                printMenu();
            } else if (menuNo.equals("1")) {
                MemberHandler.inputMember();
            } else if (menuNo.equals("2")) {
                MemberHandler.printMembers();
            } else if (menuNo.equals("3")) {
                MemberHandler.viewMember();
            } else if (menuNo.equals("4")) {
                MemberHandler.updateMember();
            } else if (menuNo.equals("5")) {
                MemberHandler.deleteMember();
            } else {
                System.out.println(menuNo);
            }
        }

        Prompt.close();
    }

    static void printMenu() {
        System.out.println("1. 할일등록");
        System.out.println("2. 할일목록");
        System.out.println("3. 할일조회");
        System.out.println("4. 할일수정");
        System.out.println("5. 할일삭제");
        System.out.println("6. 종료");
    }

    static void printTitle() {
        System.out.println("나의 할 일 관리 시스템");
        System.out.println("----------------------------------");
    }

    static boolean promptContinue() {
        String response = Prompt.inputString("계속 하시겠습니까?(Y/n) ");
        if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
            return false;
        }
        return true;
    }
}
