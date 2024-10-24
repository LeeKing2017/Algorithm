package solution.programmers.level2.implement;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131130
 * 혼자 놀기의 달인
 */
public class Programmers131130 {
    public static void main(String[] args) {
        int solution = solution(new int[]{2, 1, 4, 5, 3, 7, 8, 9, 6, 11, 12, 13, 14, 10});
        System.out.println("solution = " + solution);
    }

    static boolean[] used;
    public static int solution(int[] cards) {
        int groupCnt = 0;
        used = new boolean[cards.length];
        List<Integer> results = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < cards.length; i++) {
            if (used[i]) {
                continue;
            }
            q.add(cards[i] - 1);
            used[i] = true;
            groupCnt++;

            while(!q.isEmpty()) {
                int now = q.poll();

                if(used[now]) {
                    continue;
                }

                q.add(cards[now] - 1);
                used[now] = true;
                groupCnt++;
            }
            results.add(groupCnt);
            groupCnt = 0;
        }

        int answer = 0;
        if (results.size() != 1) {
            results.sort(Comparator.reverseOrder());
            answer = results.get(0) * results.get(1);
        }

        return answer;
    }
}
