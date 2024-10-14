package solution.baekjoon;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1012
 * 백준 1012
 * 유기농 배추
 */
public class CabbageInsectCount {
    static int TEST_CNT, X, Y, CAB_CNT, AREA_CNT;
    static int[][] MAP;
    static boolean[][] VISITED;
    static List<Integer> RESULT = new ArrayList<>();
    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0 , 0, 1, -1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TEST_CNT = Integer.parseInt(st.nextToken());

        for (int t = 0; t < TEST_CNT; t++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            CAB_CNT = Integer.parseInt(st.nextToken());
            MAP = new int[X][Y];
            VISITED = new boolean[X][Y];

            for (int i = 0; i < CAB_CNT; i++) {
                st = new StringTokenizer(br.readLine());
                int cabbageX = Integer.parseInt(st.nextToken());
                int cabbageY = Integer.parseInt(st.nextToken());
                MAP[cabbageX][cabbageY] = 1;
            }

            for (int x = 0; x < X; x++) {
                bfs(x);
            }

            RESULT.add(AREA_CNT);
            AREA_CNT = 0;
        }

        for (Integer insectCnt : RESULT) {
            System.out.println(insectCnt);
        }
    }

    static void bfs(int x) {
        for (int y = 0; y < Y; y++) {
            if (VISITED[x][y] || MAP[x][y] == 0) {
                continue;
            }

            AREA_CNT++;
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(x, y));
            VISITED[x][y] = true;

            while(!q.isEmpty()) {
                Node now = q.poll();

                // 동서남북으로 네번 이동
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (isNotMovable(nx, ny)) {
                        continue;
                    }

                    q.add(new Node(nx, ny));
                    VISITED[nx][ny] = true;
                }
            }
        }
    }

    static boolean isNotMovable (int nx, int ny) {
        return nx < 0 || nx >= X || ny < 0 || ny >= Y || MAP[nx][ny] == 0 || VISITED[nx][ny];
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}