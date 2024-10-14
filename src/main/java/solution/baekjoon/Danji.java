package solution.baekjoon;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2667
 * 백준 2667
 * 단지 번호 붙이기
 */
public class Danji {
    static int N;
    static int[][] MAP;
    static boolean[][] USED;
    static List<Integer> RESULT = new ArrayList<>();
    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0 , 0, 1, -1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];
        USED = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String areaInfo = st.nextToken();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(areaInfo.charAt(j) + "");
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        RESULT.sort(Comparator.naturalOrder());

        System.out.println(RESULT.size());

        for (Integer areaNum : RESULT) {
            System.out.println(areaNum);
        }
    }

    static void bfs(int x) {
        for (int y = 0; y < N; y++) {
            if (USED[x][y] || MAP[x][y] == 0) {
                continue;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(x, y));
            USED[x][y] = true;
            int area = 1;

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
                    USED[nx][ny] = true;
                    area++;
                }
            }
            // 인접한 단지 수 결과 리스트에 저장
            RESULT.add(area);
        }
    }

    static boolean isNotMovable (int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N || MAP[nx][ny] == 0 || USED[nx][ny];
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}