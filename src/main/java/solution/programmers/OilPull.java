package solution.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * 석유 시츄
 */
public class OilPull {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
        System.out.println("solution = " + solution);
    }

    private static int[][] Land;
    private static int m;
    private static int n;
    private static boolean[][] used;
    private static int[] totalCnt;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] land) {
        Land = land;
        m = land.length;
        n = land[0].length;
        used = new boolean[m][n];
        totalCnt = new int[n];

        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        return Arrays.stream(totalCnt).max().orElse(0);
    }

    public static void bfs(int b) {
        for (int i = 0; i < m; i++) {
            HashSet<Integer> usedCol = new HashSet<>();
            int area = 0;
            Queue<Node> q = new LinkedList<>();

            if (used[i][b] || Land[i][b] == 0) {
                continue;
            }

            q.add(new Node(i, b));
            used[i][b] = true;
            usedCol.add(b);
            area++;

            while (!q.isEmpty()) {
                Node now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    if (!used[nx][ny] && Land[nx][ny] == 1) {
                        q.add(new Node(nx, ny));
                        used[nx][ny] = true;
                        usedCol.add(ny);
                        area++;
                    }
                }
            }

            for (Integer j : usedCol) {
                totalCnt[j] += area;
            }
        }
    }

    /*// 효율성 검사 실패 코드
    public static int bfs(int b) {
        int result = 0;
        for (int i = 0; i < m; i++) {
            Queue<Node> q = new LinkedList<>();

            // 세로 줄에서 세지 않은 위치 큐에 넣기
            if (!used[i][b] && Land[i][b] == 1) {
                q.add(new Node(i, b));
                used[i][b] = true;
                result++;
            }

            while (!q.isEmpty()) {
                Node now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    if (!used[nx][ny] && Land[nx][ny] == 1) {
                        q.add(new Node(nx, ny));
                        used[nx][ny] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }*/

    public static class Node {
        int x,y;

        public Node(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }
}
