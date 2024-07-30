package solution.programmers.level2;

import java.io.*;
import java.util.*;
import java.util.Stack;

public class SequenceVisit {

    static int grid, mustVisitCnt;
    static int[] gx = {1, -1, 0, 0};
    static int[] gy = {0, 0, 1, -1};
    static int[][] graph;
    static boolean[][] visited;
    static Point[] mustVisitPoint;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        grid = Integer.parseInt(st.nextToken());
        mustVisitCnt = Integer.parseInt(st.nextToken());
        graph = new int[grid][grid];
        visited = new boolean[grid][grid];
        mustVisitPoint = new Point[mustVisitCnt];

        for(int i = 0;i < grid; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0;j < grid; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i < mustVisitCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            mustVisitPoint[i] = new Point(x, y);
        }

        dfs(mustVisitPoint[mustVisitCnt - 1].getX(), mustVisitPoint[mustVisitCnt - 1].getY());
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        java.util.Stack<Point> stack = new Stack<>();
        stack.add(new Point(x, y));
        visited[x][y] = true;

        while(!stack.isEmpty()) {
            Point current = stack.pop();
            if(current.equals(mustVisitPoint[mustVisitCnt - 1])) {
                answer++;
            }

            int cx = current.getX();
            int cy = current.getY();

            for(int i = 0; i < gx.length; i++) {
                int nx = cx + gx[i];
                int ny = cy + gy[i];

                if(!isValidPath(nx, ny)) {
                    continue;
                }

                visited[nx][ny] = true;
                stack.add(new Point(nx, ny));
            }
        }
    }

    private static boolean isValidPath(int nx, int ny) {
        return !(nx < 0 || nx >= grid || ny < 0 || ny >= grid || visited[nx][ny] || graph[nx][ny] == 1);
    }

    private static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
