package solution.programmers.level2.implement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/258711
 * 도넛과 막대 그래프
 */
public class Programmers258711 {
    public static void main(String[] args) {
        int[] solution1 = solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}});
        System.out.println("solution1 = " + Arrays.toString(solution1));
        int[] solution2 = solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}});
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for (int[] edge : edges) {
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        }

        // 8자 그래프, 생성 정점 개수 구하기
        for (Integer outKey : out.keySet()) {
            if (out.get(outKey) > 1) {
                if (!in.containsKey(outKey)) {
                    answer[0] = outKey;
                } else {
                    answer[3]++;
                }
            }
        }
        
        // 막대 그래프 개수 구하기
        for (Integer inKey : in.keySet()) {
            if (!out.containsKey(inKey)) {
                answer[2]++;
            }
        }

        answer[1] = out.get(answer[0]) - answer[2] - answer[3];

        return answer;
    }
}
