package solution.programmers.level0;
import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120861
 * 캐릭터의 좌표
 */
public class Programmers120861 {
    static class Solution {

        public int[] solution(String[] keyinput, int[] board) {
            int[] answer = new int[]{0, 0};
            HashMap<String, Integer[]> key = new HashMap<>();
            key.put("right", new Integer[]{1, 0});
            key.put("left", new Integer[]{-1, 0});
            key.put("up", new Integer[]{0, 1});
            key.put("down", new Integer[]{0, -1});

            for(String input : keyinput) {
                int nx = answer[0] + key.get(input)[0];
                int ny = answer[1] + key.get(input)[1];

                if (Math.abs(nx) > board[0] / 2 || Math.abs(ny) > board[1] / 2) {
                    continue;
                }

                answer[0] = nx;
                answer[1] = ny;
            }

            return answer;
        }
    }
}
