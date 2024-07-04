package solution.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12933
 * 정수 내림차순으로 배치하기
 */
public class LongSort {
    public static void main(String[] args) {
        long solution = solution(118372);
        System.out.println("solution = " + solution);
    }

    private static long solution(long n) {
        String[] st = String.valueOf(n).split("");
        Arrays.sort(st, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s : st) {
            sb.append(s);
        }

        return Long.parseLong(sb.toString());
    }
}
