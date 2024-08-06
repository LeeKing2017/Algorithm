package solution.programmers.level2.dp;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 * 숫자 변환하기
 *
 */
public class Programmers154538 {
    public static void main(String[] args) {
        int solution1 = solution(10, 40, 5);
        System.out.println("solution1 = " + solution1);
        int solution2 = solution(10, 40, 30);
        System.out.println("solution1 = " + solution2);
        int solution3 = solution(2, 5, 4);
        System.out.println("solution1 = " + solution3);
    }

    public static int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        for (int i = x; i <= y; i++) {
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if (i * 2 <= y) {
                dp[i * 2] = dp[i * 2] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= y) {
                dp[i * 3] = dp[i * 3] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
            if (i + n <= y) {
                dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
        }

        return dp[y];
    }
}
