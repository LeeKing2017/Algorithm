package solution.programmers.level2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 무인도 여행
 */
public class Programmers154540 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    private static int[][] map;
    private static boolean[][] used;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int m;
    private static int n;
    public static int[] solution(String[] maps) {
        List<Integer> answerQ = new ArrayList<>();
        m = maps.length;
        n = maps[0].length();
        map = new int[m][n];
        used = new boolean[m][n];
        initMap(maps);

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 바다일 경우 스킵
                if (map[i][j] == -1) {
                    continue;
                }

                // 한번 갔다온 섬일 경우 스킵
                if (used[i][j]) {
                    continue;
                }

                q.add(new Node(i, j));
                int answerTemp = map[i][j];
                used[i][j] = true;
                while (!q.isEmpty()) {
                    Node now = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = now.x + dx[k];
                        int ny = now.y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                            continue;
                        }

                        if (!used[nx][ny] && map[nx][ny] != -1) {
                            q.add(new Node(nx, ny));
                            used[nx][ny] = true;
                            answerTemp += map[nx][ny];
                        }
                    }
                }
                answerQ.add(answerTemp);
            }
        }
        return calculateAnswer(answerQ);
    }

    private static void initMap(String[] args) {
        for (int i = 0; i < m; i++) {
            String[] split = args[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("X")) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.parseInt(split[j]);
                }
            }
        }
    }

    private static int[] calculateAnswer(List<Integer> answerQ) {
        return answerQ.isEmpty() ? new int[]{-1} : pollAnswerQ(answerQ);
    }

    private static int[] pollAnswerQ(List<Integer> answerQ) {
        return answerQ.stream().sorted(Comparator.naturalOrder()).mapToInt(Integer::intValue).toArray();
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
