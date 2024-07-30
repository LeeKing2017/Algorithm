package solution.programmers.level3;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987?language=java
 * 숫자 게임
 */
public class Programmers12987 {
    public static void main(String[] args) {
        int solution = solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8});
        System.out.println("solution = " + solution);
    }
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int idx = B.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = A.length - 1; i >= 0; i--) {
            if (B[idx] > A[i]) {
                answer++;
                idx--;
            }
        }
        return answer;
    }
}
