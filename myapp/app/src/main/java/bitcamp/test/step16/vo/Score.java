package bitcamp.test.step16.vo;

public class Score {
  private String name;
  public int kor;
  public int eng;
  public int math;
  private int sum;
  private float aver;

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

  // getter
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  public String getName() {
    return this.name;
  }
}