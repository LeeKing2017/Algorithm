package solution.programmers.level2.implement;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 * 요격 시스템
 */
public class Programmers181188 {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int before = 0;
        for (int[] target : targets) {
            if (before <= target[0]) {
                before = target[1];
                answer++;
            }
        }
        return answer;
    }
}
