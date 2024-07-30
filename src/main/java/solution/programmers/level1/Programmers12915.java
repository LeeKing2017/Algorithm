package solution.programmers.level1;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 * 문자열 내 마음대로 정렬하기
 */
public class Programmers12915 {
    public static void main(String[] args) {
        String[] solution = solution(new String[]{"abce", "abcd", "cdx"}, 2);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> a.charAt(n) == b.charAt(n)
                ? a.compareTo(b)
                : Character.compare(a.charAt(n), b.charAt(n)));

        return strings;
    }
}
