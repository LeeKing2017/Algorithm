package solution.programmers;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 * 점프와 순간 이동
 */
public class Jump {
    public static class Solution {
        public int solution(int n) {
            int ans = n % 2 == 0 ? 0 : 1;

            while (n != 1) {
                n /= 2;

                if (n % 2 == 1) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
