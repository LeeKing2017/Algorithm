package solution.programmers.level2.implement;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 시소 짝꿍
 */
public class Programmers152996 {
    public static void main(String[] args) {
        long solution = solution(new int[]{100, 180, 360, 100, 270});
        System.out.println("solution = " + solution);
    }

    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        HashMap<Double, Integer> w = new HashMap<>();

        for (int weight : weights) {
            double a = weight * 1.0;
            double b = weight * 2.0 / 3.0;
            double c = weight * 3.0 / 4.0;
            double d = weight * 2.0 / 4.0;

            if (w.containsKey(a)) {
                answer += w.get(a);
            }
            if (w.containsKey(b)) {
                answer += w.get(b);
            }
            if (w.containsKey(c)) {
                answer += w.get(c);
            }
            if (w.containsKey(d)) {
                answer += w.get(d);
            }

            w.put(weight * 1.0, w.getOrDefault(weight * 1.0, 0) + 1);
        }
        return answer;
    }
}
