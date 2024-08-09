package solution.programmers.level1.implement;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963?language=java
 * 추억 점수
 */
public class Programmers176963 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> people = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            people.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j< photo[i].length; j++) {
                if (people.containsKey(photo[i][j])) {
                    sum += people.get(photo[i][j]);
                }

            }
            answer[i] = sum;
        }

        return answer;
    }
}
