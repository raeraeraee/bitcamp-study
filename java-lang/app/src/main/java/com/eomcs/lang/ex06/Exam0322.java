package com.eomcs.lang.ex06;

//# 흐름 제어문 - break와 continue 활용
//
public class Exam0322 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;

    // 1부터 100까지의 카운트를 하는데 단 합은 50까지만 계산한다.
    // => break 사용 전
    count = 0;
    sum = 0;
    while (count < 100) {//// count가 100보다 작을 때까지 반복합니다.
      count++;
      if (count > 50) // 50을 넘어가면 합을 수행하지 않지만 100까지 계속 반복한다.
        continue;
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

    //// 즉, count 변수가 50을 초과하는 경우에는
    //// sum에 count 값을 더하지 않고 다음 반복으로 건너뛰게 됩니다.
    //// 하지만 이 경우에도 100까지 반복은 계속됩니다.

    System.out.println("------------------------");

    // => break 사용 후
    count = 0;
    sum = 0;
    while (count < 100) {//// count가 100보다 작을 때까지 반복합니다.
      count++;
      if (count > 50)//// count가 50보다 큰지 확인
        break; // 즉시 반복문을 종료하고 나간다.
      sum += count;//// count 값을 더합니다
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

  }
}
