package bitcamp.myapp.vo;

public class Member {

    private static int userId = 1;

    public static final char Yes = 'Y';
    public static final char No = 'N';

    private int no;
    private String name;
    private char git_push;
    private char programmers;

    public Member() {
        this.no = userId++;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGit_push() {
        return git_push;
    }

    public void setGit_push(char git_push) {
        this.git_push = git_push;
    }

    public char getProgrammers() {
        return programmers;
    }

    public void setProgrammers(char programmers) {
        this.programmers = programmers;
    }

}
