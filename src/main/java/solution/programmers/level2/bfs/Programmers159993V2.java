package solution.programmers.level2.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * 미로 찾기
 */
public class Programmers159993V2 {
    public static void main(String[] args) {
        int solution1 = solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
        System.out.println("solution = " + solution1);
        int solution2 = solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"});
        System.out.println("solution = " + solution2);
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static String[][] map;
    private static boolean[][] isVisited;
    private static Node LEVER;
    private static Node START;
    private static final int BLOCKED = -1;
    public static int solution(String[] maps) {
        initValue(maps);
        int leverDistance = bfs(START, "L");
        isVisited = new boolean[maps.length][maps[0].length()];
        int leverToEndDistance = bfs(LEVER, "E");

        return isAvailable(leverDistance, leverToEndDistance) ? leverDistance + leverToEndDistance : -1;
    }

    private static void initValue(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        isVisited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            String[] split = maps[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("S")) {
                    START = new Node(i, j, 0);
                }

                if (split[j].equals("L")) {
                    LEVER = new Node(i, j, 0);
                }

                map[i][j] = split[j];
            }
        }
    }

    private static int bfs(Node start, String end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        isVisited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (map[now.x][now.y].equals(end)) {
                return now.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }

                if (!isVisited[nx][ny] && !map[nx][ny].equals("X")) {
                    q.add(new Node(nx, ny, now.distance + 1));
                    isVisited[nx][ny] = true;
                }
            }
        }

        return BLOCKED;
    }

    private static boolean isAvailable(int leverDistance, int leverToEndDistance) {
        return leverDistance != BLOCKED && leverToEndDistance != BLOCKED;
    }

    public static class Node {
        int x,y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}