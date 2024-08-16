package solution.programmers.level2.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 * 디펜스 게임
 */
public class Programmers142085 {
    public static void main(String[] args) {
        int solution = solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        System.out.println("solution = " + solution);
        int solution1 = solution(2, 4, new int[]{3, 3, 3, 3});
        System.out.println("solution1 = " + solution1);
    }
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(new Integer[]{1,2,3}, Collections.reverseOrder());

        for (int currentEn : enemy) {
            n -= currentEn;
            q.add(currentEn);

            if (n < 0) {
                if (k > 0) {
                    n += q.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}
