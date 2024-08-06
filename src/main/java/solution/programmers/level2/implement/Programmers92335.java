package solution.programmers.level2.implement;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=java
 * k진수에서 소수 개수 구하기
 */
public class Programmers92335 {
    public static void main(String[] args) {
        solution(110011, 10);
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String[] nums = Integer.toString(n, k).split("0");

        for (String num : nums) {
            if (!num.isEmpty() && isPrimeNum(Long.parseLong(num))) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrimeNum(long num) {
        if (num == 1) return false;
        long maxI = (long) Math.sqrt(num) + 1;

        for (int i = 2; i < maxI; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
