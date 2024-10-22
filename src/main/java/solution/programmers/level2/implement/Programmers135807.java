package solution.programmers.level2.implement;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * 숫자 카드 나누기
 */
public class Programmers135807 {
    public static void main(String[] args) {
        int gcd = solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});
        System.out.println("gcd = " + gcd);
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int aGcd = findGcd(arrayA);
        if (isNotCanDivide(aGcd, arrayB)) {
            answer = Math.max(answer, aGcd);
        }

        int bGcd = findGcd(arrayB);
        if (isNotCanDivide(bGcd, arrayA)) {
            answer = Math.max(answer, bGcd);
        }

        return answer;
    }

    public static boolean isNotCanDivide(int gcd, int[] nums) {
        return Arrays.stream(nums)
                .noneMatch(num -> num % gcd == 0);
    }

    public static int findGcd(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result = findGcd(nums[i], result);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    public static int findGcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
