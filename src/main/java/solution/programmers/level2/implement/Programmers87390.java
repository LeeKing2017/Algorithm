package solution.programmers.level2.implement;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * n^2 배열 자르기
 */
public class Programmers87390 {
    public static void main(String[] args) {
        int[] solution = solution(3, 2, 5);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int n, long left, long right) {
        int range = (int) (right - left);
        int[] answer = new int[range + 1];
        int idx = 0;

        for (long i = left; i <= right; i++) {
            int x = (int) (i / n);
            int y = (int) (i % n);
            answer[idx++] = x == y ? x + 1 : Math.max(x, y) + 1;
        }

        return answer;
    }
}
