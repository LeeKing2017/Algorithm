package solution.programmers.level2.implement;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 연속 부분 수열 합의 개수
 */
public class Programmers131701 {
    public static void main(String[] args) {
        int solution = solution(new int[]{7, 9, 1, 1, 4});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] elements) {
        HashSet<Integer> answer = new HashSet<>();
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i ; j < i + n; j++) {
                temp += elements[j % n];
                answer.add(temp);
            }
        }

        return answer.size();
    }

}
