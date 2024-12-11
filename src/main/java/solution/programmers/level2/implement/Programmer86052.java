package solution.programmers.level2.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 * 빛의 경로 사이클
 */
public class Programmer86052 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"SL", "LR"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static boolean[][][] isVisited;
    static int X, Y;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0}; // 아래, 왼쪽, 위, 오른쪽 순
    static String[] GRID;
    static int[] solution(String[] grid) {
        GRID = grid;
        List<Integer> answer = new ArrayList<>();
        X = grid.length;
        Y = grid[0].length();
        isVisited = new boolean[X][Y][4];

        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[x][y][d]) {
                        answer.add(countCycle(x, y , d));
                    }
                }
            }
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    static int countCycle(int x, int y, int d) {
        int cnt = 0;

        while (true) {
            if (isVisited[x][y][d]) {
                break;
            }

            cnt++;
            isVisited[x][y][d] = true;

            if (GRID[x].charAt(y) == 'L') {
                d = (d + 3) % 4;
            } else if (GRID[x].charAt(y) == 'R') {
                d = (d + 1) % 4;
            }

            x = (x + dx[d] + X) % X;
            y = (y + dy[d] + Y) % Y;
        }

        return cnt;
    }
}
