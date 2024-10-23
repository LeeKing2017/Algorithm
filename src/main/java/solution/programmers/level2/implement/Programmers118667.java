package solution.programmers.level2.implement;

import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * 두 큐 합 같게 만들기
 */
public class Programmers118667 {
    public static void main(String[] args) {
        int solution1 = solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        System.out.println("solution = " + solution1);
        int solution2 = solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println("solution = " + solution2);
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> aQ = new LinkedList<>();
        Queue<Integer> bQ = new LinkedList<>();
        long aSum = 0;
        long bSum = 0;

        for (int i = 0; i < queue1.length; i++) {
            int now = queue1[i];
            aQ.add(now);
            aSum += now;
        }

        for (int i = 0; i < queue2.length; i++) {
            int now = queue2[i];
            bQ.add(now);
            bSum += now;
        }

        while(aSum != bSum) {
            if (aQ.isEmpty() || bQ.isEmpty()) {
                return -1;
            }

            if (aSum > bSum) {
                int now = aQ.poll();
                bQ.add(now);
                aSum -= now;
                bSum += now;
                answer++;
            }

            if (aSum < bSum) {
                int now = bQ.poll();
                aQ.add(now);
                bSum -= now;
                aSum += now;
                answer++;
            }
        }

        return answer;
    }
}
