package solution.programmers.level2.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 게임 맵 최단거리
 */
public class Programmers1844{
    private static boolean[][] isVisited;
    private static int[] dx = {-1 , 1, 0, 0};
    private static int[] dy = {0 , 0, 1, -1};
    private static int X;
    private static int Y;
    private static final int BLOCKED = 0;

    public static void main(String[] args) {
        int solution = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] maps) {
        X = maps.length;
        Y = maps[0].length;
        isVisited = new boolean[X][Y];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        isVisited[0][0] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y || maps[nx][ny] == BLOCKED) {
                    continue;
                }

                if (isVisited[nx][ny]) {
                    continue;
                }

                isVisited[nx][ny] = true;
                maps[nx][ny] = maps[now.x][now.y] + 1;
                q.add(new Node(nx, ny));
            }
        }

        return maps[X - 1][Y - 1] == 1 ? -1 : maps[X - 1][Y - 1];
    }

    private static class Node {
        private int x, y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
