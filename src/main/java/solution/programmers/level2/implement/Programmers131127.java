package solution.programmers.level2.implement;

import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * 할인 행사
 */
public class Programmers131127 {
    public static void main(String[] args) {
        int solution = solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println(solution);
    }
    static int DAYS = 10;
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - DAYS + 1; i++) {
            HashMap<String, Integer> dayMap = new HashMap<>();

            for (int day = 0; day < DAYS; day++) {
                String dayItem = discount[i + day];
                dayMap.put(dayItem, dayMap.getOrDefault(dayItem, 0) + 1);
            }

            boolean isCorrect = true;
            for (String item : wantMap.keySet()) {
                if (wantMap.get(item) != dayMap.get(item)) {
                    isCorrect = false;
                    break;
                }
            }

            answer = isCorrect ? answer + 1 : answer;
        }

        return answer;
    }
}
